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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author syst3m
 */
@Entity
@Table(name = "competence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Competence.findAll", query = "SELECT c FROM Competence c"),
    @NamedQuery(name = "Competence.findByCompetenceId", query = "SELECT c FROM Competence c WHERE c.competenceId = :competenceId"),
    @NamedQuery(name = "Competence.findByName", query = "SELECT c FROM Competence c WHERE c.name = :name")})
public class Competence implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "competence_id")
    private Long competenceId;
    @Size(max = 255)
    @Column(name = "name")
    private String name;

    public Competence() {
    }

    public Competence(Long competenceId) {
        this.competenceId = competenceId;
    }

    public Long getCompetenceId() {
        return competenceId;
    }

    public void setCompetenceId(Long competenceId) {
        this.competenceId = competenceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (competenceId != null ? competenceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competence)) {
            return false;
        }
        Competence other = (Competence) object;
        if ((this.competenceId == null && other.competenceId != null) || (this.competenceId != null && !this.competenceId.equals(other.competenceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Competence[ competenceId=" + competenceId + " ]";
    }
    
}
