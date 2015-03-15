/*
* This system was built as the project work
* for the IV1201 course of spring 2015 at KTH
* By group 20.
*
*/
package controller;

import integration.CompetenceProfileDAO;
import integration.RegisterDAO;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import model.Competence;
import java.util.*;


/**
 * The PersonController class handles the 
 * registration of new users.
 * It does however not access the database directly,
 * but instead uses the RegisterDAO and CompetenceProfileDAO
 * to store data in the database.
 * 
 * @author Group 20
 * 
 */
@Stateful
public class PersonController {    
    @EJB 
    RegisterDAO registerDAO;
    
    @EJB
    CompetenceProfileDAO CompetenceProfileDAO;
    
        
     /**
     * Forwards the input parameters to the register method
     * of the registerDAO class, which stores them in the database.
     * 
     *
     * @param name
     * @param surname
     * @param ssn
     * @param email
     * @param password
     * @param username
     * @throws RejectException
     */
    public void register(String name, String surname, String ssn, String email, String password, String username) throws RejectException {
        registerDAO.register(name, surname, ssn, email, password, username);      
    }
    
     /**
      * Checks whether a username is available 
      * by forwarding the parameter to the usernameAvailable
      * method of the registerDAO class.
      * 
      * @param username
      * @return 
      */
    public  boolean usernameAvailable(String username){
        return registerDAO.usernameAvailable(username);
    }
    
     /**
      * forwards the input parameters to the breateCompetenceProfile 
      * method of the CompetenceProfileDAO Class 
      * in order for it to store the data in the database.
      * 
      * @param userName
      * @param selectedcompetence
      * @param from
      * @param to
      * @param experienceList 
      */
    public void createCompetenceProfile(String userName ,List<Competence> selectedcompetence , Date from , Date to, List<String> experienceList){
        CompetenceProfileDAO.createCompetenceProfile(userName, selectedcompetence,from,to,experienceList);
    }
    
     /**
     * Sets the registerDAO instance of this class to point
     * to the given parameter object.
     *
     * @param RegisterDAO
     */
    public void setRegisterDAO(RegisterDAO registerDAO){
        this.registerDAO = registerDAO;
    }
    
    
    
}
