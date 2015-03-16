/*
* This system was built as the project work
* for the IV1201 course of spring 2015 at KTH
* By group 20.
*
*/
package integration;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import model.CompetenceProfile;
import model.Person;
import java.util.ArrayList;

/**
 * UserHandlerDAO handles
 * 
 * @author syst3m
 */
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class UserHandleDAO {
    @PersistenceContext(unitName = "mavenprojectiv1201")
    private EntityManager em;
    
    @Inject
    RegisterDAO registerDAO;
    
    @Inject
    CompetenceProfileDAO competenceProfileDAO;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Map<String, List<String>> findAllUsers(){
       List<Person> personList =  registerDAO.getAllUser();
       List<CompetenceProfile> competenceProfile = competenceProfileDAO.getAllCompetenceProfile();
       Map<String, List<String>> alternateMap = new HashMap<>();
       List<String> compList;
       for(int  i = 0 ; i < personList.size(); ++i){
           compList = new ArrayList<String>();
           String username = personList.get(i).getUsername();
           for(int j = 0 ; j < competenceProfile.size(); ++j){
               if(username.toLowerCase().equals(competenceProfile.get(j).getUserName().getName().toLowerCase())){
                   compList.add(competenceProfile.get(j).getCompetenceId().getName());
               }
           }
           if(!compList.isEmpty()){
               alternateMap.put(username, compList);
           }
       }
       return alternateMap;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public RegisterDAO getRegisterDAO() {
        return registerDAO;
    }

    public void setRegisterDAO(RegisterDAO registerDAO) {
        this.registerDAO = registerDAO;
    }

    public CompetenceProfileDAO getCompetenceProfileDAO() {
        return competenceProfileDAO;
    }

    public void setCompetenceProfileDAO(CompetenceProfileDAO competenceProfileDAO) {
        this.competenceProfileDAO = competenceProfileDAO;
    }
}
    

