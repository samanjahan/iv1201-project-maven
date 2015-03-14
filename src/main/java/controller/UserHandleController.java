/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
