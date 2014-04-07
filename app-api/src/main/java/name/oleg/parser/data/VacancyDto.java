package name.oleg.parser.data;

import java.util.Date;

public class VacancyDto {
    private int identifier;
    private String title;
    private String description;
    private String pageContent;
    private String area;
    private String sourceLink;
    private Date entranceDate;
    private Compensation compensation;
    private WorkExperience workExperience;
    private WorkSchedule workSchedule;
    private Education education;
    private Employer employer;
    private JobSource jobSource;
    private ProfessionalArea professionalArea;

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPageContent() {
        return pageContent;
    }

    public void setPageContent(String pageContent) {
        this.pageContent = pageContent;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSourceLink() {
        return sourceLink;
    }

    public void setSourceLink(String sourceLink) {
        this.sourceLink = sourceLink;
    }

    public Date getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(Date entranceDate) {
        this.entranceDate = entranceDate;
    }

    public Compensation getCompensation() {
        return compensation;
    }

    public void setCompensation(Compensation compensation) {
        this.compensation = compensation;
    }

    public WorkExperience getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(WorkExperience workExperience) {
        this.workExperience = workExperience;
    }

    public WorkSchedule getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(WorkSchedule workSchedule) {
        this.workSchedule = workSchedule;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public JobSource getJobSource() {
        return jobSource;
    }

    public void setJobSource(JobSource jobSource) {
        this.jobSource = jobSource;
    }

    public ProfessionalArea getProfessionalArea() {
        return professionalArea;
    }

    public void setProfessionalArea(ProfessionalArea professionalArea) {
        this.professionalArea = professionalArea;
    }

    public int hash() {
        return 0;
    }
}
