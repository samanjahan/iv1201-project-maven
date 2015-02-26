package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Person;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-26T14:08:45")
@StaticMetamodel(Availability.class)
public class Availability_ { 

    public static volatile SingularAttribute<Availability, Person> username;
    public static volatile SingularAttribute<Availability, Date> fromDate;
    public static volatile SingularAttribute<Availability, Long> availabilityId;
    public static volatile SingularAttribute<Availability, Date> toDate;

}