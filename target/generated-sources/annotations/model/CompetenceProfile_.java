package model;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Person;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-29T22:00:39")
@StaticMetamodel(CompetenceProfile.class)
public class CompetenceProfile_ { 

    public static volatile SingularAttribute<CompetenceProfile, Person> username;
    public static volatile SingularAttribute<CompetenceProfile, Long> competenceProfileId;
    public static volatile SingularAttribute<CompetenceProfile, BigInteger> competenceId;
    public static volatile SingularAttribute<CompetenceProfile, Double> yearsOfExperience;

}