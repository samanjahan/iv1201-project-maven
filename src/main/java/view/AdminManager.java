/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author syst3m
 */
@RequestScoped

@ManagedBean(name = "admin")
public class AdminManager {
    @EJB AdminController adminController;
    
    private String competenceName;
    private String translateCompetenceName;
    private List<Competence> competenceList;

    public List<Competence> getCompetenceList() {
        return competenceList;
    }
    
    

    public void setCompetenceList(List<Competence> competenceList) {
        this.competenceList = competenceList;
    }

    public String getTranslateCompetenceName() {
        return translateCompetenceName;
    }

    public void setTranslateCompetenceName(String translateCompetenceName) {
        this.translateCompetenceName = translateCompetenceName;
    }

    public String getCompetenceName() {
        return competenceName;
    }

    public void setCompetenceName(String competenceName) {
        this.competenceName = competenceName;
    }
    
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
    
    public  boolean validate(){
        if(!competenceValidation(competenceName)){
          String message = "Competence already created";
          MessageFactory.getInstance().addInfoMessage(message);
            return false;            
        }
        return true;
    }
    
    public boolean competenceValidation(String competenceBane){      
            return !(!adminController.competenceAvailable(competenceBane));
    }
    
    @PostConstruct
    public void showAllCompetence(){
        competenceList = adminController.getAllAcompetence();
    }
    
    public String deleteCompetence(Competence competence) throws RejectException{
        adminController.deleteCompetence(competence);
        showAllCompetence();
        return "";
        
    }
}
