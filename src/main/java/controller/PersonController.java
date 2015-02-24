/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import integration.RegisterDAO;
import javax.ejb.EJB;
import javax.ejb.Stateful;


/**
 *
 * @author syst3m
 */
@Stateful
public class PersonController {    
    @EJB 
    RegisterDAO registerDAO;
    
        
       /**
     * Creates and adds a new user to the database with the given parameters as
     * values
     *
     * @param name
     * @param surname
     * @param ssn
     * @param email
     * @param password
     * @param username
     * @throws RejectException
     */
    public void register(String name, String surname, String ssn, String email, String password, String username) throws RejectException {

        registerDAO.register(name, surname, ssn, email, password, username);      
    }
    
    public  boolean usernameAvailable(String username){
        return registerDAO.usernameAvailable(username);
    }
    
    
    
}
