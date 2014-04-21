package name.oleg.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(WorkExperience.class)
public class WorkExperience_ {

    public static volatile SingularAttribute<WorkExperience, Integer> fromYears;

    public static volatile SingularAttribute<WorkExperience, Integer> toYears;
}
