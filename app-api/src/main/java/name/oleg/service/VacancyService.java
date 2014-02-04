package name.oleg.service;

import name.oleg.entity.resume.Vacancy;
import name.oleg.util.PageRequest;

import java.util.List;

public interface VacancyService {

    public List<Vacancy> load(PageRequest pageRequest);

    public void test();
}
