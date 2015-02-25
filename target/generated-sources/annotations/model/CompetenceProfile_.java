package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Competence;
import model.Person;
import model.Translate;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-25T14:31:51")
@StaticMetamodel(CompetenceProfile.class)
public class CompetenceProfile_ { 

    public static volatile SingularAttribute<CompetenceProfile, Long> competenceProfileId;
    public static volatile SingularAttribute<CompetenceProfile, Translate> translateName;
    public static volatile SingularAttribute<CompetenceProfile, Person> userName;
    public static volatile SingularAttribute<CompetenceProfile, Double> yearsOfExperience;
    public static volatile SingularAttribute<CompetenceProfile, Competence> competenceName;

}