/*
* This system was built as the project work
* for the IV1201 course of spring 2015 at KTH
* By group 20.
*
*/
package view;

import controller.PersonController;
import controller.RejectException;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * The RegistrationManager class is a view class
 * handling the registration of a new user at the view level.
 */
@RequestScoped

@ManagedBean(name = "registration")
public class RegistrationManager {
    private Exception exception;
    private String name;
    private String surname;
    private String ssn;
    private String email;
    private String username;
    private String password;
    private String message;
    private boolean testing;
    
    /**
     *
     * @return exception
     */
    public  Exception getException(){
        return exception;
    }
    
    /**
     * determines whether to run class in test mode or not
     * @param testing 
     */
    public void setTest(boolean testing){
        this.testing = testing;
    }

    /**
     * 
     * @return name of person
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name name of person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return surname of person
     */
    public String getSurname() {
        return surname;
    }

    /**
     *
     * @param surname surname of person
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     *
     * @return ssn of person
     */
    public String getSsn() {
        return ssn;
    }

    /**
     *
     * @param ssn ssn of person
     */
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    /**
     *
     * @return email address of person
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email email address of person
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return username of person
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username username of person
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return password of person
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password password of person
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param personController controller handling the person entities
     */
    public void setPersonController(PersonController personController){
        this.personController = personController;
    }
    
    /**
     *
     * @param message notification message shown to the user 
     */
    public void setMessage(String message){
        this.message = message;
    }
    
    /**
     *
     * @return notification message shown to the user 
     */
    public String getMessage(){
        return message;
    }
    
    @EJB PersonController personController;
    
    /**
     * Calls the personController in order to register a new account 
     * creates appropriate message using the MessageFactory
     * returns an empty string in order to refresh the page
     * 
     * @return 
     * @throws RejectException 
     */
    public String register() throws RejectException{
      
        if(!validate()){
            return "";
        }        
       try{
        personController.register(name, surname, ssn, email, password, username);
        message = "Registraion was successfull!";
        if(!testing)
            MessageFactory.getInstance().addInfoMessage(message);
       }catch(Exception e){
            MessageFactory.getInstance().addErrorMessage(e.getMessage());
       }
        return "";
    }
    
    /****
     * calls the functions nameValidation, ssnValidation, emailValidation
     * and UsernameValidation in order to validate entered data
     * 
     * @return returns a boolean according to how the validation went
     */
    public boolean validate(){       
        if(!nameValidation(name)){
            message = "Name may only contain letters.";
            MessageFactory.getInstance().addInfoMessage(message);
            return false;
        }        
        if(!nameValidation(surname)){
            message = "Lastname may only contain letters.";
            MessageFactory.getInstance().addInfoMessage(message);
            return false;
        }
        if(!ssnValidation(ssn)){
           message = "SSN is to be entered in the following format XXXXXXX-XXXX";
           MessageFactory.getInstance().addInfoMessage(message);
           return false;
        }
        if(!emailValidation(email)){
          message = "A real Email Adress required.";
          MessageFactory.getInstance().addInfoMessage(message);
          return false;
        }
        if(!usernameValidation(username)){
          message = "Username already taken";
          MessageFactory.getInstance().addInfoMessage(message);
            return false;            
        }
        return true;
    }
    
    /****
     * validates the entered parameter using regex
     * 
     * @param name
     * @return returns a boolean depending on the result of validation
     */
    public boolean nameValidation(String name){
        return !(!name.matches( "[A-ZÅÄÖa-zåäö]*" ) || name.equals(""));
    }
     
    /****
     * validates the entered parameter using regex
     * 
     * @param ssn
     * @return returns a boolean depending on the result of validation
     */
    public boolean ssnValidation(String ssn){
        return ssn.matches("([0-9]{6,6})[-]([0-9]{4,4})");
    }
     
    /****
     * validates the entered parameter using regex
     * 
     * @param email
     * @return returns a boolean depending on the result of validation
     */
    public boolean emailValidation(String email){
        return email.matches("([a-zA-Z1-9\\.\\-\\_]+)[@]([a-zA-Z1-9.]+)");
    }
     
    /****
     * validates the entered parameter username by making sure its available
     * 
     * @param username
     * @return returns a boolean depending on the result of validation
     */
    public boolean usernameValidation(String username){
       
        return !(!personController.usernameAvailable(username)||username.equals(""));
    }
    
     
    /****
     * Not yet implemented
     * @param password
     * @return 
     */
    public boolean passwordValidation(String password){
        return true;
    }
}
