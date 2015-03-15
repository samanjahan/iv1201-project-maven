/*
* This system was built as the project work
* for the IV1201 course of spring 2015 at KTH
* By group 20.
*
*/
package controller;


import integration.UserHandleDAO;
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
    
    public String test(){
        userhandleDAO.findAllUsers();
        return "ok";
    }
    
}
