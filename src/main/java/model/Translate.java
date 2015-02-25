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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @OneToMany(mappedBy = "translateName")
    private Collection<CompetenceProfile> competenceProfileCollection;

    public Translate() {
    }

    public Translate(String name) {
        this.name = name;
    }

    public Translate(String name, int translateId) {
        this.name = name;
        this.translateId = translateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTranslateId() {
        return translateId;
    }

    public void setTranslateId(int translateId) {
        this.translateId = translateId;
    }

    public Language getLangName() {
        return langName;
    }

    public void setLangName(Language langName) {
        this.langName = langName;
    }

    public Competence getCompetenceName() {
        return competenceName;
    }

    public void setCompetenceName(Competence competenceName) {
        this.competenceName = competenceName;
    }

    @XmlTransient
    public Collection<CompetenceProfile> getCompetenceProfileCollection() {
        return competenceProfileCollection;
    }

    public void setCompetenceProfileCollection(Collection<CompetenceProfile> competenceProfileCollection) {
        this.competenceProfileCollection = competenceProfileCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

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

    @Override
    public String toString() {
        return "model.Translate[ name=" + name + " ]";
    }
    
}
