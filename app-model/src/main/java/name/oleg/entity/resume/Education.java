package name.oleg.entity.resume;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Embeddable
public class Education {

    @Column(name = "INSTITUTION")
    private String institution;

    @Column(name = "SPECIALTY")
    private String specialty;

    @Column(name = "ADDITIONAL_SPECIALTY")
    private String additionalSpecialty;

    @Column(name = "ACADEMIC_DEGREE")
    private String academicDegree;

    @Column(name = "START_DATE")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "END_DATE")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date endDate;

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getAdditionalSpecialty() {
        return additionalSpecialty;
    }

    public void setAdditionalSpecialty(String additionalSpecialty) {
        this.additionalSpecialty = additionalSpecialty;
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
