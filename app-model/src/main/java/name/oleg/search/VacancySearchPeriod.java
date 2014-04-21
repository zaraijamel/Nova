package name.oleg.search;

public enum VacancySearchPeriod {
    THREE_MONTH("За 3 месяца"),
    WEEK("За 1 неделю"),
    THREE_DAYS("За 3 дня"),
    DAY("За 1 день");

    private String description;

    VacancySearchPeriod(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
