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
@Table(name = "prescripcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prescripcion.findAll", query = "SELECT p FROM Prescripcion p")
    , @NamedQuery(name = "Prescripcion.findByIdPrescripcion", query = "SELECT p FROM Prescripcion p WHERE p.idPrescripcion = :idPrescripcion")
    , @NamedQuery(name = "Prescripcion.findByFecha", query = "SELECT p FROM Prescripcion p WHERE p.fecha = :fecha")
    , @NamedQuery(name = "Prescripcion.findByMedico", query = "SELECT p FROM Prescripcion p WHERE p.medico = :medico")
    , @NamedQuery(name = "Prescripcion.findByCedula", query = "SELECT p FROM Prescripcion p WHERE p.cedula = :cedula")})
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "idPrescripcion")
public class Prescripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPrescripcion")
    private Integer idPrescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "medico")
    private String medico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedula")
    private int cedula;
    @JoinColumn(name = "Paciente_curp", referencedColumnName = "curp")
    @ManyToOne(optional = false)
    //@JsonBackReference(value="prescripcion")
    private Paciente pacientecurp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prescripcionidPrescripcion")
    //@JsonManagedReference(value="medicamento")
    private Collection<Medicamento> medicamentoCollection;

    public Prescripcion() {
    }

    public Prescripcion(Integer idPrescripcion) {
        this.idPrescripcion = idPrescripcion;
    }

    public Prescripcion(Integer idPrescripcion, Date fecha, String medico, int cedula) {
        this.idPrescripcion = idPrescripcion;
        this.fecha = fecha;
        this.medico = medico;
        this.cedula = cedula;
    }

    public Integer getIdPrescripcion() {
        return idPrescripcion;
    }

    public void setIdPrescripcion(Integer idPrescripcion) {
        this.idPrescripcion = idPrescripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public Paciente getPacientecurp() {
        return pacientecurp;
    }

    public void setPacientecurp(Paciente pacientecurp) {
        this.pacientecurp = pacientecurp;
    }

    @XmlTransient
    public Collection<Medicamento> getMedicamentoCollection() {
        return medicamentoCollection;
    }

    public void setMedicamentoCollection(Collection<Medicamento> medicamentoCollection) {
        this.medicamentoCollection = medicamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrescripcion != null ? idPrescripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prescripcion)) {
            return false;
        }
        Prescripcion other = (Prescripcion) object;
        if ((this.idPrescripcion == null && other.idPrescripcion != null) || (this.idPrescripcion != null && !this.idPrescripcion.equals(other.idPrescripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.Prescripcion[ idPrescripcion=" + idPrescripcion + " ]";
    }
    
}
