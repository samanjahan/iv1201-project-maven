package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.CompetenceProfile;
import model.Language;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-10T20:37:04")
@StaticMetamodel(Translate.class)
public class Translate_ { 

    public static volatile SingularAttribute<Translate, Integer> translateId;
    public static volatile SingularAttribute<Translate, CompetenceProfile> compId;
    public static volatile SingularAttribute<Translate, String> name;
    public static volatile SingularAttribute<Translate, Language> langIg;

}