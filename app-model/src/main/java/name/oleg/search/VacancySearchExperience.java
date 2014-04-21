package name.oleg.search;

public enum VacancySearchExperience {
    WITHOUT("Нет опыта"),
    ONE_THREE_YEARS("От 1 года 3 лет"),
    THREE_SIX_YEARS("От 3 лет до 6 лет"),
    MORE_SIX_YEARS("Более 6 лет");

    private String description;

    VacancySearchExperience(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
