package name.oleg.resume;

import name.oleg.resume.data.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/service-context.xml"})
public class WordResumeGeneratorTest {

    @Autowired
    @Qualifier("wordResumeGenerator")
    private ResumeGenerator resumeGenerator;

    @Test
    public void generateTest() throws Exception {
        ResumeData resumeData = new ResumeData();
        resumeData.setFirstName("Иван");
        resumeData.setLastName("Сидоров");
        resumeData.setMiddleName("Петрович");
        resumeData.setWebsite("htt://www.site.com");
        resumeData.setEmail("ivan@mail.com");
        resumeData.setPhone("8(029)700-30-20");
        Address address = new Address();
        address.setStreet("ул. Казинца 91-155");
        address.setCity("Минск");
        resumeData.setAddress(address);
        resumeData.setBirthday(Calendar.getInstance().getTime());
        resumeData.setGoal("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");

        List<Ability> abilities = new ArrayList<Ability>();
        Ability e = new Ability();
        e.setTitle("Программирование");
        e.setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        abilities.add(e);
        e = new Ability();
        e.setTitle("Программирование");
        e.setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        abilities.add(e);
        resumeData.setAbilities(abilities);

        List<Education> educations = new ArrayList<Education>();
        Education e1 = new Education();
        e1.setSpecialty("Инженер-программист");
        e1.setAcademicDegree("Инженер-программист");
        e1.setAdditionalSpecialty("Инженер-программист");
        e1.setInstitution("БНТУ");
        e1.setStartDate(new Date(System.currentTimeMillis()));
        e1.setEndDate(new Date(System.currentTimeMillis()));
        educations.add(e1);
        e1 = new Education();
        e1.setSpecialty("Инженер-программист");
        e1.setAcademicDegree("Инженер-программист");
        e1.setAdditionalSpecialty("Инженер-программист");
        e1.setInstitution("БНТУ");
        e1.setStartDate(new Date(System.currentTimeMillis()));
        e1.setEndDate(new Date(System.currentTimeMillis()));
        educations.add(e1);
        resumeData.setEducations(educations);

        List<Experience> experiences = new ArrayList<Experience>();
        Experience e2 = new Experience();
        e2.setOrganization("ООО Кадр");
        e2.setPosition("Java-программист");
        e2.setResponsibility("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        e2.setStartDate(new Date(System.currentTimeMillis()));
        e2.setEndDate(new Date(System.currentTimeMillis()));
        experiences.add(e2);
        e2 = new Experience();
        e2.setOrganization("ООО Кадр");
        e2.setPosition("Java-программист");
        e2.setResponsibility("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        e2.setStartDate(new Date(System.currentTimeMillis()));
        e2.setEndDate(new Date(System.currentTimeMillis()));
        experiences.add(e2);
        resumeData.setExperiences(experiences);

        List<Recommendation> recommendations = new ArrayList<Recommendation>();
        Recommendation e3 = new Recommendation();
        e3.setFirstName("Даша");
        e3.setMiddleName("Петровна");
        e3.setLastName("Петрова");
        e3.setText("Besides having joy working with Dasha, she is open-minded, intelligent person, who can provide high-quality recruiting processes. She has excellent analytical and communication skills which really suit to her lovely appearance and deep inside world. I extremely recommended Dasha as talented recruiter.");
        recommendations.add(e3);
        e3 = new Recommendation();
        e3.setFirstName("Даша");
        e3.setMiddleName("Петровна");
        e3.setLastName("Петрова");
        e3.setText("Besides having joy working with Dasha, she is open-minded, intelligent person, who can provide high-quality recruiting processes. She has excellent analytical and communication skills which really suit to her lovely appearance and deep inside world. I extremely recommended Dasha as talented recruiter.");
        recommendations.add(e3);
        resumeData.setRecommendations(recommendations);
//
        FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\resume4.docx"));
        resumeGenerator.generate(resumeData, new File("D:\\template4.docx"), fileOutputStream);
    }
}
