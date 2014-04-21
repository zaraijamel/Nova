package name.oleg.resume;

import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import name.oleg.resume.data.ResumeData;
import org.springframework.stereotype.Component;

import java.io.*;

@Component("wordResumeGenerator")
public class WordResumeGenerator implements ResumeGenerator {

//    @Override
    public void generate(ResumeData resumeData, File sourceFile, File destinationFile) throws Exception {
        FileInputStream fileInputStream = null;
        OutputStream outputStream = null;
        try {
            fileInputStream = new FileInputStream(sourceFile);
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport(fileInputStream, TemplateEngineKind.Velocity);

            IContext context = report.createContext();
            context.put("rd", resumeData);

            outputStream = new FileOutputStream(destinationFile);
            report.process(context, outputStream);
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public void generate(ResumeData resumeData, InputStream sourceFile, InputStream destination) throws Exception {

    }

    @Override
    public void generate(ResumeData resumeData, File templateFile, OutputStream destination) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
