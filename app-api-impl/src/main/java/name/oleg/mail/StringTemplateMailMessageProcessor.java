package name.oleg.mail;

import name.oleg.resume.data.ResumeData;
import org.springframework.stereotype.Service;

@Service
public class StringTemplateMailMessageProcessor implements MailMessageProcessor {

    @Override
    public void process(ResumeData resumeData) {

    }
}
