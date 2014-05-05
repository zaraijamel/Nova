package name.oleg.resume;

import fr.opensagres.xdocreport.converter.ConverterRegistry;
import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.IConverter;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.core.document.DocumentKind;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import name.oleg.mail.MailMessagePreparatory;
import name.oleg.mail.MailMessageSender;
import name.oleg.resume.data.ResumeData;
import name.oleg.resume.data.ResumeTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.io.*;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private MailMessageSender<MimeMessage> mailMessageSender;

    @Override
    public void generateWordResume(OutputStream destinationStream, ResumeData resumeData, ResumeTemplate resumeTemplate) throws Exception {
        generateWordResume(resumeData, getTemplate(resumeTemplate), destinationStream);
    }

    @Override
    public void generatePDFResume(OutputStream destinationStream, final ResumeData resumeData, final ResumeTemplate resumeTemplate) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        generateWordResume(resumeData, getTemplate(resumeTemplate), outputStream);

        ByteArrayInputStream inputStream = null;
        try {
            inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            Options options = Options.getFrom(DocumentKind.DOCX).to(ConverterTypeTo.PDF);
            IConverter converter = ConverterRegistry.getRegistry().getConverter(options);
            converter.convert(inputStream, destinationStream, options);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    private void generateWordResume(ResumeData resumeData, File templateFile, OutputStream destinationStream) throws IOException, XDocReportException {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(templateFile);
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport(fileInputStream, TemplateEngineKind.Velocity);

            IContext context = report.createContext();
            context.put("rd", resumeData);

            report.process(context, destinationStream);
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
    }

    //    @Override
    public void sendEmailResume(final String destinationEmail, ResumeData resumeData, ResumeTemplate resumeTemplate) throws Exception {
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        generateResume(outputStream, resumeData, resumeTemplate, resumeFormat);

        mailMessageSender.send(new MailMessagePreparatory<MimeMessage>() {
            @Override
            public void prepare(MimeMessage message) throws MessagingException {
                message.setFrom(new InternetAddress("inmate08@gmail.com"));
                message.addRecipients(Message.RecipientType.TO, destinationEmail);
                message.setSubject("Resume");

                MimeBodyPart textBodyPart = new MimeBodyPart();
                textBodyPart.setText("Resume");

                DataSource dataSource = new ByteArrayDataSource(outputStream.toByteArray(), "application/pdf");
                MimeBodyPart pdfBodyPart = new MimeBodyPart();
                pdfBodyPart.setDataHandler(new DataHandler(dataSource));
                pdfBodyPart.setFileName("resume.pdf");

                MimeMultipart mimeMultipart = new MimeMultipart();
                mimeMultipart.addBodyPart(textBodyPart);
                mimeMultipart.addBodyPart(pdfBodyPart);

                message.setContent(mimeMultipart);
            }
        });
    }

    private File getTemplate(ResumeTemplate resumeTemplate) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(resumeTemplate.getFileName() + ".docx");
        return classPathResource.getFile();
    }
}
