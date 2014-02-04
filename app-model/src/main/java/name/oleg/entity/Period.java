package name.oleg.entity;

import java.util.Date;

public class Period {
    private Date start;
    private Date finish;

    public Period(Date start) {
        this.start = start;
    }

    public Period(Date start, Date finish) {
        this.start = start;
        this.finish = finish;
    }

    public Date getStart() {
        return start;
    }

    public Date getFinish() {
        return finish;
    }
}
