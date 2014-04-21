package name.oleg.search;

public enum VacancySearchSort {
    SALARY("По зарплате"),
    CREATION_DATE("По дате создания вакансии"),
    CORRESPONDENCE("По соответствию");

    private String description;

    VacancySearchSort(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
