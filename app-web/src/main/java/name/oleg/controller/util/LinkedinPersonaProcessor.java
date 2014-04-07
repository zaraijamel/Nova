package name.oleg.controller.util;

import com.google.code.linkedinapi.schema.*;
import name.oleg.resume.data.*;
import name.oleg.resume.data.Address;
import name.oleg.resume.data.Education;
import name.oleg.resume.data.Recommendation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LinkedinPersonaProcessor {

    public ResumeData toResumeData(Person person) {
        ResumeData resumeData = new ResumeData();
        resumeData.setFirstName(person.getFirstName());
        resumeData.setLastName(person.getLastName());
        resumeData.setPictureLogoUrl(person.getPictureUrl());
        resumeData.setGoal(person.getHonors());
        if (person.getPhoneNumbers() != null) {
            if (person.getPhoneNumbers().getTotal() != 0) {
                resumeData.setPhone(person.getPhoneNumbers().getPhoneNumberList().get(0).getPhoneNumber());
            }
        }
        if (person.getLocation() != null) {
            resumeData.setAddress(getAddress(person.getLocation()));
        }
        if (person.getDateOfBirth() != null) {
            resumeData.setBirthday(DateConverter.create(person.getDateOfBirth()).getDate());
        }
        if (person.getEducations() != null) {
            resumeData.setEducations(getEducations(person.getEducations()));
        }
        if (person.getPositions() != null) {
            resumeData.setExperiences(getExperiences(person.getPositions()));
        }
        if (person.getRecommendationsGiven() != null) {
            resumeData.setRecommendations(getRecommendations(person.getRecommendationsGiven()));
        }
        if (person.getSkills() != null) {
            resumeData.setAbilities(getAbilities(person.getSkills()));
        }
        return resumeData;
    }

    private Address getAddress(Location location) {
        com.google.code.linkedinapi.schema.Address addressFrom = location.getAddress();
        Address addressTo = new Address();
        addressTo.setCity(addressFrom.getCity());
        addressTo.setStreet(addressFrom.getStreet1());
        return addressTo;
    }

    private List<Education> getEducations(Educations educations) {
        List<Education> result = new ArrayList<Education>();
        for (com.google.code.linkedinapi.schema.Education educationFrom : educations.getEducationList()) {
            Education educationTo = new Education();
            educationTo.setInstitution(educationFrom.getSchoolName());
            educationTo.setAcademicDegree(educationFrom.getDegree());
            educationTo.setStartDate(DateConverter.create(educationFrom.getStartDate()).getDate());
            educationTo.setEndDate(DateConverter.create(educationFrom.getEndDate()).getDate());
            result.add(educationTo);
        }
        return result;
    }

    private List<Ability> getAbilities(Skills skills) {
        List<Ability> result = new ArrayList<Ability>();
        for (Skill skill : skills.getSkillList()) {
            Ability ability = new Ability();
            ability.setTitle(skill.getSkill().getName());
            ability.setDescription(skill.getProficiency().getName());
            result.add(ability);
        }
        return result;
    }

    private List<Recommendation> getRecommendations(RecommendationsGiven recommendations) {
        List<Recommendation> result = new ArrayList<Recommendation>();
        for (com.google.code.linkedinapi.schema.Recommendation recommendationFrom : recommendations.getRecommendationList()) {
            Recommendation recommendationTo = new Recommendation();
            Recommender recommender = recommendationFrom.getRecommender();
            recommendationTo.setFirstName(recommender.getFirstName());
            recommendationTo.setLastName(recommender.getLastName());
            recommendationTo.setText(recommendationFrom.getRecommendationText());
            result.add(recommendationTo);
        }
        return result;
    }

    private List<Experience> getExperiences(Positions positions) {
        List<Experience> result = new ArrayList<Experience>();
        for (Position position : positions.getPositionList()) {
            Experience experience = new Experience();
            experience.setOrganization(position.getCompany().getName());
            experience.setPosition(position.getTitle());
            experience.setResponsibility(position.getDescription());
            experience.setStartDate(DateConverter.create(position.getStartDate()).getDate());
            experience.setEndDate(DateConverter.create(position.getEndDate()).getDate());
            result.add(experience);
        }
        return result;
    }

    private static class DateConverter {
        private int day;
        private int month;
        private int year;

        private DateConverter(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }

        private static DateConverter create(DateOfBirth dateOfBirth) {
            return new DateConverter(dateOfBirth.getDay().intValue(), dateOfBirth.getMonth().intValue(),
                    dateOfBirth.getYear().intValue());
        }

        private static DateConverter create(StartDate startDate) {
            return new DateConverter(startDate.getDay().intValue(), startDate.getMonth().intValue(),
                    startDate.getYear().intValue());
        }

        private static DateConverter create(EndDate endDate) {
            return new DateConverter(endDate.getDay().intValue(), endDate.getMonth().intValue(),
                    endDate.getYear().intValue());
        }

        public Date getDate() {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_YEAR, day);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.YEAR, year);
            return calendar.getTime();
        }
    }
}
