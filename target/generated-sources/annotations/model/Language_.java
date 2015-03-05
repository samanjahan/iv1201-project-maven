package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Translate;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-03-04T18:18:49")
@StaticMetamodel(Language.class)
public class Language_ { 

    public static volatile SingularAttribute<Language, String> name;
    public static volatile SingularAttribute<Language, Long> langId;
    public static volatile CollectionAttribute<Language, Translate> translateCollection;

}