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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.*;


/**
 * The role class is an entity class 
 * representing a role
 * 
 * @author Group 20
 */
@Entity
@Table(name = "role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
    @NamedQuery(name = "Role.findByRoleName", query = "SELECT r FROM Role r WHERE r.roleName = :roleName")})
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "roleName")
    private String roleName;
    @JoinTable(name = "groups", joinColumns = {
        @JoinColumn(name = "groupname", referencedColumnName = "roleName")}, inverseJoinColumns = {
        @JoinColumn(name = "username", referencedColumnName = "username")})
    @ManyToMany
    private Collection<Person> personCollection;

    /**
     * Constructor
     */
    public Role() {
        personCollection = new ArrayList<Person>();
    }

    /**
     *
     * @param roleName name of role
     */
    public Role(String roleName) {
        this.roleName = roleName;
    }

    /**
     *
     * @return name of role
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     *
     * @param roleName name of role
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    /**
     * adds the person from the input parameter
     * to the collection of persons
     * 
     * @param person 
     */
    public  void addPerson(Person person){
        personCollection.add(person);
        
    }

    /**
     *
     * @return list of persons
     */
    @XmlTransient
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    /**
     *
     * @param personCollection list of persons
     */
    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    /**
     * 
     * @return hashcode of object
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleName != null ? roleName.hashCode() : 0);
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
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.roleName == null && other.roleName != null) || (this.roleName != null && !this.roleName.equals(other.roleName))) {
            return false;
        }
        return true;
    }
    
    /**
     * 
     * @return string containing rolename of object
     */
    @Override
    public String toString() {
        return "model.Role[ roleName=" + roleName + " ]";
    }
    
}
