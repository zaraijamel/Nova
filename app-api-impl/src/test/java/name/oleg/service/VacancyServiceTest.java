package name.oleg.service;

import name.oleg.entity.Vacancy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/service-context.xml"})
public class VacancyServiceTest {

    @Autowired
    private VacancyService vacancyService;

    @Test
    public void loadTest() {
        List<Vacancy> all = vacancyService.findByTitle("test");
        System.err.println(all.size());
    }
}
