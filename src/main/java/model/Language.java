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
 * The language class is an entity class 
 * representing a language.
 * 
 * @author Group 20
 */
@Entity
@Table(name = "Language")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Language.findAll", query = "SELECT l FROM Language l"),
    @NamedQuery(name = "Language.findByName", query = "SELECT l FROM Language l WHERE l.name = :name"),
    @NamedQuery(name = "Language.findByLangId", query = "SELECT l FROM Language l WHERE l.langId = :langId")})
public class Language implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "lang_id")
    private long langId;
    @OneToMany(mappedBy = "langName")
    private Collection<Translate> translateCollection;

    /**
     * empty constructor
     */
    public Language() {
    }

    /**
     * 
     * @param name of the language
     */
    public Language(String name) {
        this.name = name;
    }

    /**
     * 
     * @param name of the language
     * @param langId id of the object
     */
    public Language(String name, long langId) {
        this.name = name;
        this.langId = langId;
    }

    /**
     * 
     * @return name of the language
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name name of the language
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return unique id of the language
     */
    public long getLangId() {
        return langId;
    }

    /**
     * 
     * @param langId unique id of the language
     */
    public void setLangId(long langId) {
        this.langId = langId;
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
        if (!(object instanceof Language)) {
            return false;
        }
        Language other = (Language) object;
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
        return "model.Language[ name=" + name + " ]";
    }
    
}
