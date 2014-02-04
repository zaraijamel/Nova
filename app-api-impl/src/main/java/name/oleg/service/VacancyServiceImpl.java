package name.oleg.service;

import name.oleg.dao.VacancyDao;
import name.oleg.entity.resume.Vacancy;
import name.oleg.util.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VacancyServiceImpl implements VacancyService {

    @Autowired
    private VacancyDao vacancyDao;

    @Override
    @Transactional(readOnly = true)
    public List<Vacancy> load(PageRequest pageRequest) {
        return vacancyDao.loadAll();
    }

    @Override
    public void test() {
        vacancyDao.test();
    }
}
