/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbAccess;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import dbAccess.Paciente;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author Punkid PC
 */
@Entity
@Table(name = "historiaclinica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historiaclinica.findAll", query = "SELECT h FROM Historiaclinica h")
    , @NamedQuery(name = "Historiaclinica.findByIdHistoriaClinica", query = "SELECT h FROM Historiaclinica h WHERE h.idHistoriaClinica = :idHistoriaClinica")})
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "idHistoriaClinica")
public class Historiaclinica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHistoriaClinica")
    private Integer idHistoriaClinica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "historiaClinicaidHistoriaClinica")
    private Collection<Toxicomanias> toxicomaniasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "historiaClinicaidHistoriaClinica")
    private Collection<Cirugias> cirugiasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "historiaClinicaidHistoriaClinica")
    private Collection<Paciente> pacienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "historiaClinicaidHistoriaClinica")
    private Collection<Antecedentes> antecedentesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "historiaClinicaidHistoriaClinica")
    private Collection<Hospitalizacion> hospitalizacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "historiaClinicaidHistoriaClinica")
    private Collection<Enfermedades> enfermedadesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "historiaClinicaidHistoriaClinica")
    private Collection<Vacunas> vacunasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "historiaClinicaidHistoriaClinica")
    private Collection<Alergias> alergiasCollection;
    @JoinColumn(name = "InformacionPersonal_idInformacionPersonal", referencedColumnName = "idInformacionPersonal")
    @ManyToOne(optional = false)
    private Informacionpersonal informacionPersonalidInformacionPersonal;

    public Historiaclinica() {
    }

    public Historiaclinica(Integer idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }

    public Integer getIdHistoriaClinica() {
        return idHistoriaClinica;
    }

    public void setIdHistoriaClinica(Integer idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }

    @XmlTransient
    public Collection<Toxicomanias> getToxicomaniasCollection() {
        return toxicomaniasCollection;
    }

    public void setToxicomaniasCollection(Collection<Toxicomanias> toxicomaniasCollection) {
        this.toxicomaniasCollection = toxicomaniasCollection;
    }

    @XmlTransient
    public Collection<Cirugias> getCirugiasCollection() {
        return cirugiasCollection;
    }

    public void setCirugiasCollection(Collection<Cirugias> cirugiasCollection) {
        this.cirugiasCollection = cirugiasCollection;
    }

    @XmlTransient
    public Collection<Paciente> getPacienteCollection() {
        return pacienteCollection;
    }

    public void setPacienteCollection(Collection<Paciente> pacienteCollection) {
        this.pacienteCollection = pacienteCollection;
    }

    @XmlTransient
    public Collection<Antecedentes> getAntecedentesCollection() {
        return antecedentesCollection;
    }

    public void setAntecedentesCollection(Collection<Antecedentes> antecedentesCollection) {
        this.antecedentesCollection = antecedentesCollection;
    }

    @XmlTransient
    public Collection<Hospitalizacion> getHospitalizacionCollection() {
        return hospitalizacionCollection;
    }

    public void setHospitalizacionCollection(Collection<Hospitalizacion> hospitalizacionCollection) {
        this.hospitalizacionCollection = hospitalizacionCollection;
    }

    @XmlTransient
    public Collection<Enfermedades> getEnfermedadesCollection() {
        return enfermedadesCollection;
    }

    public void setEnfermedadesCollection(Collection<Enfermedades> enfermedadesCollection) {
        this.enfermedadesCollection = enfermedadesCollection;
    }

    @XmlTransient
    public Collection<Vacunas> getVacunasCollection() {
        return vacunasCollection;
    }

    public void setVacunasCollection(Collection<Vacunas> vacunasCollection) {
        this.vacunasCollection = vacunasCollection;
    }

    @XmlTransient
    public Collection<Alergias> getAlergiasCollection() {
        return alergiasCollection;
    }

    public void setAlergiasCollection(Collection<Alergias> alergiasCollection) {
        this.alergiasCollection = alergiasCollection;
    }

    public Informacionpersonal getInformacionPersonalidInformacionPersonal() {
        return informacionPersonalidInformacionPersonal;
    }

    public void setInformacionPersonalidInformacionPersonal(Informacionpersonal informacionPersonalidInformacionPersonal) {
        this.informacionPersonalidInformacionPersonal = informacionPersonalidInformacionPersonal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistoriaClinica != null ? idHistoriaClinica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historiaclinica)) {
            return false;
        }
        Historiaclinica other = (Historiaclinica) object;
        if ((this.idHistoriaClinica == null && other.idHistoriaClinica != null) || (this.idHistoriaClinica != null && !this.idHistoriaClinica.equals(other.idHistoriaClinica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataHolders.Historiaclinica[ idHistoriaClinica=" + idHistoriaClinica + " ]";
    }
    
}
