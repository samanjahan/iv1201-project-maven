/*
* This system was built as the project work
* for the IV1201 course of spring 2015 at KTH
* By group 20.
*
*/
package controller;

import integration.CompetenceDAO;
import integration.RegisterDAO;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import model.Competence;
import java.util.List;

/**
 * The AdminController class is a controller class 
 * meant to handle actions taken on the admin console.
 * 
 * However, this class cannot access the database directly.
 * Instead, it uses the competenceDAO and registerDAO 
 * in order to carry out database related transactions.
 * 
 * @author Group 20
 */

@Stateful
public class AdminController {
    @EJB
    CompetenceDAO competenceDAO;
    
    @EJB 
    RegisterDAO registerDAO;
    
    /**
     * Forwards input data to the createCompetence method
     * of the competenceDAO class in order to add 
     * a new comptence to the database
     * 
     * @param competenceName
     * @param translateCompetenceName
     * @throws RejectException
     */
    public void createCompetence(String competenceName,String translateCompetenceName) throws RejectException{
        competenceDAO.createCompetence(competenceName,translateCompetenceName);
    }
    
    /**
     * Uses the getCompotence method of the competenceDAO class
     * in order to find out whether the given competence already
     * exists or not.
     * If the returned object from the competenceDAO class is null, 
     * it is assumed that the competence does not yet exist.
     *
     * @param competenceName
     * @return A boolean reflecting the existence state of the competence
     */
    public boolean competenceAvailable(String competenceName){
        if(competenceDAO.getCompetence(competenceName) != null){
            return false;
        }
        return true;
    }
    
    /**
     * Uses the getAllCompetence method of the competenceDAO
     * class in order get a list of all competences currently 
     * existing in the database.
     * 
     * @return a list of all existing competence.
     */
    public List<Competence> getAllAcompetence(){
        return competenceDAO.getAllCompetence();
    }
    
    /**
     * uses the deleteCompetence method of the competenceDAO
     * class in order to remove an existing competence from the 
     * database
     * 
     * @param competence
     * @throws RejectException
     */
    public void deleteCompetence(Competence competence) throws RejectException{        
        competenceDAO.deleteCompetence(competence);
    }

    /**
     * Sets the competenceDAO instance of this class to point
     * to the given parameter object.
     *
     * @param competenceDAO
     */
    public void setCompetenceDAO(CompetenceDAO competenceDAO){
        this.competenceDAO = competenceDAO;
    }
}
