/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author syst3m
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

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        if(experience.isEmpty()){
            this.experienceList.add("0");
        }else{
            this.experienceList.add(experience);
        }
        
        
    }

    public List<String> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(String experience) {
        System.out.println("SetStrings " + experience);
    //    this.strings.add(strings);
    }
      

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public PersonController getPersonController() {
        return personController;
    }

    public void setPersonController(PersonController personController) {
        this.personController = personController;
    }

    public Map<String, Boolean> getChecked() {
        return checked;
    }

    public void setChecked(Map<String, Boolean> checked) {
        this.checked = checked;
    }

    public List<Comparable> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(List<Comparable> selectedItems) {
        this.selectedItems = selectedItems;
    }

    public List<Competence> getCompetenceList() {
        return competenceList;
    }

    public void setCompetenceList(List<Competence> competenceList) {
        this.competenceList = competenceList;
    }
      
    @PostConstruct
    public void showAllCompetence(){
        competenceList = adminController.getAllAcompetence();
    }
    
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
