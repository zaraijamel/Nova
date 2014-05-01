package name.oleg.scheduler.worker;

import name.oleg.entity.MailDelivery;
import name.oleg.entity.Vacancy;
import name.oleg.mail.MailMessagePreparatory;
import name.oleg.mail.MailMessageSender;
import name.oleg.scheduler.Worker;
import name.oleg.service.MailDeliveryService;
import name.oleg.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmailDeliveryWorker implements Worker {

    @Autowired
    private VacancyService vacancyService;

    private MailDeliveryService mailDeliveryService;

    @Autowired
    private MailMessageSender<MimeMessage> mailMessageSender;

    @Override
    public void work() throws Exception {
        List<MailDelivery> subscribers = mailDeliveryService.getSubscribers();
        for (MailDelivery mailDelivery : subscribers) {
            List<Vacancy> vacanciesForSubscriber = getVacanciesForSubscriber(mailDelivery);
        }

        mailMessageSender.send(new MailMessagePreparatory<MimeMessage>() {
            @Override
            public void prepare(MimeMessage message) throws MessagingException {

            }
        });
    }

    private List<Vacancy> getVacanciesForSubscriber(MailDelivery mailDelivery) {
        List<Vacancy> vacancies = new ArrayList<Vacancy>();
        List<String> criteria = mailDelivery.getCriteria();
        for (String criterion : criteria) {
            vacancies.addAll(vacancyService.findByTitle(criterion));
        }
        return vacancies;
    }
}
