package name.oleg.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Enumerated;

@Embeddable
public class Compensation {

    @Column(name = "COMPENSATION_FROM")
    private Long from;

    @Column(name = "COMPENSATION_TO")
    private Long to;

    @Enumerated
    @Column(name = "CURRENCY")
    private Currency currency;

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
