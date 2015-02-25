/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import integration.CompetenceDAO;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import model.Competence;
import java.util.List;

/**
 *
 * @author syst3m
 */
@Stateful
public class AdminController {
    @EJB
    CompetenceDAO competenceDAO;
    
    public void createCompetence(String competenceName,String translateCompetenceName) throws RejectException{
        competenceDAO.createCompetence(competenceName,translateCompetenceName);
    }
    
    public boolean competenceAvailable(String competenceName){
        if(competenceDAO.getCompetence(competenceName) != null){
            return false;
        }
        return true;
    }
    
    public List<Competence> getAllAcompetence(){
        return competenceDAO.getAllCompetence();
    }
    
    public void deleteCompetence(Competence competence) throws RejectException{        
        competenceDAO.deleteCompetence(competence);
    }
}
