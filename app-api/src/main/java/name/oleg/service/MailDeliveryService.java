package name.oleg.service;

import name.oleg.entity.MailDelivery;

import java.util.List;

public interface MailDeliveryService {

    public List<MailDelivery> getSubscribers();

    public void addSubscriber(MailDelivery mailDelivery);

    public void removeSubscriber(String email);
}
