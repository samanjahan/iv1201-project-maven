package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Person;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-10T14:08:17")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile SingularAttribute<Role, Long> roleId;
    public static volatile CollectionAttribute<Role, Person> personCollection;
    public static volatile SingularAttribute<Role, String> name;

}