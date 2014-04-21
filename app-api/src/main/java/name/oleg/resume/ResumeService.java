package name.oleg.resume;

import name.oleg.resume.data.ResumeData;
import name.oleg.resume.data.ResumeTemplate;

import java.io.OutputStream;

public interface ResumeService {

    public void generateResume(OutputStream destinationOutputStream, ResumeData resumeData, ResumeTemplate resumeTemplate) throws Exception;

    public void sendEmailResume(String destinationEmail, ResumeData resumeData, ResumeTemplate resumeTemplate) throws Exception;
}
