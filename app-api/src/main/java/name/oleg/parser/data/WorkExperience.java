package name.oleg.parser.data;

public class WorkExperience {
    private int fromYears;
    private int toYears;

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
