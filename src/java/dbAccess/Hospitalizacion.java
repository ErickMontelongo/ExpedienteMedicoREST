/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbAccess;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Punkid PC
 */
@Entity
@Table(name = "hospitalizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hospitalizacion.findAll", query = "SELECT h FROM Hospitalizacion h")
    , @NamedQuery(name = "Hospitalizacion.findByIdHospitalizacion", query = "SELECT h FROM Hospitalizacion h WHERE h.idHospitalizacion = :idHospitalizacion")
    , @NamedQuery(name = "Hospitalizacion.findByFechaIngreso", query = "SELECT h FROM Hospitalizacion h WHERE h.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "Hospitalizacion.findByFechaSalida", query = "SELECT h FROM Hospitalizacion h WHERE h.fechaSalida = :fechaSalida")
    , @NamedQuery(name = "Hospitalizacion.findByClinica", query = "SELECT h FROM Hospitalizacion h WHERE h.clinica = :clinica")
    , @NamedQuery(name = "Hospitalizacion.findByCausa", query = "SELECT h FROM Hospitalizacion h WHERE h.causa = :causa")})
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "idHospitalizacion")
public class Hospitalizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHospitalizacion")
    private Integer idHospitalizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaIngreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaSalida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "clinica")
    private String clinica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "causa")
    private String causa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hospitalizacionidHospitalizacion")
    private Collection<Archivosmedicos> archivosmedicosCollection;
    @JoinColumn(name = "HistoriaClinica_idHistoriaClinica", referencedColumnName = "idHistoriaClinica")
    @ManyToOne(optional = false)
    private Historiaclinica historiaClinicaidHistoriaClinica;

    public Hospitalizacion() {
    }

    public Hospitalizacion(Integer idHospitalizacion) {
        this.idHospitalizacion = idHospitalizacion;
    }

    public Hospitalizacion(Integer idHospitalizacion, Date fechaIngreso, Date fechaSalida, String clinica, String causa) {
        this.idHospitalizacion = idHospitalizacion;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.clinica = clinica;
        this.causa = causa;
    }

    public Integer getIdHospitalizacion() {
        return idHospitalizacion;
    }

    public void setIdHospitalizacion(Integer idHospitalizacion) {
        this.idHospitalizacion = idHospitalizacion;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getClinica() {
        return clinica;
    }

    public void setClinica(String clinica) {
        this.clinica = clinica;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    @XmlTransient
    public Collection<Archivosmedicos> getArchivosmedicosCollection() {
        return archivosmedicosCollection;
    }

    public void setArchivosmedicosCollection(Collection<Archivosmedicos> archivosmedicosCollection) {
        this.archivosmedicosCollection = archivosmedicosCollection;
    }

    public Historiaclinica getHistoriaClinicaidHistoriaClinica() {
        return historiaClinicaidHistoriaClinica;
    }

    public void setHistoriaClinicaidHistoriaClinica(Historiaclinica historiaClinicaidHistoriaClinica) {
        this.historiaClinicaidHistoriaClinica = historiaClinicaidHistoriaClinica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHospitalizacion != null ? idHospitalizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hospitalizacion)) {
            return false;
        }
        Hospitalizacion other = (Hospitalizacion) object;
        if ((this.idHospitalizacion == null && other.idHospitalizacion != null) || (this.idHospitalizacion != null && !this.idHospitalizacion.equals(other.idHospitalizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataHolders.Hospitalizacion[ idHospitalizacion=" + idHospitalizacion + " ]";
    }
    
}
