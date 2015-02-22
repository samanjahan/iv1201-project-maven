package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Person;
import model.Role;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-22T19:06:46")
@StaticMetamodel(Groups.class)
public class Groups_ { 

    public static volatile SingularAttribute<Groups, Long> id;
    public static volatile SingularAttribute<Groups, Role> groupname;
    public static volatile SingularAttribute<Groups, Person> username;

}