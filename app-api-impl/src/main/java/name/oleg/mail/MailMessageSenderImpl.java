package name.oleg.mail;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component("mimeMailSender")
public class MailMessageSenderImpl implements MailMessageSender<MimeMessage> {

    @Override
    public void send(MailMessagePreparatory<MimeMessage> message) throws MessagingException {
        MimeMessage mimeMessage = new MimeMessage(createSession());
        message.prepare(mimeMessage);
        Transport.send(mimeMessage);
    }

    private Session createSession() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        return Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("inmate08@gmail.com", "");
            }
        });
    }
}
