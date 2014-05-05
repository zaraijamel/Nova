package name.oleg.resume.data;

import org.hibernate.validator.constraints.NotEmpty;

public class Address {
    @NotEmpty(message = "Заполните поле Город")
    private String city;
    @NotEmpty(message = "Заполните поле Адрес")
    private String street;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
