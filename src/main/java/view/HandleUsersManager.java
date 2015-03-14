/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import controller.UserHandleController;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ejb.EJB;
import java.util.List;

/**
 *
 * @author syst3m
 */
@RequestScoped

@ManagedBean(name = "userHandle")
public class HandleUsersManager {
    @EJB UserHandleController userHandleController;
    
    private String competenceProfileList;

    public UserHandleController getUserHandleController() {
        return userHandleController;
    }

    public void setUserHandleController(UserHandleController userHandleController) {
        this.userHandleController = userHandleController;
    }

    public String getCompetenceProfileList() {
        return competenceProfileList;
    }

    public void setCompetenceProfileList(String competenceProfileList) {
        this.competenceProfileList = competenceProfileList;
    }
    
    @PostConstruct
    public void showAllCompetence(){
      competenceProfileList =  userHandleController.test();
    }
}
