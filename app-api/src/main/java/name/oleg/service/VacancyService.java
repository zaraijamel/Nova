package name.oleg.service;

import name.oleg.entity.Vacancy;

import java.util.List;

public interface VacancyService {

    public void add(Vacancy vacancy);

    public void delete(Vacancy vacancy);

    public List<Vacancy> findAll();

    public List<Vacancy> findByTitle(String title);
}
