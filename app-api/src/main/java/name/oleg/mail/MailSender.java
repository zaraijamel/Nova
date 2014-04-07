package name.oleg.mail;

import javax.mail.Message;

public interface MailSender {

    public void send(Message message);
}
