/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import controller.RejectException;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.Language;
import model.Translate;
import java.util.List;
import model.Competence;
import model.CompetenceProfile;


/**
 *
 * @author syst3m
 */
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class CompetenceDAO {
    @PersistenceContext(unitName = "mavenprojectiv1201")
    private EntityManager em;
    
    public void createCompetence(String competenceName, String translateCompetenceName) throws RejectException{
        
        if(getCompetence(competenceName) != null){
            throw new RejectException("Competence has alredy created");
        }
        
        Competence competence = new Competence();
        competence.setName(competenceName);
        em.persist(competence);
       
        Translate trasnlate = new Translate();
        trasnlate.setName(translateCompetenceName);
        trasnlate.setCompetenceName(competence);
        Language language = em.find(Language.class, "sw");
        trasnlate.setLangName(language);
        em.persist(trasnlate);
        
    }
    
    public Competence getCompetence(String competenceName){
        Competence competence = em.find(Competence.class, competenceName);
        return competence;
    }
    
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    public List<Competence> getAllCompetence(){
        TypedQuery<Competence> competencequesrList = em.createNamedQuery("Competence.findAll",Competence.class);
        List<Competence> competenceList = competencequesrList.getResultList();
        return competenceList;
    }
    
    public void deleteCompetence(Competence competence) throws RejectException{
        String competenceName = competence.getName();
        Translate translate = findTranslate(competenceName);
        deleteCompetenceProfile(competence);
        if(translate == null){
            throw new RejectException("Competence not found");
        }
        em.remove(translate);
        Competence deleteCompetence = getCompetence(competenceName);
        em.remove(deleteCompetence);
        
    }
    
    private Translate findTranslate(String competenceName){
        TypedQuery<Translate> transleQueryList = em.createNamedQuery("Translate.findAll",Translate.class);
        List<Translate> translateList = transleQueryList.getResultList();
        Translate translate = null;
        for(int i = 0 ; i < translateList.size(); ++i){
            if(translateList.get(i).getCompetenceName().getName().equals(competenceName)){
                translate = translateList.get(i);
            }
        }
        return translate;
    }
    
    public Competence findCompetence(String competenceName){
        Competence competence = em.find(Competence.class, competenceName);
        return competence;
    }
    
    public void deleteCompetenceProfile(Competence competence){
        TypedQuery<CompetenceProfile> comProfileQueryList = em.createNamedQuery("CompetenceProfile.findAll",CompetenceProfile.class);
        List<CompetenceProfile> listOfCompetenceProfile = comProfileQueryList.getResultList();
        for(int i = 0 ; i < listOfCompetenceProfile.size(); ++i){
            if(listOfCompetenceProfile.get(i).getCompetenceId().getName().equals(competence.getName())){
                em.remove(listOfCompetenceProfile.get(i));
            }
        }
    }
    
    
}
