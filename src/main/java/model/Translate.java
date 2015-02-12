/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    @Column(name = "translate_id")
    private Integer translateId;
    @JoinColumn(name = "lang_ig", referencedColumnName = "lang_id")
    @ManyToOne
    private Language langIg;
    @JoinColumn(name = "comp_id", referencedColumnName = "competence_profile_id")
    @ManyToOne
    private CompetenceProfile compId;

    public Translate() {
    }

    public Translate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTranslateId() {
        return translateId;
    }

    public void setTranslateId(Integer translateId) {
        this.translateId = translateId;
    }

    public Language getLangIg() {
        return langIg;
    }

    public void setLangIg(Language langIg) {
        this.langIg = langIg;
    }

    public CompetenceProfile getCompId() {
        return compId;
    }

    public void setCompId(CompetenceProfile compId) {
        this.compId = compId;
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
