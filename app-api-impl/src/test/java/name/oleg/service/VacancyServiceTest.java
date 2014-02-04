package name.oleg.service;

import name.oleg.util.PageRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/service-context.xml"})
public class VacancyServiceTest {

    @Autowired
    private VacancyService vacancyService;

    @Test
    public void loadTest() {
        vacancyService.test();
    }
}
