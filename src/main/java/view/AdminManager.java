/*
* This system was built as the project work
* for the IV1201 course of spring 2015 at KTH
* By group 20.
*
*/
package view;

import controller.AdminController;
import model.Competence;
import java.util.List;
import javax.annotation.PostConstruct;
import controller.RejectException;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 * 
 * The adminManager class is a view class
 * handling actions taken on admin panel
 * and forwarding them to the controller.
 * 
 * @author Group 20
 */
@RequestScoped

@ManagedBean(name = "admin")
public class AdminManager {
    @EJB AdminController adminController;
    
    private String competenceName;
    private String translateCompetenceName;
    private List<Competence> competenceList;

    /**
     *
     * @return list of competence
     */
    public List<Competence> getCompetenceList() {
        return competenceList;
    }
    
    /**
     *
     * @param competenceList list of competence
     */
    public void setCompetenceList(List<Competence> competenceList) {
        this.competenceList = competenceList;
    }

    /**
     *
     * @return translation of the competence
     */
    public String getTranslateCompetenceName() {
        return translateCompetenceName;
    }

    /**
     *
     * @param translateCompetenceName translation of the competence
     */
    public void setTranslateCompetenceName(String translateCompetenceName) {
        this.translateCompetenceName = translateCompetenceName;
    }

    /**
     *
     * @return name of the competence
     */
    public String getCompetenceName() {
        return competenceName;
    }

    /**
     *
     * @param competenceName name of the competence
     */
    public void setCompetenceName(String competenceName) {
        this.competenceName = competenceName;
    }
    
    /**
     * forwards parameters to the controller in order to
     * create a new competence. 
     * 
     * in case of errors, an error message is shown through the
     * message factory
     * 
     * @return empty string 
     * @throws RejectException
     */
    public String createCompetence() throws RejectException{
           if(!validate()){
            return "";
        }
           try {
            adminController.createCompetence(competenceName,translateCompetenceName);
            String message = "Registraion was successfull!";
               setCompetenceName(null);
               setTranslateCompetenceName(null);
               showAllCompetence();
            MessageFactory.getInstance().addInfoMessage(message);
        } catch (Exception e) {
            MessageFactory.getInstance().addErrorMessage(e.getMessage());
        }
           return  "";
        
    }
    
    /**
     * checks the validity of the entered parameter 'compotenceName'
     * by using the competenceValidation method.
     * 
     * @return boolean reflecting the result of validation
     */
    public  boolean validate(){
        if(!competenceValidation(competenceName)){
          String message = "Competence already created";
          MessageFactory.getInstance().addInfoMessage(message);
            return false;            
        }
        return true;
    }
    
    /**
     * checks the validity of a competence by using the
     * competenceAvailable method of the adminController.
     * 
     * @param competenceBane
     * @return boolean reflecting the result of validation
     */
    public boolean competenceValidation(String competenceBane){      
            return !(!adminController.competenceAvailable(competenceBane));
    }
    
    /**
     *sets the competenceList value of this class to
     * the result of getAllCompetence method of the adminController.
     */
    @PostConstruct
    public void showAllCompetence(){
        competenceList = adminController.getAllAcompetence();
    }
    
    /**
     * deletes a competence with a given name through
     * the use of the adminController.
     * 
     * @param competence
     * @return empty string
     * @throws RejectException
     */
    public String deleteCompetence(Competence competence) throws RejectException{
        adminController.deleteCompetence(competence);
        showAllCompetence();
        return "";
        
    }
}
