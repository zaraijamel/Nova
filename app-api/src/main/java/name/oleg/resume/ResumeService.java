package name.oleg.resume;

import name.oleg.resume.data.ResumeData;
import name.oleg.resume.data.ResumeTemplate;

import java.io.OutputStream;

public interface ResumeService {

    public void generateWordResume(OutputStream destinationStream, ResumeData resumeData, ResumeTemplate resumeTemplate) throws Exception;

    public void generatePDFResume(OutputStream destinationStream, ResumeData resumeData, ResumeTemplate resumeTemplate) throws Exception;
}
