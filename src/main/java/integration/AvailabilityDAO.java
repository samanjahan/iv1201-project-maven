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
public class AvailabilityDAO{
    @PersistenceContext(unitName = "mavenprojectiv1201")
    private EntityManager em;
    
    
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
    public List<Availability> getAllAvailability(){
        TypedQuery<Availability>  availability = em.createNamedQuery("Availability.findAll", Availability.class);
        List<Availability> availabilityList = availability.getResultList();
        return availabilityList;
    }
    
    public Availability getAvailability(String username){
        List<Availability> list = getAllAvailability();
        for(Availability e: list){
            if(username.equals(e.getUsername().getName()))
                return e;
        }
        return null;
    }
}
