package name.oleg.resume;

import name.oleg.resume.data.ResumeData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/service-context.xml"})
public class WordResumeGeneratorTest {

    @Autowired
    @Qualifier("wordResumeGenerator")
    private ResumeGenerator resumeGenerator;

    @Test
    public void generateTest() throws Exception {
        ResumeData resumeData = new ResumeData();

//        resumeGenerator.generate(resumeData);
    }
}
