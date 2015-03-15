/*
* This system was built as the project work
* for the IV1201 course of spring 2015 at KTH
* By group 20.
*
*/
package integration;

import controller.RejectException;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.Language;
import model.Translate;
import java.util.List;
import model.Competence;
import model.CompetenceProfile;


/**
 * CompetenceDAO is the class that handles all 
 * database transactions concerning competences.
 * 
 * These transactions are handled through an entity manager
 * Meaning the competence entity classes in the model package is
 * used here.
 * 
 * @author Group 20
 */
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless

public class CompetenceDAO {
    @PersistenceContext(unitName = "mavenprojectiv1201")
    private EntityManager em;
    
    
    /**
     * creates a new competence object 
     * and sets its values to the given parameters.
     * 
     * the newly created competence object is then persisted.
     * 
     * the same is done for the translation of the entered competence.
     * 
     * @param competenceName
     * @param translateCompetenceName
     * @throws RejectException 
     */
    public void createCompetence(String competenceName, String translateCompetenceName) throws RejectException{
        
        if(getCompetence(competenceName) != null){
            throw new RejectException("Competence has alredy created");
        }
        
        Competence competence = new Competence();
        competence.setName(competenceName);
        em.persist(competence);
       
        Translate trasnlate = new Translate();
        trasnlate.setName(translateCompetenceName);
        trasnlate.setCompetenceName(competence);
        Language language = em.find(Language.class, "sw");
        trasnlate.setLangName(language);
        em.persist(trasnlate);
        
    }
    
    /**
     * uses the entity manager to find and return an already
     * existing competence in the database.
     * 
     * @param competenceName
     * @return a competence matching the input param
     */
    public Competence getCompetence(String competenceName){
        Competence competence = em.find(Competence.class, competenceName);
        return competence;
    }
    
    /**
     * 
     * @param em 
     */
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    /**
     * uses the entity manager to get and return a list of
     * all already existing competences in the database
     * 
     * @return a list of all competences
     */
    public List<Competence> getAllCompetence(){
        TypedQuery<Competence> competencequesrList = em.createNamedQuery("Competence.findAll",Competence.class);
        List<Competence> competenceList = competencequesrList.getResultList();
        return competenceList;
    }
    
    /**
     * uses the entity manager to remove 
     * an already existing competence from the 
     * database.
     * 
     * @param competence
     * @throws RejectException 
     */
    public void deleteCompetence(Competence competence) throws RejectException{
        String competenceName = competence.getName();
        Translate translate = findTranslate(competenceName);
        deleteCompetenceProfile(competence);
        if(translate == null){
            throw new RejectException("Competence not found");
        }
        em.remove(translate);
        Competence deleteCompetence = getCompetence(competenceName);
        em.remove(deleteCompetence);
        
    }
    
    /**
     * takes the name of a competence and tries to find
     * any existing translation of it.
     * If found, the translation is returned as a translation object.
     * 
     * @param competenceName
     * @return the translation of the input parameter.
     */
    private Translate findTranslate(String competenceName){
        TypedQuery<Translate> transleQueryList = em.createNamedQuery("Translate.findAll",Translate.class);
        List<Translate> translateList = transleQueryList.getResultList();
        Translate translate = null;
        for(int i = 0 ; i < translateList.size(); ++i){
            if(translateList.get(i).getCompetenceName().getName().equals(competenceName)){
                translate = translateList.get(i);
            }
        }
        return translate;
    }
    
    /**
     * finds an existing competence with a
     * name matching the input parameter in the database.
     * 
     * @param competenceName
     * @return a competence object with a name matching the input parameter.
     */
    public Competence findCompetence(String competenceName){
        Competence competence = em.find(Competence.class, competenceName);
        return competence;
    }
    
    /**
     * uses the entity manager to delete any existing 
     * competenceProfile with a name matching the input parameter.
     * 
     * @param competence 
     */
    public void deleteCompetenceProfile(Competence competence){
        TypedQuery<CompetenceProfile> comProfileQueryList = em.createNamedQuery("CompetenceProfile.findAll",CompetenceProfile.class);
        List<CompetenceProfile> listOfCompetenceProfile = comProfileQueryList.getResultList();
        for(int i = 0 ; i < listOfCompetenceProfile.size(); ++i){
            if(listOfCompetenceProfile.get(i).getCompetenceId().getName().equals(competence.getName())){
                em.remove(listOfCompetenceProfile.get(i));
            }
        }
    }
    
    
}
