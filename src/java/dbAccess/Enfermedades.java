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
import javax.persistence.Lob;
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
@Table(name = "enfermedades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enfermedades.findAll", query = "SELECT e FROM Enfermedades e")
    , @NamedQuery(name = "Enfermedades.findByIdEnfermedades", query = "SELECT e FROM Enfermedades e WHERE e.idEnfermedades = :idEnfermedades")
    , @NamedQuery(name = "Enfermedades.findByNombre", query = "SELECT e FROM Enfermedades e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Enfermedades.findByFechaDiagnostico", query = "SELECT e FROM Enfermedades e WHERE e.fechaDiagnostico = :fechaDiagnostico")})
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "idEnfermedades")
public class Enfermedades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEnfermedades")
    private Integer idEnfermedades;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaDiagnostico")
    @Temporal(TemporalType.DATE)
    private Date fechaDiagnostico;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "tratamiento")
    private String tratamiento;
    @JoinColumn(name = "HistoriaClinica_idHistoriaClinica", referencedColumnName = "idHistoriaClinica")
    @ManyToOne(optional = false)
    private Historiaclinica historiaClinicaidHistoriaClinica;

    public Enfermedades() {
    }

    public Enfermedades(Integer idEnfermedades) {
        this.idEnfermedades = idEnfermedades;
    }

    public Enfermedades(Integer idEnfermedades, String nombre, Date fechaDiagnostico, String tratamiento) {
        this.idEnfermedades = idEnfermedades;
        this.nombre = nombre;
        this.fechaDiagnostico = fechaDiagnostico;
        this.tratamiento = tratamiento;
    }

    public Integer getIdEnfermedades() {
        return idEnfermedades;
    }

    public void setIdEnfermedades(Integer idEnfermedades) {
        this.idEnfermedades = idEnfermedades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    public void setFechaDiagnostico(Date fechaDiagnostico) {
        this.fechaDiagnostico = fechaDiagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
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
        hash += (idEnfermedades != null ? idEnfermedades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enfermedades)) {
            return false;
        }
        Enfermedades other = (Enfermedades) object;
        if ((this.idEnfermedades == null && other.idEnfermedades != null) || (this.idEnfermedades != null && !this.idEnfermedades.equals(other.idEnfermedades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataHolders.Enfermedades[ idEnfermedades=" + idEnfermedades + " ]";
    }
    
}
