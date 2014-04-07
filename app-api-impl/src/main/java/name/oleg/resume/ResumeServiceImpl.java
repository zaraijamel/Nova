package name.oleg.resume;

import name.oleg.mail.MailSender;
import name.oleg.resume.data.ResumeData;
import name.oleg.resume.data.ResumeTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.io.ByteArrayOutputStream;
import java.util.Properties;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private MailSender mailSender;

    @Autowired
    private ResumeGenerator resumeGenerator;

    @Override
    public void sendEmailResume(String destinationEmail, ResumeData resumeData, ResumeTemplate resumeTemplate) throws Exception {
        MimeBodyPart textBodyPart = new MimeBodyPart();
        textBodyPart.setText("Test");

        resumeGenerator.generate(resumeData, null, null);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        DataSource dataSource = new ByteArrayDataSource(outputStream.toByteArray(), "application/pdf");
        MimeBodyPart pdfBodyPart = new MimeBodyPart();
        pdfBodyPart.setDataHandler(new DataHandler(dataSource));
        pdfBodyPart.setFileName("test.pdf");

        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(textBodyPart);
        mimeMultipart.addBodyPart(pdfBodyPart);

        MimeMessage mimeMessage = new MimeMessage(createSession());
        mimeMessage.setContent(mimeMultipart);

        mailSender.send(mimeMessage);
    }

    private Session createSession() {
        Properties props = new Properties();
//        props.put("mail.smtp.host", SMTP_HOST_NAME);
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.debug", "true");
//        props.put("mail.smtp.port", SMTP_PORT);
        return Session.getInstance(props);
    }
}
