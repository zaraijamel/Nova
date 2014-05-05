package name.oleg.resume.data;

import org.hibernate.validator.constraints.NotEmpty;

public class Recommendation {
    @NotEmpty(message = "Заполните поле Имя")
    private String firstName;
    @NotEmpty(message = "Заполните поле Отчетсво")
    private String middleName;
    @NotEmpty(message = "Заполните поле Фамилия")
    private String lastName;
    @NotEmpty(message = "Заполните поле Рекомендация")
    private String text;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
