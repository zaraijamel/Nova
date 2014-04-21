package name.oleg.search;

public enum VacancySearchWorkSchedule {
    FULL_TIME("Полный день"),
    PART_TIME("Сменный график"),
    REMOTE("Удаленная работа");

    private String description;

    VacancySearchWorkSchedule(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
