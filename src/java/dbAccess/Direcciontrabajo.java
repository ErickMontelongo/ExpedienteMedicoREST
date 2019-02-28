/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbAccess;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "direcciontrabajo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direcciontrabajo.findAll", query = "SELECT d FROM Direcciontrabajo d")
    , @NamedQuery(name = "Direcciontrabajo.findByIdDireccionTrabajo", query = "SELECT d FROM Direcciontrabajo d WHERE d.idDireccionTrabajo = :idDireccionTrabajo")
    , @NamedQuery(name = "Direcciontrabajo.findByEstado", query = "SELECT d FROM Direcciontrabajo d WHERE d.estado = :estado")
    , @NamedQuery(name = "Direcciontrabajo.findByMunicipio", query = "SELECT d FROM Direcciontrabajo d WHERE d.municipio = :municipio")
    , @NamedQuery(name = "Direcciontrabajo.findByCalle", query = "SELECT d FROM Direcciontrabajo d WHERE d.calle = :calle")
    , @NamedQuery(name = "Direcciontrabajo.findByColonia", query = "SELECT d FROM Direcciontrabajo d WHERE d.colonia = :colonia")
    , @NamedQuery(name = "Direcciontrabajo.findByNumeroTel", query = "SELECT d FROM Direcciontrabajo d WHERE d.numeroTel = :numeroTel")
    , @NamedQuery(name = "Direcciontrabajo.findByCodigoPostal", query = "SELECT d FROM Direcciontrabajo d WHERE d.codigoPostal = :codigoPostal")
    , @NamedQuery(name = "Direcciontrabajo.findByNombreEmpresa", query = "SELECT d FROM Direcciontrabajo d WHERE d.nombreEmpresa = :nombreEmpresa")
    , @NamedQuery(name = "Direcciontrabajo.findByConsultorio", query = "SELECT d FROM Direcciontrabajo d WHERE d.consultorio = :consultorio")})
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "idDireccionTrabajo")
public class Direcciontrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDireccionTrabajo")
    private Integer idDireccionTrabajo;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombreEmpresa")
    private String nombreEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "consultorio")
    private String consultorio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "direccionTrabajoidDireccionTrabajo")
    //@JsonBackReference(value="direcciones")
    private Collection<Medico> medicoCollection;

    public Direcciontrabajo() {
    }

    public Direcciontrabajo(Integer idDireccionTrabajo) {
        this.idDireccionTrabajo = idDireccionTrabajo;
    }

    public Direcciontrabajo(Integer idDireccionTrabajo, String estado, String municipio, String calle, String colonia, String numeroTel, String codigoPostal, String nombreEmpresa, String consultorio) {
        this.idDireccionTrabajo = idDireccionTrabajo;
        this.estado = estado;
        this.municipio = municipio;
        this.calle = calle;
        this.colonia = colonia;
        this.numeroTel = numeroTel;
        this.codigoPostal = codigoPostal;
        this.nombreEmpresa = nombreEmpresa;
        this.consultorio = consultorio;
    }

    public Integer getIdDireccionTrabajo() {
        return idDireccionTrabajo;
    }

    public void setIdDireccionTrabajo(Integer idDireccionTrabajo) {
        this.idDireccionTrabajo = idDireccionTrabajo;
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

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    @XmlTransient
    public Collection<Medico> getMedicoCollection() {
        return medicoCollection;
    }

    public void setMedicoCollection(Collection<Medico> medicoCollection) {
        this.medicoCollection = medicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccionTrabajo != null ? idDireccionTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direcciontrabajo)) {
            return false;
        }
        Direcciontrabajo other = (Direcciontrabajo) object;
        if ((this.idDireccionTrabajo == null && other.idDireccionTrabajo != null) || (this.idDireccionTrabajo != null && !this.idDireccionTrabajo.equals(other.idDireccionTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.Direcciontrabajo[ idDireccionTrabajo=" + idDireccionTrabajo + " ]";
    }
    
}
