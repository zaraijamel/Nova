package name.oleg.entity.vacancy;

import name.oleg.entity.Entity;
import name.oleg.entity.vacancy.Category;

public class Subcategory extends Entity {

    private String title;

    private Category category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
