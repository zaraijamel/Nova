package name.oleg.resume;

import name.oleg.resume.data.Address;
import name.oleg.resume.data.ResumeData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.sql.Date;
import java.util.Calendar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/service-context.xml"})
public class WordResumeGeneratorTest {

    @Autowired
    @Qualifier("wordResumeGenerator")
    private ResumeGenerator resumeGenerator;

    @Test
    public void generateTest() throws Exception {
        ResumeData resumeData = new ResumeData();
        resumeData.setFirstName("Test");
        resumeData.setLastName("Test");
        resumeData.setMiddleName("Test");
        resumeData.setWebsite("Test");
        resumeData.setEmail("Test");
        resumeData.setPhone("Test");
        Address address = new Address();
        address.setStreet("test");
        address.setCity("test");
        resumeData.setAddress(address);
        resumeData.setBirthday(Calendar.getInstance().getTime());
        resumeData.setGoal("test");

        resumeGenerator.generate(resumeData, new File("D:\\template2.docx"), new File("D:\\test.docx"));
    }
}
