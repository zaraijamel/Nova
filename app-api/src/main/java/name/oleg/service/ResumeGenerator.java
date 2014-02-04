package name.oleg.service;

import java.io.File;

public interface ResumeGenerator {

    public void generate(ResumeData resumeData, File inputFile, File outputFile);
}
