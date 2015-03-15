/*
* This system was built as the project work
* for the IV1201 course of spring 2015 at KTH
* By group 20.
*
*/
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The translate class is an entity class 
 * representing a translation of a competence
 * 
 * @author Group 20
 */
@Entity
@Table(name = "Translate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Translate.findAll", query = "SELECT t FROM Translate t"),
    @NamedQuery(name = "Translate.findByName", query = "SELECT t FROM Translate t WHERE t.name = :name"),
    @NamedQuery(name = "Translate.findByTranslateId", query = "SELECT t FROM Translate t WHERE t.translateId = :translateId")})
public class Translate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "translate_id")
    private int translateId;
    @JoinColumn(name = "lang_name", referencedColumnName = "name")
    @ManyToOne
    private Language langName;
    @JoinColumn(name = "competence_name", referencedColumnName = "name")
    @ManyToOne
    private Competence competenceName;

    /**
     * empty constructor
     */
    public Translate() {
    }

    /**
     *
     * @param name translation of competence
     */
    public Translate(String name) {
        this.name = name;
    }

    /**
     *
     * @param name translation of competence
     * @param translateId id of competence
     */
    public Translate(String name, int translateId) {
        this.name = name;
        this.translateId = translateId;
    }

    /**
     *
     * @return name translation of competence
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name translation of competence
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return unique id of translation
     */
    public int getTranslateId() {
        return translateId;
    }

    /**
     *
     * @param translateId unique id of translation
     */
    public void setTranslateId(int translateId) {
        this.translateId = translateId;
    }

    /**
     *
     * @return the name of the translation language
     */
    public Language getLangName() {
        return langName;
    }

    /**
     *
     * @param langName the name of the translation language
     */
    public void setLangName(Language langName) {
        this.langName = langName;
    }

    /**
     *
     * @return name of competence in original language
     */
    public Competence getCompetenceName() {
        return competenceName;
    }

    /**
     *
     * @param competenceName name of competence in original language
     */
    public void setCompetenceName(Competence competenceName) {
        this.competenceName = competenceName;
    }
    
    /**
     * 
     * @return hashcode of object
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
        if (!(object instanceof Translate)) {
            return false;
        }
        Translate other = (Translate) object;
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
        return "model.Translate[ name=" + name + " ]";
    }
    
}
