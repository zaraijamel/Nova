package name.oleg.mail;

import javax.mail.Message;
import javax.mail.MessagingException;

public interface MailMessageSender<T extends Message> {

    public void send(MailMessagePreparatory<T> message) throws MessagingException;
}
