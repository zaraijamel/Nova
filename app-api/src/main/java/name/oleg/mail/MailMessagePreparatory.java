package name.oleg.mail;

import javax.mail.Message;
import javax.mail.MessagingException;

public interface MailMessagePreparatory<T extends Message> {

    public void prepare(T message) throws MessagingException;
}
