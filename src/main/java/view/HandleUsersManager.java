/*
* This system was built as the project work
* for the IV1201 course of spring 2015 at KTH
* By group 20.
*
*/
package view;
import java.io.FileOutputStream;
import java.io.IOException;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import controller.UserHandleController;
import integration.AvailabilityDAO;
import integration.CompetenceProfileDAO;
import integration.RegisterDAO;

import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ejb.EJB;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import model.Availability;
import model.Person;

/**
 * the HandleUserManager class 
 */
@RequestScoped

@ManagedBean(name = "userHandle")
public class HandleUsersManager {
    @EJB UserHandleController userHandleController;
    @EJB RegisterDAO registerDAO;
    @EJB CompetenceProfileDAO competenceProfileDAO;
    @EJB AvailabilityDAO availabilityDAO;
    
    private Map<String, List<String>> alternateMap = new HashMap<>();
    private String username;
    private List<String> compList;
    private String test = "test";

    public String getUsername() {
        return username;
    }
    
   public String getTest() {
        return test;
    }
   public void setTest(String test) {
        this.test = test;
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
    
    public void pdfGen(String name)throws DocumentException, IOException{
        
        Person user = registerDAO.findPerson(name);
        Availability availability = availabilityDAO.getAvailability(name);
        
        String filename = "../docroot/"+name+".pdf";        
        Document document = new Document();        
        PdfWriter.getInstance(document, new FileOutputStream(filename));        
        document.open();            
        document.add(new Paragraph("Applicant: "+ user.getName()+" "+user.getSurname()));   
        document.add(new Paragraph("SSN: "+ user.getSsn()));          
        document.add(new Paragraph("Email: "+ user.getEmail())); 
          
        document.add(new Paragraph("competences: ")); 
        for(int i=0; i<alternateMap.get(name).size(); i++){
            document.add(new Paragraph(alternateMap.get(name).get(i))); 
        }
         
        document.add(new Paragraph("Available from: "+ availability.getFromDate()));    
        document.add(new Paragraph("Available to: "+ availability.getToDate()));        
        document.close();
        FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/"+name+".pdf");
    }
    
    @PostConstruct
    public void showAllCompetence(){
      alternateMap =  userHandleController.findAllUsersCompetenceprofile();
      for(String key : alternateMap.keySet()){
          username = key;
          setCompList(alternateMap.get(key));
      }
    }
    
}
