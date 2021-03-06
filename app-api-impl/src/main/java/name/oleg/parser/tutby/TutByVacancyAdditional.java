package name.oleg.parser.tutby;

import name.oleg.parser.data.Currency;

import java.util.Date;

public class TutByVacancyAdditional {
    private Integer vacancyId;
    private Date creationDate;
    private String areaName;
    private String profArea;
    private Integer workExperienceFrom;
    private Integer workExperienceTo;
    private String description;
    private Long compensationFrom;
    private Long compensationTo;
    private Currency compensationCurrency;
    private Integer employerId;
    private String employerName;
    private String employerEmail;
    private String employerLogo;

    public Integer getVacancyId() {
        return vacancyId;
    }

    public void setVacancyId(Integer vacancyId) {
        this.vacancyId = vacancyId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getProfArea() {
        return profArea;
    }

    public void setProfArea(String profArea) {
        this.profArea = profArea;
    }

    public Integer getWorkExperienceFrom() {
        return workExperienceFrom;
    }

    public void setWorkExperienceFrom(Integer workExperienceFrom) {
        this.workExperienceFrom = workExperienceFrom;
    }

    public Integer getWorkExperienceTo() {
        return workExperienceTo;
    }

    public void setWorkExperienceTo(Integer workExperienceTo) {
        this.workExperienceTo = workExperienceTo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCompensationFrom() {
        return compensationFrom;
    }

    public void setCompensationFrom(Long compensationFrom) {
        this.compensationFrom = compensationFrom;
    }

    public Long getCompensationTo() {
        return compensationTo;
    }

    public void setCompensationTo(Long compensationTo) {
        this.compensationTo = compensationTo;
    }

    public Currency getCompensationCurrency() {
        return compensationCurrency;
    }

    public void setCompensationCurrency(Currency compensationCurrency) {
        this.compensationCurrency = compensationCurrency;
    }

    public Integer getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Integer employerId) {
        this.employerId = employerId;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getEmployerEmail() {
        return employerEmail;
    }

    public void setEmployerEmail(String employerEmail) {
        this.employerEmail = employerEmail;
    }

    public String getEmployerLogo() {
        return employerLogo;
    }

    public void setEmployerLogo(String employerLogo) {
        this.employerLogo = employerLogo;
    }
}
