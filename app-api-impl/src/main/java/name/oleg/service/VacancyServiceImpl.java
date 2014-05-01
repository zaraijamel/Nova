package name.oleg.service;

import name.oleg.entity.*;
import name.oleg.search.*;
import name.oleg.map.Coordinate;
import org.apache.commons.lang3.Validate;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class VacancyServiceImpl implements VacancyService {
    private static final int SEARCH_PER_PAGE = 20;
    private static final int NEWEST_COUNT = 10;
    private static final int NEAREST_COUNT = 10;
    private static final int TAGS_COUNT = 20;

    @Autowired
    private VacancyRepository vacancyRepository;

    @Override
    public void add(Vacancy vacancy) {
        Validate.notNull(vacancy);
        vacancyRepository.save(vacancy);
    }

    @Override
    public void add(Collection<Vacancy> vacancies) {
        vacancyRepository.save(vacancies);
    }

    @Override
    public void delete(Vacancy vacancy) {
        vacancyRepository.delete(vacancy);
    }

    @Override
    public List<Vacancy> findAll() {
        return vacancyRepository.findAll();
    }

    @Override
    public Vacancy findById(long id) {
        return vacancyRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vacancy> findByTitle(String title) {
        return vacancyRepository.findVacancyByTitle(title);
    }

    @Override
    public Page<Vacancy> find(int page, VacancySearchParam vacancySearchParam) {
        Validate.isTrue(page >= 0);
        Validate.notNull(vacancySearchParam);

        PageRequest pageRequest = new PageRequest(page, SEARCH_PER_PAGE);
        return vacancyRepository.findAll(/*new VacancySearchSpecification(vacancySearchParam),*/ pageRequest);
    }

    @Override
    public List<Vacancy> findNewest() {
        return vacancyRepository.findNewest(new PageRequest(0, NEWEST_COUNT));
    }

    @Override
    public List<Vacancy> findNearest(Coordinate userCoordinate) {
        return vacancyRepository.findByCoordinate(new PageRequest(0, NEAREST_COUNT));
    }

    @Override
    public List<String> findSuggestedVacancy(String searchVacancyTitlePart) {
        return vacancyRepository.findSuggestedVacancy(searchVacancyTitlePart);
    }

    @Override
    public List<String> findOftenUsageTags() {
        return vacancyRepository.findOftenUsageTags(new PageRequest(0, TAGS_COUNT));
    }

    @Override
    public List<Vacancy> findByTag(String tag) {
        return vacancyRepository.findByTag(tag, new PageRequest(0, 0)).getContent();
    }

    private static class VacancySearchSpecification implements Specification<Vacancy> {
        private final VacancySearchParam vacancySearchParam;

        public VacancySearchSpecification(VacancySearchParam vacancySearchParam) {
            this.vacancySearchParam = vacancySearchParam;
        }

        @Override
        public Predicate toPredicate(Root<Vacancy> vacancyRoot, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            List<Predicate> andPredicates = new ArrayList<Predicate>();

            String searchTerm = vacancySearchParam.getSearchTerm();
            if (searchTerm != null) {
                andPredicates.add(criteriaBuilder.like(vacancyRoot.get(Vacancy_.title), getLikePattern(searchTerm)));
            }

            Predicate compensationPredicate = createCompensationPredicate(vacancyRoot, criteriaBuilder);
            if (compensationPredicate != null) {
                andPredicates.add(compensationPredicate);
            }

            Predicate searchPeriodPredicate = createSearchPeriodPredicate(vacancyRoot, criteriaBuilder);
            if (searchPeriodPredicate != null) {
                andPredicates.add(searchPeriodPredicate);
            }

            Predicate vacancySearchWorkSchedulePredicate = createVacancySearchWorkSchedulePredicate(vacancyRoot, criteriaBuilder);
            if (vacancySearchWorkSchedulePredicate != null) {
                andPredicates.add(vacancySearchWorkSchedulePredicate);
            }

            Predicate vacancySearchExperiencePredicate = createVacancySearchExperiencePredicate(vacancyRoot, criteriaBuilder);
            if (vacancySearchExperiencePredicate != null) {
                andPredicates.add(vacancySearchExperiencePredicate);
            }

            Predicate educationPredicate = createEducationPredicate(vacancyRoot, criteriaBuilder);
            if (educationPredicate != null) {
                andPredicates.add(educationPredicate);
            }
            return criteriaBuilder.and(andPredicates.toArray(new Predicate[andPredicates.size()]));
        }

        private Predicate createCompensationPredicate(Root<Vacancy> vacancyRoot, CriteriaBuilder criteriaBuilder) {
            long compensationFrom = vacancySearchParam.getCompensationFrom();
            long compensationTo = vacancySearchParam.getCompensationTo();
            if (compensationFrom != 0 && compensationTo != 0) {
                return criteriaBuilder.between(
                        vacancyRoot.get(Vacancy_.compensation).get(Compensation_.compensation),
                        compensationFrom, compensationTo);
            } else if (compensationFrom != 0) {
                return criteriaBuilder.ge(
                        vacancyRoot.get(Vacancy_.compensation).get(Compensation_.compensation),
                        compensationFrom);
            } else if (compensationTo != 0) {
                return criteriaBuilder.le(
                        vacancyRoot.get(Vacancy_.compensation).get(Compensation_.compensation),
                        compensationTo);
            }
            return null;
        }

        private Predicate createSearchPeriodPredicate(Root<Vacancy> vacancyRoot, CriteriaBuilder criteriaBuilder) {
            LocalDate localDate = new LocalDate();
            VacancySearchPeriod vacancySearchPeriod = vacancySearchParam.getVacancySearchPeriod();
            switch (vacancySearchPeriod) {
                case THREE_MONTH:
                    return criteriaBuilder.between(vacancyRoot.get(Vacancy_.entranceDate),
                            localDate.toDate(), localDate.minusMonths(3).toDate());
                case WEEK:
                    return criteriaBuilder.between(vacancyRoot.get(Vacancy_.entranceDate),
                            localDate.toDate(), localDate.minusWeeks(1).toDate());
                case THREE_DAYS:
                    return criteriaBuilder.between(vacancyRoot.get(Vacancy_.entranceDate),
                            localDate.toDate(), localDate.minusDays(3).toDate());
                case DAY:
                    return criteriaBuilder.between(vacancyRoot.get(Vacancy_.entranceDate),
                            localDate.toDate(), localDate.minusDays(1).toDate());
            }
            throw new IllegalArgumentException("Search period not founded");
        }

        private Predicate createVacancySearchExperiencePredicate(Root<Vacancy> vacancyRoot, CriteriaBuilder criteriaBuilder) {
            List<Predicate> predicates = new ArrayList<Predicate>();
            List<VacancySearchExperience> vacancySearchExperiences = vacancySearchParam.getVacancySearchExperiences();
            if (vacancySearchExperiences == null) {
                return null;
            }

            for (VacancySearchExperience vacancySearchExperience : vacancySearchExperiences) {
                switch (vacancySearchExperience) {
                    case WITHOUT:
                        //todo
                        break;
                    case MORE_SIX_YEARS:
                        predicates.add(criteriaBuilder.ge(vacancyRoot.get(Vacancy_.workExperience).get(WorkExperience_.toYears), 6));
                        break;
                    case THREE_SIX_YEARS:
                        predicates.add(criteriaBuilder.between(vacancyRoot.get(Vacancy_.workExperience).get(WorkExperience_.toYears), 3, 6));
                        break;
                    case ONE_THREE_YEARS:
                        predicates.add(criteriaBuilder.between(vacancyRoot.get(Vacancy_.workExperience).get(WorkExperience_.toYears), 1, 3));
                        break;
                }
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        }

        private Predicate createVacancySearchWorkSchedulePredicate(Root<Vacancy> vacancyRoot, CriteriaBuilder criteriaBuilder) {
            List<Predicate> predicates = new ArrayList<Predicate>();
            List<VacancySearchWorkSchedule> vacancySearchWorkSchedules = vacancySearchParam.getVacancySearchWorkSchedules();
            if (vacancySearchWorkSchedules == null) {
                return null;
            }

            for (VacancySearchWorkSchedule vacancySearchWorkSchedule : vacancySearchWorkSchedules) {
                switch (vacancySearchWorkSchedule) {
                    case FULL_TIME:
                        predicates.add(criteriaBuilder.equal(vacancyRoot.get(Vacancy_.workSchedule), WorkSchedule.FULL_TIME));
                        break;
                    case PART_TIME:
                        predicates.add(criteriaBuilder.equal(vacancyRoot.get(Vacancy_.workSchedule), WorkSchedule.PART_TIME));
                        break;
                    case REMOTE:
                        predicates.add(criteriaBuilder.equal(vacancyRoot.get(Vacancy_.workSchedule), WorkSchedule.REMOTE));
                        break;
                }
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        }

        private Predicate createEducationPredicate(Root<Vacancy> vacancyRoot, CriteriaBuilder criteriaBuilder) {
            List<Predicate> predicates = new ArrayList<Predicate>();
            List<VacancySearchEducation> vacancySearchEducations = vacancySearchParam.getVacancySearchEducations();
            if (vacancySearchEducations == null) {
                return null;
            }

            for (VacancySearchEducation vacancySearchEducation : vacancySearchEducations) {
                switch (vacancySearchEducation) {
                    case HIGHER_EDUCATION:
                        predicates.add(criteriaBuilder.equal(vacancyRoot.get(Vacancy_.education), Education.HIGHER_EDUCATION));
                        break;
                    case SECONDARY_EDUCATION:
                        predicates.add(criteriaBuilder.equal(vacancyRoot.get(Vacancy_.education), Education.SECONDARY_EDUCATION));
                        break;
                    case SECONDARY_SPECIAL_EDUCATION:
                        predicates.add(criteriaBuilder.equal(vacancyRoot.get(Vacancy_.education), Education.SECONDARY_SPECIAL_EDUCATION));
                        break;
                    case STUDENT:
                        predicates.add(criteriaBuilder.equal(vacancyRoot.get(Vacancy_.education), Education.STUDENT));
                        break;
                }
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        }

        private String getLikePattern(final String searchTerm) {
            StringBuilder pattern = new StringBuilder();
            pattern.append(searchTerm.toLowerCase());
            pattern.append("%");
            return pattern.toString();
        }
    }
}
