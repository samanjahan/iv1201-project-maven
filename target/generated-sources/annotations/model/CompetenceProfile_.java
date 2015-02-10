package model;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Competence;
import model.Person;
import model.Translate;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-10T20:37:04")
@StaticMetamodel(CompetenceProfile.class)
public class CompetenceProfile_ { 

    public static volatile CollectionAttribute<CompetenceProfile, Translate> translateCollection;
    public static volatile SingularAttribute<CompetenceProfile, BigInteger> competenceId;
    public static volatile SingularAttribute<CompetenceProfile, Double> yearsOfExperience;
    public static volatile SingularAttribute<CompetenceProfile, Competence> compId;
    public static volatile SingularAttribute<CompetenceProfile, Long> competenceProfileId;
    public static volatile SingularAttribute<CompetenceProfile, Person> username;

}