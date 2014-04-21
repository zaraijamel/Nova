package name.oleg.mail;

import name.oleg.resume.data.ResumeData;

public interface MailMessageProcessor {

    public void process(ResumeData resumeData);
}
