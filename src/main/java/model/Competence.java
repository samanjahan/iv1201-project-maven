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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The Competence class is an entity class 
 * representing a Competence option.
 * 
 * @author Group 20
 */
@Entity
@Table(name = "competence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Competence.findAll", query = "SELECT c FROM Competence c"),
    @NamedQuery(name = "Competence.findByName", query = "SELECT c FROM Competence c WHERE c.name = :name"),
    @NamedQuery(name = "Competence.findByCompetenceId", query = "SELECT c FROM Competence c WHERE c.competenceId = :competenceId")})
public class Competence implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "competence_id")
    private long competenceId;
    @OneToMany(mappedBy = "competenceName")
    private Collection<Translate> translateCollection;
    @OneToMany(mappedBy = "competenceId")
    private Collection<CompetenceProfile> competenceProfileCollection;

    /**
     * Empty constructor
     */
    public Competence() {
    }

    /**
     * 
     * @param name of the competence.
     */
    public Competence(String name) {
        this.name = name;
    }

    /**
     * 
     * @param name of the competence
     * @param competenceId unique id of the competence
     */
    public Competence(String name, long competenceId) {
        this.name = name;
        this.competenceId = competenceId;
    }

    /**
     * 
     * @return name of the competence object
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name of the competence object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return the ID of the competence object
     */
    public long getCompetenceId() {
        return competenceId;
    }

    /**
     * 
     * @param competenceId the ID of the competence object
     */
    public void setCompetenceId(long competenceId) {
        this.competenceId = competenceId;
    }

    /**
     * 
     * @return list of translations
     */
    @XmlTransient
    public Collection<Translate> getTranslateCollection() {
        return translateCollection;
    }

    /**
     * 
     * @param translateCollection list of translations
     */
    public void setTranslateCollection(Collection<Translate> translateCollection) {
        this.translateCollection = translateCollection;
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
     * @return hashcode of the object
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
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
        if (!(object instanceof Competence)) {
            return false;
        }
        Competence other = (Competence) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    /**
     * 
     * @return string containing name of object
     */
    @Override
    public String toString() {
        return "model.Competence[ name=" + name + " ]";
    }
    
}
