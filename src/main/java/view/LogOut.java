/*
* This system was built as the project work
* for the IV1201 course of spring 2015 at KTH
* By group 20.
*
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
 * The LogOut class implements a log out functionality
 * in to the system
 * 
 * @author Group 20
 */
@RequestScoped

@ManagedBean(name = "logout")
@WebServlet(name = "logoutServlet", urlPatterns = {"/logout"})
public class LogOut extends HttpServlet {
    
private static final long serialVersionUID = 1L;
  
  /**
   * logs the user out by invalidation the current session
   */
  public void doGet() {
    FacesContext.getCurrentInstance().getExternalContext().invalidateSession();    
  }
}
