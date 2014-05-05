package name.oleg.resume.data;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Education {
    @NotEmpty(message = "Заполните поле Учреждение образования")
    private String institution;
    @NotEmpty(message = "Заполните поле Специальность")
    private String specialty;
    @NotEmpty(message = "Заполните поле Дополнительная специальность")
    private String additionalSpecialty;
    @NotEmpty(message = "Заполните поле Ученая степень")
    private String academicDegree;
    @NotEmpty(message = "Заполните поле Начало")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date startDate;
    @NotEmpty(message = "Заполните поле Окончание")
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
