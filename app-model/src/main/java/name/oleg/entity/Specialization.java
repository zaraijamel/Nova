package name.oleg.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
@Table(name = "SPECIALIZATION")
public class Specialization extends Entity {

    @Column(name = "TITLE")
    private String title;

    @ManyToOne
    @JoinColumn(name = "PROFESSIONAL_AREA_ID")
    private ProfessionalArea professionalArea;

    @OneToMany(mappedBy = "specialization")
    private List<Vacancy> vacancies = new ArrayList<Vacancy>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ProfessionalArea getProfessionalArea() {
        return professionalArea;
    }

    public void setProfessionalArea(ProfessionalArea professionalArea) {
        this.professionalArea = professionalArea;
    }
}
