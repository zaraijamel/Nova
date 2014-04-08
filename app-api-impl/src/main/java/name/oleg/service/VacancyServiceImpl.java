package name.oleg.service;

import name.oleg.entity.Vacancy;
import name.oleg.util.Coordinate;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Page<Vacancy> find(VacancySearchParam vacancySearchParam) {
        Validate.notNull(vacancySearchParam);

        PageRequest pageRequest = new PageRequest(vacancySearchParam.getPage(), SEARCH_PER_PAGE);
        String searchTerm = vacancySearchParam.getSearchTerm();
        if (searchTerm == null) {
            return vacancyRepository.findAll(pageRequest);
        } else {
            return vacancyRepository.findByTag(searchTerm, pageRequest);
        }
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
}
