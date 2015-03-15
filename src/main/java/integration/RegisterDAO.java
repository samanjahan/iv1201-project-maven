/*
* This system was built as the project work
* for the IV1201 course of spring 2015 at KTH
* By group 20.
*
*/
package integration;

import controller.RejectException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Person;
import model.Role;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * The registerDAO class handles all database
 * transactions concerning the registration of 
 * a new user by using the entity manager.
 * 
 * @author Group 20
 * 
 */
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class RegisterDAO {
    @PersistenceContext(unitName = "mavenprojectiv1201")
    private EntityManager em;
    private boolean test = false;
    
        
     /**
     * Creates and adds a new user to the database with 
     * the given parameters as values
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

        
        if (!usernameAvailable(username)) {
            throw new RejectException("Username is already taken.");
        }
        Role role = findRole("applicant");
        
        if (role == null && !test) {
            throw new RejectException("Role dose not found");
        }
        Person person;
        person = populatePersonObject(name, surname, ssn, email, password, username);
    
   
        em.persist(person);
        
        role.addPerson(person);
        
    }
    
     /**
     * 
     * Encrypts a given String
     *
     * @param password
     * @return returns the encrypted string
     * @throws NoSuchAlgorithmException
     */
    private String getEncryptedPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
    
    /**
     * Creates a person object and sets its values to the given input parameters
     *
     * @param name
     * @param surname 
    * @param ss
     * @param email
     * @param password
     * @param username
     * @return returns a person object with values matching the input parameters
     * @throws RejectException
     */
    private Person populatePersonObject(String name, String surname, String ss, String email, String password, String username) throws RejectException {
      

        Person person = new Person();
        person.setName(name);
        person.setSsn(ss);
        person.setSurname(surname);
        person.setUsername(username);
        person.setEmail(email);
        

        try {
            person.setPassword(getEncryptedPassword(password));
        } catch (NoSuchAlgorithmException e) {
            throw new RejectException("Server fatal error:SHA-256 algorithm not found");
        } catch (UnsupportedOperationException e) {
            throw new RejectException("Server fatal error:UTF-8 encoding is not supported on server");
        }
        return person;
    }

    /**
     * *
     * Finds a and returns a person with the given username
     *
     * @param username
     * @return returns a person object with a given username
     */
    public Person findPerson(String username) {
        Person person = em.find(Person.class, username);
        return person;
    }

    /**
     * *
     * Finds a and returns a role with the given username
     *
     * @param userRole
     * @return returns a String object with a given role
     */
    public Role findRole(String userRole) {
        Role role = em.find(Role.class, userRole);
        return role;

    }

    /**
     * Checks if a username already exists using the findPerson method
     *
     * @param username
     * @return returns true if input is not yet taken
     */
    public boolean usernameAvailable(String username) {
        Person person = findPerson(username);
        if (person != null) {
            return false;
        }
        return true;
    }

    /**
     * 
     * @param em Entity manager object
     */
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    /**
     * 
     * @param test boolean deciding whether to run in test mode or not
     */
    public void setTest(boolean test){
        this.test = test;
    }
    
    /**
     * returns a list of all the already existing
     * users in the database.
     *         
     * @return list of all existing users
     */
    public List<Person> getAllUser(){
        TypedQuery<Person> personequesrList = em.createNamedQuery("Person.findAll",Person.class);
        List<Person> personList = personequesrList.getResultList();
        return personList;
    }
    
}
