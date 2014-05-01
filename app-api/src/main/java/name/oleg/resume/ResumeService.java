package name.oleg.resume;

import name.oleg.resume.data.ResumeData;
import name.oleg.resume.data.ResumeFormat;
import name.oleg.resume.data.ResumeTemplate;

import java.io.File;

public interface ResumeService {

    public void generateResume(File destinationFile, ResumeData resumeData, ResumeTemplate resumeTemplate, ResumeFormat resumeFormat) throws Exception;

    public void sendEmailResume(String destinationEmail, ResumeData resumeData, ResumeTemplate resumeTemplate) throws Exception;
}
