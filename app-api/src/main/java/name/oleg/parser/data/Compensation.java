package name.oleg.parser.data;

public class Compensation {
    private Long from;
    private Long to;
    private Currency currency;

    public Compensation() {
    }

    public Compensation(Long from, Long to, Currency currency) {
        this.from = from;
        this.to = to;
        this.currency = currency;
    }

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
