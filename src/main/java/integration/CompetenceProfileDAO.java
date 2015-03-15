/*
* This system was built as the project work
* for the IV1201 course of spring 2015 at KTH
* By group 20.
*
*/
package integration;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Competence;
import model.Person;
import java.util.ArrayList;
import javax.persistence.TypedQuery;
import model.Availability;
import model.CompetenceProfile;

/**
 * CompetenceProfileDAO is the class that handles all 
 * database transactions concerning competenceProfiles.
 * 
 * These transactions are handled through an entity manager
 * Meaning the competence entity classes in the model package is
 * used here.
 * 
 */
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class CompetenceProfileDAO{
    @PersistenceContext(unitName = "mavenprojectiv1201")
    private EntityManager em;
    
    private double yearsOfExperience;
    
    @Inject
    RegisterDAO registerDAO;
    
    @Inject
    CompetenceDAO competenceDAO;
    
    /**
     * Uses the entity manager to find an already
     * existing competence from the database 
     * 
     * @param competenceName
     * @return competence object with a name matching the input parameter
     */
    public Competence getCompetence(String competenceName){
        Competence competence = em.find(Competence.class, competenceName);
        return competence;
    }
    
    /**
     * creates a competenceOProfile object and 
     * sets its values to the input parameters.
     * 
     * the newly created object is then persisted
     * into the database through the entity manager.
     * 
     * @param userName
     * @param selectedcompetence
     * @param from
     * @param to
     * @param experienceList 
     */
    public void createCompetenceProfile(String userName ,List<Competence> selectedcompetence , Date from , Date to,List<String> experienceList){
        
        Person person = registerDAO.findPerson(userName);
        
        List<Competence> listofCompetence = getAllCompetence(selectedcompetence);
        createAvilability(from,to,person);
        
         for(int i = 0 ; i < listofCompetence.size(); ++i){
             CompetenceProfile competenceProfile = new CompetenceProfile();     
             yearsOfExperience = Double.valueOf(experienceList.get(i));           
             competenceProfile.setUserName(person);
             competenceProfile.setCompetenceId(listofCompetence.get(i));
             competenceProfile.setYearsOfExperience(yearsOfExperience);
             em.persist(competenceProfile);
           
        }        
    }
    
    /**
     * finds and returns a list of all of the 
     * already existing competences in the database
     * 
     * @param list
     * @return list of all competences in the database
     */
    public List<Competence> getAllCompetence(List<Competence> list){
        List<Competence> listofCompetence = new ArrayList<Competence>();
        for(int  i = 0 ; i< list.size(); ++i){
            Competence competence = competenceDAO.findCompetence(list.get(i).getName());
            listofCompetence.add(competence);
        }
        return listofCompetence;
    }
    
    /**
     * Creates a new availability object
     * and sets its values to the input parameters.
     * 
     * the newly created object is then persisted
     * through the entity manager.
     * 
     * @param ftom
     * @param to
     * @param person 
     */
    private void createAvilability(Date ftom, Date to, Person person){
        Availability avibilityla = new Availability();
        avibilityla.setFromDate(ftom);
        avibilityla.setToDate(to);
        avibilityla.setUsername(person);
        em.persist(avibilityla);
    }
    
    /**
     * finds and returns a list of all of the 
     * already existing competenceProfiles in the database
     * 
     * @return list of all competenceProfiles in the database
     */
    public List<CompetenceProfile> getAllCompetenceProfile(){
         TypedQuery<CompetenceProfile> competenceProquesrList = em.createNamedQuery("CompetenceProfile.findAll",CompetenceProfile.class);
        List<CompetenceProfile> compProList = competenceProquesrList.getResultList();
        return compProList;
    }
}
