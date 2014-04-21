package name.oleg.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Enumerated;

@Embeddable
public class Compensation {

    @Column(name = "COMPENSATION")
    private Long compensation;

    @Enumerated
    @Column(name = "CURRENCY")
    private Currency currency;

    public Long getCompensation() {
        return compensation;
    }

    public void setCompensation(Long compensation) {
        this.compensation = compensation;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
