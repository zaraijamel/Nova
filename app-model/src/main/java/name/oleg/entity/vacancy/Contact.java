package name.oleg.entity.vacancy;

import java.util.ArrayList;
import java.util.List;

public class Contact {

    private String fullName;

    private List<String> phones = new ArrayList<String>();

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }
}
