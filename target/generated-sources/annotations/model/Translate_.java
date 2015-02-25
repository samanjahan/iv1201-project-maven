package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Competence;
import model.CompetenceProfile;
import model.Language;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-25T14:31:51")
@StaticMetamodel(Translate.class)
public class Translate_ { 

    public static volatile SingularAttribute<Translate, Language> langName;
    public static volatile SingularAttribute<Translate, String> name;
    public static volatile CollectionAttribute<Translate, CompetenceProfile> competenceProfileCollection;
    public static volatile SingularAttribute<Translate, Competence> competenceName;
    public static volatile SingularAttribute<Translate, Integer> translateId;

}