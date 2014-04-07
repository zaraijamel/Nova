package name.oleg.resume;

import name.oleg.resume.data.ResumeData;

import java.io.InputStream;

public interface ResumeGenerator {

    public void generate(ResumeData resumeData, InputStream sourceFile, InputStream destination) throws Exception;
}
