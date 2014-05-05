package name.oleg.resume;

import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import name.oleg.resume.data.ResumeData;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

@Component("wordResumeGenerator")
public class WordResumeGenerator implements ResumeGenerator {

    @Override
    public void generate(ResumeData resumeData, File templateFile, OutputStream destinationStream) throws Exception {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(templateFile);
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport(fileInputStream, TemplateEngineKind.Velocity);

            IContext context = report.createContext();
            context.put("rd", resumeData);

            report.process(context, destinationStream);
            destinationStream.flush();
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            destinationStream.close();
        }
    }
}
