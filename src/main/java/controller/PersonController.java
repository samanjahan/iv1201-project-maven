/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import integration.RegisterDAO;
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
        }else{
            RegisterDAO registerDao =new RegisterDAO();
            registerDao.register(name, surname, ssn, email, password, username);
        }
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

}
