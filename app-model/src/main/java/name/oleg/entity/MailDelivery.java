package name.oleg.entity;

import javax.persistence.*;
import java.util.List;

@javax.persistence.Entity
@Table(name = "MAIL_DELIVERY")
public class MailDelivery extends Entity {

    @Column(name = "EMAIL")
    private String email;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "CRITERIA", joinColumns = @JoinColumn(name = "MAIL_DELIVERY_ID"))
    @Column(name = "CRITERIA")
    private List<String> criteria;

    public MailDelivery() {
    }

    public MailDelivery(String email, List<String> criteria) {
        this.email = email;
        this.criteria = criteria;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getCriteria() {
        return criteria;
    }

    public void setCriteria(List<String> criteria) {
        this.criteria = criteria;
    }
}
