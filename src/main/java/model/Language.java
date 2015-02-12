/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author syst3m
 */
@Entity
@Table(name = "Language")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Language.findAll", query = "SELECT l FROM Language l"),
    @NamedQuery(name = "Language.findByLangId", query = "SELECT l FROM Language l WHERE l.langId = :langId"),
    @NamedQuery(name = "Language.findByName", query = "SELECT l FROM Language l WHERE l.name = :name")})
public class Language implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "lang_id")
    private Long langId;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "langIg")
    private Collection<Translate> translateCollection;

    public Language() {
    }

    public Language(Long langId) {
        this.langId = langId;
    }

    public Long getLangId() {
        return langId;
    }

    public void setLangId(Long langId) {
        this.langId = langId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Translate> getTranslateCollection() {
        return translateCollection;
    }

    public void setTranslateCollection(Collection<Translate> translateCollection) {
        this.translateCollection = translateCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (langId != null ? langId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Language)) {
            return false;
        }
        Language other = (Language) object;
        if ((this.langId == null && other.langId != null) || (this.langId != null && !this.langId.equals(other.langId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Language[ langId=" + langId + " ]";
    }
    
}
