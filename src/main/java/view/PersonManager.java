/*
* This system was built as the project work
* for the IV1201 course of spring 2015 at KTH
* By group 20.
*
*/
package view;

import controller.AdminController;
import controller.PersonController;
import controller.RejectException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Competence;
import java.util.*;

/**
 * the PersonManager class is a view class handling the
 * creation and editing of the person entity at the view level.
 * 
 * 
 */
@RequestScoped

@ManagedBean(name = "personProfile")
public class PersonManager {
    
      @EJB PersonController personController;
      @EJB AdminController adminController;
      
      private List<Competence> competenceList;
      private List<Comparable> selectedItems;
      private Map<String, Boolean> checked = new HashMap<String, Boolean>();
      private List<String> experienceList = new ArrayList<String>();
      private Date from;
      private Date to;
      private String username;
      private String experience;

    /**
     * 
     * @return experience of person
     */
    public String getExperience() {
        return experience;
    }

    /**
     *
     * @param experience of person
     */
    public void setExperience(String experience) {
        if(experience.isEmpty()){
            this.experienceList.add("0");
        }else{
            this.experienceList.add(experience);
        }
        
        
    }

    /**
     *
     * @return list of experience of person
     */
    public List<String> getExperienceList() {
        return experienceList;
    }

    /**
     *
     * @param experience experience of person
     */
    public void setExperienceList(String experience) {
        System.out.println("SetStrings " + experience);
    //    this.strings.add(strings);
    }
      
    /**
     *
     * @return starting date of experience
     */
    public Date getFrom() {
        return from;
    }

    /**
     *
     * @param from starting date of experience
     */
    public void setFrom(Date from) {
        this.from = from;
    }

    /**
     *
     * @return ending date of experience
     */
    public Date getTo() {
        return to;
    }

    /**
     *
     * @param to ending date of experience
     */
    public void setTo(Date to) {
        this.to = to;
    }

    /**
     *
     * @return username of person
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username username of person
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return the controller handling person objects
     */
    public PersonController getPersonController() {
        return personController;
    }

    /**
     *
     * @param personController the controller handling person objects
     */
    public void setPersonController(PersonController personController) {
        this.personController = personController;
    }

    /**
     *
     * @return 
     */
    public Map<String, Boolean> getChecked() {
        return checked;
    }

    /**
     *
     * @param checked
     */
    public void setChecked(Map<String, Boolean> checked) {
        this.checked = checked;
    }

    /**
     *
     * @return list of selected items
     */
    public List<Comparable> getSelectedItems() {
        return selectedItems;
    }

    /**
     *
     * @param selectedItems list of selected items
     */
    public void setSelectedItems(List<Comparable> selectedItems) {
        this.selectedItems = selectedItems;
    }

    /**
     *
     * @return list of competences
     */
    public List<Competence> getCompetenceList() {
        return competenceList;
    }

    /**
     *
     * @param competenceList list of competences
     */
    public void setCompetenceList(List<Competence> competenceList) {
        this.competenceList = competenceList;
    }
      
    /**
     * sets the competenceList value of this class to 
     * the result of the getAllAcompetence method of the admin controller
     */
    @PostConstruct
    public void showAllCompetence(){
        competenceList = adminController.getAllAcompetence();
    }
    
    /**
     * submits the input parameters to the personController
     * in order for the creation of the competenceProfile
     * 
     * @return
     * @throws RejectException
     */
    public String submit() throws RejectException{        
        List<Competence> checkedItems = new ArrayList<Competence>();
        for(Competence comp : competenceList){
            if(checked.get(comp.getName())){
                checkedItems.add(comp);
            }
        }
        if(checkedItems.isEmpty()){
              String message = "Least choose one competence!";
            MessageFactory.getInstance().addInfoMessage(message);
            return "";
        }
        try {
            personController.createCompetenceProfile(username,checkedItems,from,to,experienceList);
        } catch (Exception e) {
            MessageFactory.getInstance().addErrorMessage(e.getMessage());
        }
        
        return "";
    }
    
}
