package name.oleg.search;

public enum VacancySearchEducation {
    HIGHER_EDUCATION("Высшее образование"),
    SECONDARY_SPECIAL_EDUCATION("Среднее специальное образование"),
    SECONDARY_EDUCATION("Среднее образование"),
    STUDENT("Студент");

    private String description;

    VacancySearchEducation(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
