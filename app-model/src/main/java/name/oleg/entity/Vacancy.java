package name.oleg.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@javax.persistence.Entity
@Table(name = "VACANCY")
public class Vacancy extends Entity {

    @Column(name = "IDENTIFIER")
    private Integer identifier;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    @Lob
    private String description;

    @Column(name = "AREA")
    private String area;

    @Column(name = "ENTRANCE_DATE")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date entranceDate;

    @Column(name = "SOURCE_LINK")
    private String sourceLink;

    @Column(name = "PAGE_CONTENT")
    @Lob
    private String pageContent;

    @Embedded
    private Compensation compensation;

    @Embedded
    private WorkExperience workExperience;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "WORK_SCHEDULE")
    private WorkSchedule workSchedule;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "EDUCATION")
    private Education education;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROFESSIONAL_AREA_ID")
    private ProfessionalArea professionalArea;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLOYER_ID")
    private Employer employer;

    @ElementCollection
    @CollectionTable(name = "TAGS", joinColumns = @JoinColumn(name = "VACANCY_ID"))
    @Column(name = "TAG")
    private List<String> tags;

    public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Integer identifier) {
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Date getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(Date entranceDate) {
        this.entranceDate = entranceDate;
    }

    public String getSourceLink() {
        return sourceLink;
    }

    public void setSourceLink(String sourceLink) {
        this.sourceLink = sourceLink;
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

    public String getPageContent() {
        return pageContent;
    }

    public void setPageContent(String pageContent) {
        this.pageContent = pageContent;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public ProfessionalArea getProfessionalArea() {
        return professionalArea;
    }

    public void setProfessionalArea(ProfessionalArea professionalArea) {
        this.professionalArea = professionalArea;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
