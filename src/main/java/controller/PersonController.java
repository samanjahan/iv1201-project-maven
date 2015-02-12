/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Person;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import model.Groups;
import model.Role;

/**
 *
 * @author syst3m
 */
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class PersonController {

    @PersistenceContext(unitName = "mavenprojectiv1201")
    private EntityManager em, emGroups, emRole;

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

        if (!usernameAvailable(username)) {
            throw new RejectException("Username is already taken.");
        }
        Person person;
        person = populatePersonObject(name, surname, ssn, email, password, username);
        Role role = findRole("applicant");
        if (role == null) {
            throw new RejectException("Role dose not found");
        }
        em.persist(person);
        createGroup(username, role);
    }

    /**
     * *
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

        Person person;
        person = new Person();
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
        Role role = emRole.find(Role.class, userRole);
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

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    public void setRoleEntityManager(EntityManager emRole) {
        this.emRole = emRole;
    }
    
    /**
     * Creates a group object and persist it
     *
     * @param username
     * @param role
     */
    private void createGroup(String username, Role role) {
        Groups groups = new Groups();
        Person person = findPerson(username);
        groups.setGroupname(role);
        groups.setUsername(person);
        emGroups.persist(groups);
    }
}
