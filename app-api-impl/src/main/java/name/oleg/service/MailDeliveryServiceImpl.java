package name.oleg.service;

import name.oleg.entity.MailDelivery;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailDeliveryServiceImpl implements MailDeliveryService {

    @Autowired
    private MailDeliveryRepository mailDeliveryRepository;

    @Override
    public List<MailDelivery> getSubscribers() {
        return mailDeliveryRepository.findAll();
    }

    @Override
    public void addSubscriber(MailDelivery mailDelivery) {
        Validate.notNull(mailDelivery);
        mailDeliveryRepository.save(mailDelivery);
    }

    @Override
    public void removeSubscriber(String email) {
        Validate.notNull(email);
        mailDeliveryRepository.removeByEmail(email);
    }
}
