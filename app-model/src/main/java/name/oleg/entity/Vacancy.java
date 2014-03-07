package name.oleg.entity;

import javax.persistence.*;
import java.util.Date;

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

    @ManyToOne
    @JoinColumn(name = "SPECIALIZATION_ID")
    private Specialization specialization;

    @ManyToOne
    @JoinColumn(name = "EMPLOYER_ID")
    private Employer employer;

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

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
}
