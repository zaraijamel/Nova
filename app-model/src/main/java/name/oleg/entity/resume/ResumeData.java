package name.oleg.entity.resume;

import name.oleg.entity.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@javax.persistence.Entity
@Table(name = "RESUME_DATA")
public class ResumeData extends Entity {

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PICTURE_LOGO_URL")
    private String pictureLogoUrl;

    @Column(name = "WEBSITE")
    private String website;

    @Column(name = "GOAL")
    private String goal;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "BIRTHDAY")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date birthday;

    @Embedded
    private Address address;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "RESUME_EDUCATION", joinColumns = @JoinColumn(name = "RESUME_ID"))
    @OrderColumn
    private List<Education> educations;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "RESUME_EXPERIENCE", joinColumns = @JoinColumn(name = "RESUME_ID"))
    @OrderColumn
    private List<Experience> experiences;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "RESUME_ABILITY", joinColumns = @JoinColumn(name = "RESUME_ID"))
    @OrderColumn
    private List<Ability> abilities;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "RESUME_RECOMMENDATION", joinColumns = @JoinColumn(name = "RESUME_ID"))
    @OrderColumn
    private List<Recommendation> recommendations;

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
