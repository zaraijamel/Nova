package name.oleg.resume;

import name.oleg.resume.data.ResumeData;

import java.io.File;
import java.io.OutputStream;

public interface ResumeGenerator {

    public void generate(ResumeData resumeData, File templateFile, OutputStream destinationStream) throws Exception;
}
