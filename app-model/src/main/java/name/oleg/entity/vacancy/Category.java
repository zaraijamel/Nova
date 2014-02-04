package name.oleg.entity.vacancy;

import name.oleg.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class Category extends Entity {

    private String title;

    private List<Subcategory> subcategories = new ArrayList<Subcategory>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }
}
