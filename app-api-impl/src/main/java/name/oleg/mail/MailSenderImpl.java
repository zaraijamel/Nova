package name.oleg.mail;

import org.springframework.stereotype.Component;

import javax.mail.Message;

@Component("mailSenderImpl")
public class MailSenderImpl implements MailSender {

    public void send() {

    }

    @Override
    public void send(Message message) {

    }
}
