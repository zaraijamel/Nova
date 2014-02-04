package name.oleg.entity.resume;

import name.oleg.entity.Entity;
import name.oleg.entity.Period;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JobSeeker extends Entity {

    private String firstName;

    private String middleName;

    private String lastName;

    private Date birthday;

    private String professionalSkills;

    private String additionalInformation;

    private String hobbies;

    private List<Experience> experiences = new ArrayList<Experience>();

    private static class Contact {

        private String phone;

        private String email;

    }

    private static class Education {

        private String title;

        private Period period;
    }
}
