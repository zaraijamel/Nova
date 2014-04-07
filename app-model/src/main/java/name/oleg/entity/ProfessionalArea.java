package name.oleg.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
@Table(name = "PROFESSIONAL_AREA")
public class ProfessionalArea extends Entity {

    @Column(name = "TITLE")
    private String title;

    @OneToMany(mappedBy = "professionalArea")
    private List<Vacancy> vacancies = new ArrayList<Vacancy>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }
}
