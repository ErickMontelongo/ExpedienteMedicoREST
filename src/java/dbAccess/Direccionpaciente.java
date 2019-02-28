/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbAccess;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author Punkid PC
 */
@Entity
@Table(name = "direccionpaciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direccionpaciente.findAll", query = "SELECT d FROM Direccionpaciente d")
    , @NamedQuery(name = "Direccionpaciente.findByIdDireccionPaciente", query = "SELECT d FROM Direccionpaciente d WHERE d.idDireccionPaciente = :idDireccionPaciente")
    , @NamedQuery(name = "Direccionpaciente.findByEstado", query = "SELECT d FROM Direccionpaciente d WHERE d.estado = :estado")
    , @NamedQuery(name = "Direccionpaciente.findByMunicipio", query = "SELECT d FROM Direccionpaciente d WHERE d.municipio = :municipio")
    , @NamedQuery(name = "Direccionpaciente.findByCalle", query = "SELECT d FROM Direccionpaciente d WHERE d.calle = :calle")
    , @NamedQuery(name = "Direccionpaciente.findByColonia", query = "SELECT d FROM Direccionpaciente d WHERE d.colonia = :colonia")
    , @NamedQuery(name = "Direccionpaciente.findByNumeroTel", query = "SELECT d FROM Direccionpaciente d WHERE d.numeroTel = :numeroTel")
    , @NamedQuery(name = "Direccionpaciente.findByCodigoPostal", query = "SELECT d FROM Direccionpaciente d WHERE d.codigoPostal = :codigoPostal")})
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "idDireccionPaciente")
public class Direccionpaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDireccionPaciente")
    private Integer idDireccionPaciente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "municipio")
    private String municipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "calle")
    private String calle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "colonia")
    private String colonia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "numeroTel")
    private String numeroTel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigoPostal")
    private String codigoPostal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "direccionPacienteidDireccionPaciente")
    //@JsonIgnore
    private Collection<Paciente> pacienteCollection;

    public Direccionpaciente() {
    }

    public Direccionpaciente(Integer idDireccionPaciente) {
        this.idDireccionPaciente = idDireccionPaciente;
    }

    public Direccionpaciente(Integer idDireccionPaciente, String estado, String municipio, String calle, String colonia, String numeroTel, String codigoPostal) {
        this.idDireccionPaciente = idDireccionPaciente;
        this.estado = estado;
        this.municipio = municipio;
        this.calle = calle;
        this.colonia = colonia;
        this.numeroTel = numeroTel;
        this.codigoPostal = codigoPostal;
    }

    public Integer getIdDireccionPaciente() {
        return idDireccionPaciente;
    }

    public void setIdDireccionPaciente(Integer idDireccionPaciente) {
        this.idDireccionPaciente = idDireccionPaciente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @XmlTransient
    public Collection<Paciente> getPacienteCollection() {
        return pacienteCollection;
    }

    public void setPacienteCollection(Collection<Paciente> pacienteCollection) {
        this.pacienteCollection = pacienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccionPaciente != null ? idDireccionPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccionpaciente)) {
            return false;
        }
        Direccionpaciente other = (Direccionpaciente) object;
        if ((this.idDireccionPaciente == null && other.idDireccionPaciente != null) || (this.idDireccionPaciente != null && !this.idDireccionPaciente.equals(other.idDireccionPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.Direccionpaciente[ idDireccionPaciente=" + idDireccionPaciente + " ]";
    }
    
}
