package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Groups;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-22T19:06:46")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile SingularAttribute<Role, String> roleName;
    public static volatile CollectionAttribute<Role, Groups> groupsCollection;

}