package name.oleg.service;

import name.oleg.entity.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VacancyServiceImpl implements VacancyService {

    @Autowired
    private VacancyRepository vacancyRepository;

    @Override
    @Transactional
    public void add(Vacancy vacancy) {
        vacancyRepository.save(vacancy);
    }

    @Override
    @Transactional
    public void delete(Vacancy vacancy) {
        vacancyRepository.delete(vacancy);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vacancy> findAll() {
        return vacancyRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vacancy> findByTitle(String title) {
        return vacancyRepository.findVacancyByTitle(title);
    }
}
