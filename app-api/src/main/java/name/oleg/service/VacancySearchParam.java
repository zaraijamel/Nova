package name.oleg.service;

public class VacancySearchParam {
    private SearchPeriod searchPeriod;
    private SearchExperience searchExperience;
    private SearchCompensation searchCompensation;
    private String searchTerm;
    private String tag;
    private int page;

    public static VacancySearchParam create() {
        return new VacancySearchParam();
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public VacancySearchParam setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
        return this;
    }

    public SearchPeriod getSearchPeriod() {
        return searchPeriod;
    }

    public void setSearchPeriod(SearchPeriod searchPeriod) {
        this.searchPeriod = searchPeriod;
    }

    public SearchExperience getSearchExperience() {
        return searchExperience;
    }

    public void setSearchExperience(SearchExperience searchExperience) {
        this.searchExperience = searchExperience;
    }

    public SearchCompensation getSearchCompensation() {
        return searchCompensation;
    }

    public void setSearchCompensation(SearchCompensation searchCompensation) {
        this.searchCompensation = searchCompensation;
    }

    public String getTag() {
        return tag;
    }

    public VacancySearchParam setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public int getPage() {
        return page;
    }

    public VacancySearchParam setPage(int page) {
        this.page = page;
        return this;
    }
}
