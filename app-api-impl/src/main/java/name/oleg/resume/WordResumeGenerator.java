package name.oleg.resume;

import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import name.oleg.resume.data.ResumeData;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

@Component("wordResumeGenerator")
public class WordResumeGenerator implements ResumeGenerator {

    @Override
    public void generate(ResumeData resumeData, File templateFile, File destinationFile) throws Exception {
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(templateFile);
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport(fileInputStream, TemplateEngineKind.Velocity);

            IContext context = report.createContext();
            context.put("rd", resumeData);

            fileOutputStream = new FileOutputStream(destinationFile);
            report.process(context, fileOutputStream);
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }
}
