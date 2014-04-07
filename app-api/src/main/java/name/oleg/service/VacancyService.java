package name.oleg.service;

import name.oleg.entity.Vacancy;
import name.oleg.util.Coordinate;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;

public interface VacancyService {

    public void add(Vacancy vacancy);

    public void add(Collection<Vacancy> vacancies);

    public void delete(Vacancy vacancy);

    public List<Vacancy> findAll();

    public Vacancy findById(long id);

    public List<Vacancy> findByTitle(String title);

    public Page<Vacancy> find(VacancySearchParam vacancySearchParam);

    public List<Vacancy> findNewest();

    public List<Vacancy> findNearest(Coordinate userCoordinate);

    public List<String> findSuggestedVacancy(String searchVacancyTitlePart);

    public List<String> findOftenUsageTags();

    public List<Vacancy> findByTag(String tag);
}
