/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.PersonController;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.IOException;
import javax.faces.context.FacesContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author syst3m
 */
@RequestScoped

@ManagedBean(name = "logout")
@WebServlet(name = "logoutServlet", urlPatterns = {"/logout"})
public class LogOut extends HttpServlet {
    
 

  private static final long serialVersionUID = 1L;
  
  public void doGet() {
    FacesContext.getCurrentInstance().getExternalContext().invalidateSession();    
  }
}
