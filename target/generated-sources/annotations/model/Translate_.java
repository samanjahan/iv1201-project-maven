package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Competence;
import model.Language;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-04T18:18:49")
@StaticMetamodel(Translate.class)
public class Translate_ { 

    public static volatile SingularAttribute<Translate, Language> langName;
    public static volatile SingularAttribute<Translate, String> name;
    public static volatile SingularAttribute<Translate, Competence> competenceName;
    public static volatile SingularAttribute<Translate, Integer> translateId;

}