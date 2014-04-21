package name.oleg.service;

import name.oleg.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Calendar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/service-context.xml"})
public class VacancyServiceTest {

    @Autowired
    private VacancyService vacancyService;

    @Autowired
    private EmployerService employerService;

    @Autowired
    private ProfessionalAreaService professionalAreaService;

    @Test
    public void loadTest() {
//        List<Vacancy> all = vacancyService.findByTitle("test");
//        System.err.println(all.size());
    }

    @Test
    public void addTestData() {
        ProfessionalArea professionalArea = getProfessionalArea();
        Employer employer = addEmployer();

        addVacancy(employer, professionalArea);
//        addVacancy();    ,
//
//         vacancyService.add(vacancy);
    }

    private void addVacancy(Employer employer, ProfessionalArea professionalArea) {
        Vacancy vacancy = new Vacancy();
        vacancy.setArea("Минск");
        vacancy.setDescription("We are currently seeking a systems administrator to come in and apply their skills to our growing business needs including: supporting ongoing projects, planning and forecasting, continual communication with both engineers and other system administrators and clients, and process development/improvement. This person must be ready to slide in seamlessly with our team. This role is not a typical sys admin role; it requires constant innovation, team work, client interaction and thinking. This role also requires a minimum of 2 days per week on-site at the client’s office in mid-town Manhattan.");
        vacancy.setPageContent("<p><strong>Обязанности:</strong></p> <p>• Ведение бухгалтерского и налогового учета;</p> <p>• Оформление бухгалтерских документов;</p> <p>• Внутренний аудит, восстановление бухгалтерского учета;</p> <p>• Позитивный опыт прохождения налоговых проверок;</p> <p>• Составление годовых балансов, приложений, сверок по налогам с ИМНС, пояснительных записок ;</p> <p>• Составление запросов в уполномоченные органы;</p> <p>• Контроль за правильностью оформления предоставленных первичных документов;</p> <p>• Анализ финансово-хозяйственной деятельности (квалифицированные рекомендации);</p> <p>• Предоставление данных о наличии остатков по ОС, НМА, ТМЦ, о состоянии взаиморасчетов с дебиторами и кредиторами и прочие;</p><br /><p><strong>Требования: </strong></p> <p>• Опыт работы в рознице обязателен</p>");
        vacancy.setTitle("Java-программист");
        vacancy.setEntranceDate(Calendar.getInstance().getTime());
        vacancy.setIdentifier(1);
        vacancy.setEducation(Education.HIGHER_EDUCATION);
        vacancy.setWorkSchedule(WorkSchedule.FULL_TIME);
        vacancy.setSourceLink("http://www.tut.by");
        vacancy.setEmployer(employer);
        vacancy.setTags(Arrays.asList("Java", "программист", "belprime"));

        Compensation compensation = new Compensation();
        compensation.setCurrency(Currency.BYR);
//        compensation.setFrom(1L);
//        compensation.setTo(2L);
        vacancy.setCompensation(compensation);

        vacancy.setProfessionalArea(professionalArea);

        vacancyService.add(vacancy);
    }

    private Employer addEmployer() {
        Employer employer = new Employer();
        employer.setContactPerson("test");
        employer.setDescription("test");
        employer.setEmail("test");
        employer.setLogoUrl("http://www.belprime.com/images/favicon.ico");
        employer.setPageContent("test");
        employer.setUrl("http://www.tut.by");
        employer.setTitle("Belprime Solutions");
        employer.setPhone("test");
        employer.setIdentifier(1);
        return employer;
    }

    private void addCategory() {

    }

    private ProfessionalArea getProfessionalArea() {
        ProfessionalArea professionalArea = new ProfessionalArea();
        professionalArea.setTitle("test");
        return professionalArea;
    }
}
