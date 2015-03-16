/*
* This system was built as the project work
* for the IV1201 course of spring 2015 at KTH
* By group 20.
*
*/
package controller;


import integration.UserHandleDAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * 
 * @author syst3m
 */
@Stateless
public class UserHandleController {
    @EJB 
    UserHandleDAO userhandleDAO;
    
    public Map<String, List<String>> findAllUsersCompetenceprofile(){
        Map<String, List<String>> alternateMap = new HashMap<>();
        alternateMap = userhandleDAO.findAllUsers();
        return alternateMap;
    }
    
}
