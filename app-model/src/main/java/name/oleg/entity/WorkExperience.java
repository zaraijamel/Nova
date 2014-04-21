package name.oleg.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class WorkExperience {

    @Column(name = "WORK_EXPERIENCE_FROM_YEARS")
    private int fromYears;

    @Column(name = "WORK_EXPERIENCE_TO_YEARS")
    private int toYears;

    public WorkExperience() {
    }

    public WorkExperience(int fromYears, int toYears) {
        this.fromYears = fromYears;
        this.toYears = toYears;
    }

    public int getFromYears() {
        return fromYears;
    }

    public void setFromYears(int fromYears) {
        this.fromYears = fromYears;
    }

    public int getToYears() {
        return toYears;
    }

    public void setToYears(int toYears) {
        this.toYears = toYears;
    }
}
