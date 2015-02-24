package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.CompetenceProfile;
import model.Language;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-23T19:15:00")
@StaticMetamodel(Translate.class)
public class Translate_ { 

    public static volatile SingularAttribute<Translate, CompetenceProfile> compId;
    public static volatile SingularAttribute<Translate, String> name;
    public static volatile SingularAttribute<Translate, Language> langIg;
    public static volatile SingularAttribute<Translate, Integer> translateId;

}