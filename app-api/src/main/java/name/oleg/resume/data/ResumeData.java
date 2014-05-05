package name.oleg.resume.data;

import org.apache.commons.collections.functors.InstantiateFactory;
import org.apache.commons.collections.list.LazyList;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResumeData {
    @NotEmpty(message = "Заполните поле Имя")
    private String firstName;
    @NotEmpty(message = "Заполните поле Отчество")
    private String middleName;
    @NotEmpty(message = "Заполните поле Фамилия")
    private String lastName;
    @NotEmpty(message = "Заполните поле Цели")
    private String goal;
    @NotEmpty(message = "Заполните поле Email")
    @Email(message = "Неверный формат поля Email")
    private String email;
    @NotEmpty(message = "Заполните поле Телефон")
    private String phone;
    private String pictureLogoUrl;
    private String website;
    private Date birthday;
    @Valid
    @NotNull
    private Address address;
    @Valid
    @NotNull
    private List<Education> educations;
    @Valid
    @NotNull
    private List<Experience> experiences;
    @Valid
    @NotNull
    private List<Ability> abilities;
    @Valid
    @NotNull
    private List<Recommendation> recommendations;

    public ResumeData() {
        educations = LazyList.decorate(new ArrayList<Education>(),
                new InstantiateFactory(Education.class));
        experiences = LazyList.decorate(new ArrayList<Experience>(),
                new InstantiateFactory(Experience.class));
        abilities = LazyList.decorate(new ArrayList<Ability>(),
                new InstantiateFactory(Ability.class));
        recommendations = LazyList.decorate(new ArrayList<Recommendation>(),
                new InstantiateFactory(Recommendation.class));
    }

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

    public String getPictureLogoUrl() {
        return pictureLogoUrl;
    }

    public void setPictureLogoUrl(String pictureLogoUrl) {
        this.pictureLogoUrl = pictureLogoUrl;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public List<Recommendation> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<Recommendation> recommendations) {
        this.recommendations = recommendations;
    }
}
