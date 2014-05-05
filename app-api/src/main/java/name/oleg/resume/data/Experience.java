package name.oleg.resume.data;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Experience {
    @NotEmpty(message = "Заполните поле Должность")
    private String position;
    @NotEmpty(message = "Заполните поле Организация")
    private String organization;
    @NotEmpty(message = "Заполните поле Обязанности")
    private String responsibility;
    @NotEmpty(message = "Заполние поле Начало")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date startDate;
    @NotEmpty(message = "Заполните поле Окончание")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date endDate;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
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
