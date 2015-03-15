/*
* This system was built as the project work
* for the IV1201 course of spring 2015 at KTH
* By group 20.
*
*/
package view;


import controller.UserHandleController;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ejb.EJB;
import java.util.List;

/**
 * the HandleUserManager class 
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
