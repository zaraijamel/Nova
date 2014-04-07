package name.oleg.resume;

import name.oleg.resume.data.ResumeData;
import name.oleg.resume.data.ResumeTemplate;

public interface ResumeService {

    public void sendEmailResume(String destinationEmail, ResumeData resumeData, ResumeTemplate resumeTemplate) throws Exception;
}
