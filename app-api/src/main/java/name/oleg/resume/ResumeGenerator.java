package name.oleg.resume;

import name.oleg.resume.data.ResumeData;

import java.io.File;

public interface ResumeGenerator {

    public void generate(ResumeData resumeData, File templateFile, File destinationFile) throws Exception;
}
