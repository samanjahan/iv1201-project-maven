/*
* This system was built as the project work
* for the IV1201 course of spring 2015 at KTH
* By group 20.
*
*/

package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The person class is an entity class 
 * representing a person
 * 
 * @author Group 20
 */
@Entity
@Table(name = "person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByUsername", query = "SELECT p FROM Person p WHERE p.username = :username"),
    @NamedQuery(name = "Person.findByEmail", query = "SELECT p FROM Person p WHERE p.email = :email"),
    @NamedQuery(name = "Person.findByName", query = "SELECT p FROM Person p WHERE p.name = :name"),
    @NamedQuery(name = "Person.findByPassword", query = "SELECT p FROM Person p WHERE p.password = :password"),
    @NamedQuery(name = "Person.findBySsn", query = "SELECT p FROM Person p WHERE p.ssn = :ssn"),
    @NamedQuery(name = "Person.findBySurname", query = "SELECT p FROM Person p WHERE p.surname = :surname")})
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "username")
    private String username;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @Size(max = 255)
    @Column(name = "ssn")
    private String ssn;
    @Size(max = 255)
    @Column(name = "surname")
    private String surname;
    @ManyToMany(mappedBy = "personCollection")
    private Collection<Role> roleCollection;
    @OneToMany(mappedBy = "userName")
    private Collection<CompetenceProfile> competenceProfileCollection;
    @OneToMany(mappedBy = "username")
    private Collection<Availability> availabilityCollection;

    /**
     * empty constructor
     */
    public Person() {
    }

    /**
     * 
     * @param username username of person
     */
    public Person(String username) {
        this.username = username;
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
     * @return password of persons account
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password password of persons account
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return ssn number of person
     */
    public String getSsn() {
        return ssn;
    }

    /**
     *
     * @param ssn ssn number of person
     */
    public void setSsn(String ssn) {
        this.ssn = ssn;
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
     * @return list of roles
     */
    @XmlTransient
    public Collection<Role> getRoleCollection() {
        return roleCollection;
    }

    /**
     *
     * @param roleCollection list of roles
     */
    public void setRoleCollection(Collection<Role> roleCollection) {
        this.roleCollection = roleCollection;
    }

    /**
     * 
     * @return list of competenceProfiles
     */
    @XmlTransient
    public Collection<CompetenceProfile> getCompetenceProfileCollection() {
        return competenceProfileCollection;
    }

    /**
     *
     * @param competenceProfileCollection list of competenceProfiles
     */
    public void setCompetenceProfileCollection(Collection<CompetenceProfile> competenceProfileCollection) {
        this.competenceProfileCollection = competenceProfileCollection;
    }

    /**
     *
     * @return list of availability 
     */
    @XmlTransient
    public Collection<Availability> getAvailabilityCollection() {
        return availabilityCollection;
    }

    /**
     *
     * @param availabilityCollection list of availability
     */
    public void setAvailabilityCollection(Collection<Availability> availabilityCollection) {
        this.availabilityCollection = availabilityCollection;
    }

    /**
     * 
     * @return hashcode of object
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

     /**
     * compares this object to the parameter
     * to see if they are equal
     * 
     * @param object
     * @return boolean depending of the result of comparison
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    
    /**
     * 
     * @return string containing username of object
     */
    @Override
    public String toString() {
        return "model.Person[ username=" + username + " ]";
    }
    
}
