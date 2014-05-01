package name.oleg.resume.data;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Education {
    private String institution;
    private String specialty;
    private String additionalSpecialty;
    private String academicDegree;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date startDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
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
