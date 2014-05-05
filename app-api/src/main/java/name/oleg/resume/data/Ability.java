package name.oleg.resume.data;

import org.hibernate.validator.constraints.NotEmpty;

public class Ability {
    @NotEmpty(message = "Заполните поле Способность")
    private String title;
    @NotEmpty(message = "Заполните поле Дополнительная информация")
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
