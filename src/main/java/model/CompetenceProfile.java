/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author syst3m
 */
@Entity
@Table(name = "competence_profile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompetenceProfile.findAll", query = "SELECT c FROM CompetenceProfile c"),
    @NamedQuery(name = "CompetenceProfile.findByCompetenceProfileId", query = "SELECT c FROM CompetenceProfile c WHERE c.competenceProfileId = :competenceProfileId"),
    @NamedQuery(name = "CompetenceProfile.findByCompetenceId", query = "SELECT c FROM CompetenceProfile c WHERE c.competenceId = :competenceId"),
    @NamedQuery(name = "CompetenceProfile.findByYearsOfExperience", query = "SELECT c FROM CompetenceProfile c WHERE c.yearsOfExperience = :yearsOfExperience")})
public class CompetenceProfile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "competence_profile_id")
    private Long competenceProfileId;
    @Column(name = "competence_id")
    private BigInteger competenceId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "years_of_experience")
    private Double yearsOfExperience;
    @OneToMany(mappedBy = "compId")
    private Collection<Translate> translateCollection;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne
    private Person username;
    @JoinColumn(name = "comp_id", referencedColumnName = "competence_id")
    @ManyToOne
    private Competence compId;

    public CompetenceProfile() {
    }

    public CompetenceProfile(Long competenceProfileId) {
        this.competenceProfileId = competenceProfileId;
    }

    public Long getCompetenceProfileId() {
        return competenceProfileId;
    }

    public void setCompetenceProfileId(Long competenceProfileId) {
        this.competenceProfileId = competenceProfileId;
    }

    public BigInteger getCompetenceId() {
        return competenceId;
    }

    public void setCompetenceId(BigInteger competenceId) {
        this.competenceId = competenceId;
    }

    public Double getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Double yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @XmlTransient
    public Collection<Translate> getTranslateCollection() {
        return translateCollection;
    }

    public void setTranslateCollection(Collection<Translate> translateCollection) {
        this.translateCollection = translateCollection;
    }

    public Person getUsername() {
        return username;
    }

    public void setUsername(Person username) {
        this.username = username;
    }

    public Competence getCompId() {
        return compId;
    }

    public void setCompId(Competence compId) {
        this.compId = compId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (competenceProfileId != null ? competenceProfileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompetenceProfile)) {
            return false;
        }
        CompetenceProfile other = (CompetenceProfile) object;
        if ((this.competenceProfileId == null && other.competenceProfileId != null) || (this.competenceProfileId != null && !this.competenceProfileId.equals(other.competenceProfileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CompetenceProfile[ competenceProfileId=" + competenceProfileId + " ]";
    }
    
}
