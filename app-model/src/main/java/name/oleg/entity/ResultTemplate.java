package name.oleg.entity;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "RESUME_TEMPLATE")
public class ResultTemplate extends Entity {

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

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
}
