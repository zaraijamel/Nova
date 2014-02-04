package name.oleg.entity.vacancy;

import name.oleg.entity.vacancy.Contact;
import name.oleg.entity.vacancy.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class Office {

    private String city;

    private String country;

    private String street;

    private Coordinate coordinate;

    private boolean chief;

    private List<Contact> contacts = new ArrayList<Contact>();

    public Office() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public boolean isChief() {
        return chief;
    }

    public void setChief(boolean chief) {
        this.chief = chief;
    }
}
