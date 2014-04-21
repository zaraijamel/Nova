package name.oleg.search;

import java.util.ArrayList;
import java.util.List;

public class VacancySearchParam {
    private String searchTerm;
    private long compensationFrom;
    private long compensationTo;
    private VacancySearchPeriod vacancySearchPeriod = VacancySearchPeriod.DAY;
    private VacancySearchSort vacancySearchSort = VacancySearchSort.CORRESPONDENCE;
    private List<VacancySearchWorkSchedule> vacancySearchWorkSchedules = new ArrayList<VacancySearchWorkSchedule>();
    private List<VacancySearchExperience> vacancySearchExperiences = new ArrayList<VacancySearchExperience>();
    private List<VacancySearchEducation> vacancySearchEducations = new ArrayList<VacancySearchEducation>();

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public long getCompensationFrom() {
        return compensationFrom;
    }

    public void setCompensationFrom(long compensationFrom) {
        this.compensationFrom = compensationFrom;
    }

    public long getCompensationTo() {
        return compensationTo;
    }

    public void setCompensationTo(long compensationTo) {
        this.compensationTo = compensationTo;
    }

    public VacancySearchPeriod getVacancySearchPeriod() {
        return vacancySearchPeriod;
    }

    public void setVacancySearchPeriod(VacancySearchPeriod vacancySearchPeriod) {
        this.vacancySearchPeriod = vacancySearchPeriod;
    }

    public VacancySearchSort getVacancySearchSort() {
        return vacancySearchSort;
    }

    public void setVacancySearchSort(VacancySearchSort vacancySearchSort) {
        this.vacancySearchSort = vacancySearchSort;
    }

    public List<VacancySearchWorkSchedule> getVacancySearchWorkSchedules() {
        return vacancySearchWorkSchedules;
    }

    public void setVacancySearchWorkSchedules(List<VacancySearchWorkSchedule> vacancySearchWorkSchedules) {
        this.vacancySearchWorkSchedules = vacancySearchWorkSchedules;
    }

    public List<VacancySearchExperience> getVacancySearchExperiences() {
        return vacancySearchExperiences;
    }

    public void setVacancySearchExperiences(List<VacancySearchExperience> vacancySearchExperiences) {
        this.vacancySearchExperiences = vacancySearchExperiences;
    }

    public List<VacancySearchEducation> getVacancySearchEducations() {
        return vacancySearchEducations;
    }

    public void setVacancySearchEducations(List<VacancySearchEducation> vacancySearchEducations) {
        this.vacancySearchEducations = vacancySearchEducations;
    }
}
