package name.oleg.entity;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
@Table(name = "PROFESSIONAL_AREA")
public class ProfessionalArea extends Entity {

    @Column(name = "TITLE")
    private String title;

    @OneToMany(mappedBy = "professionalArea")
    private List<Specialization> specializations = new ArrayList<Specialization>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<Specialization> specializations) {
        this.specializations = specializations;
    }
}
