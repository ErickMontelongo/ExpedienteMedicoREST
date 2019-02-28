/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbAccess;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Punkid PC
 */
@Entity
@Table(name = "vacunas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacunas.findAll", query = "SELECT v FROM Vacunas v")
    , @NamedQuery(name = "Vacunas.findByIdVacunas", query = "SELECT v FROM Vacunas v WHERE v.idVacunas = :idVacunas")
    , @NamedQuery(name = "Vacunas.findByNombre", query = "SELECT v FROM Vacunas v WHERE v.nombre = :nombre")
    , @NamedQuery(name = "Vacunas.findByFecha", query = "SELECT v FROM Vacunas v WHERE v.fecha = :fecha")})
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "idVacunas")
public class Vacunas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVacunas")
    private Integer idVacunas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "HistoriaClinica_idHistoriaClinica", referencedColumnName = "idHistoriaClinica")
    @ManyToOne(optional = false)
    private Historiaclinica historiaClinicaidHistoriaClinica;

    public Vacunas() {
    }

    public Vacunas(Integer idVacunas) {
        this.idVacunas = idVacunas;
    }

    public Vacunas(Integer idVacunas, String nombre, Date fecha) {
        this.idVacunas = idVacunas;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public Integer getIdVacunas() {
        return idVacunas;
    }

    public void setIdVacunas(Integer idVacunas) {
        this.idVacunas = idVacunas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        hash += (idVacunas != null ? idVacunas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacunas)) {
            return false;
        }
        Vacunas other = (Vacunas) object;
        if ((this.idVacunas == null && other.idVacunas != null) || (this.idVacunas != null && !this.idVacunas.equals(other.idVacunas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataHolders.Vacunas[ idVacunas=" + idVacunas + " ]";
    }
    
}
