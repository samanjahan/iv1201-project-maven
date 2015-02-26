package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Availability;
import model.CompetenceProfile;
import model.Role;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-26T14:08:45")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, String> username;
    public static volatile SingularAttribute<Person, String> email;
    public static volatile SingularAttribute<Person, String> name;
    public static volatile SingularAttribute<Person, String> ssn;
    public static volatile SingularAttribute<Person, String> surname;
    public static volatile CollectionAttribute<Person, CompetenceProfile> competenceProfileCollection;
    public static volatile SingularAttribute<Person, String> password;
    public static volatile CollectionAttribute<Person, Availability> availabilityCollection;
    public static volatile CollectionAttribute<Person, Role> roleCollection;

}