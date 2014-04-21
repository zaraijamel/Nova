package name.oleg.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Vacancy.class)
public class Vacancy_ {

    public static volatile SingularAttribute<Vacancy, String> title;

    public static volatile SingularAttribute<Vacancy, Compensation> compensation;

    public static volatile SingularAttribute<Vacancy, Date> entranceDate;

    public static volatile SingularAttribute<Vacancy, WorkSchedule> workSchedule;

    public static volatile SingularAttribute<Vacancy, Education> education;

    public static volatile SingularAttribute<Vacancy, WorkExperience> workExperience;
}
