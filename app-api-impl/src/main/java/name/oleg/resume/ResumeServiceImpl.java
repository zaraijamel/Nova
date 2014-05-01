package name.oleg.resume;

import name.oleg.mail.MailMessagePreparatory;
import name.oleg.mail.MailMessageSender;
import name.oleg.resume.data.ResumeData;
import name.oleg.resume.data.ResumeFormat;
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
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private MailMessageSender<MimeMessage> mailMessageSender;

    @Autowired
    private ResumeGenerator resumeGenerator;

    @Override
    public void generateResume(File destinationFile, ResumeData resumeData, ResumeTemplate resumeTemplate, ResumeFormat resumeFormat) throws Exception {
        resumeGenerator.generate(resumeData, getTemplate(resumeTemplate), destinationFile);
        if (resumeFormat == ResumeFormat.PDF) {
            ResumeConverter resumeConverter = new ResumeConverter();
        }
    }

    @Override
    public void sendEmailResume(final String destinationEmail, final ResumeData resumeData, final ResumeTemplate resumeTemplate) throws Exception {
        final File template = getTemplate(resumeTemplate);
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        resumeGenerator.generate(resumeData, template, new File(""));

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
        ClassPathResource classPathResource = new ClassPathResource("/resources/templates/" + resumeTemplate.getFileName() + ".docx");
//        return classPathResource.getFile();
        return new File("D:\\template2.docx");
    }
}
