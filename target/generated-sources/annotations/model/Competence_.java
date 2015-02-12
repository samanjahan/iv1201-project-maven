package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.CompetenceProfile;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-02-12T16:00:56")
@StaticMetamodel(Competence.class)
public class Competence_ { 

    public static volatile SingularAttribute<Competence, Long> competenceId;
    public static volatile SingularAttribute<Competence, String> name;
    public static volatile CollectionAttribute<Competence, CompetenceProfile> competenceProfileCollection;

}