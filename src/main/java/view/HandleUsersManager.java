/*
* This system was built as the project work
* for the IV1201 course of spring 2015 at KTH
* By group 20.
*
*/
package view;


import controller.UserHandleController;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ejb.EJB;
import java.util.List;
import java.util.Map;

/**
 * the HandleUserManager class 
 */
@RequestScoped

@ManagedBean(name = "userHandle")
public class HandleUsersManager {
    @EJB UserHandleController userHandleController;
    
    private Map<String, List<String>> alternateMap = new HashMap<>();
    private String username;
    private List<String> compList;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getCompList() {
        return compList;
    }

    public void setCompList(List<String> compList) {
        this.compList = compList;
    }

    public Map<String, List<String>> getAlternateMap() {
        return alternateMap;
    }

    public void setAlternateMap(Map<String, List<String>> alternateMap) {
        this.alternateMap = alternateMap;
    }

    public UserHandleController getUserHandleController() {
        return userHandleController;
    }

    public void setUserHandleController(UserHandleController userHandleController) {
        this.userHandleController = userHandleController;
    }

    
    @PostConstruct
    public void showAllCompetence(){
      alternateMap =  userHandleController.findAllUsersCompetenceprofile();
      for(String key : alternateMap.keySet()){
          username = key;
          setCompList(alternateMap.get(key));
          System.out.println("testt " + key);
      }
    }
}
