/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbAccess;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p")
    , @NamedQuery(name = "Paciente.findByCurp", query = "SELECT p FROM Paciente p WHERE p.curp = :curp")
    , @NamedQuery(name = "Paciente.findByNombre", query = "SELECT p FROM Paciente p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Paciente.findByApellidoP", query = "SELECT p FROM Paciente p WHERE p.apellidoP = :apellidoP")
    , @NamedQuery(name = "Paciente.findByApellidoM", query = "SELECT p FROM Paciente p WHERE p.apellidoM = :apellidoM")
    , @NamedQuery(name = "Paciente.findByPassword", query = "SELECT p FROM Paciente p WHERE p.password = :password")})
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "curp")
public class Paciente implements Serializable {

    @JoinColumn(name = "HistoriaClinica_idHistoriaClinica", referencedColumnName = "idHistoriaClinica")
    @ManyToOne(optional = false)
    private Historiaclinica historiaClinicaidHistoriaClinica;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "curp")
    private String curp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellidoP")
    private String apellidoP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellidoM")
    private String apellidoM;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    //@JsonManagedReference(value="pacienteMedico")
    private Collection<MedicoHasPaciente> medicoHasPacienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacientecurp")
    //@JsonManagedReference(value="prescripcion")
    private Collection<Prescripcion> prescripcionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacientecurp")
    //@JsonManagedReference(value="estudios")
    private Collection<Estudiosmedicos> estudiosmedicosCollection;
    @JoinColumn(name = "DireccionPaciente_idDireccionPaciente", referencedColumnName = "idDireccionPaciente")
    @ManyToOne(optional = false)
    private Direccionpaciente direccionPacienteidDireccionPaciente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacientecurp")
    //@JsonManagedReference(value="sintomas")
    private Collection<Sintoma> sintomaCollection;

    public Paciente() {
    }

    public Paciente(String curp) {
        this.curp = curp;
    }

    public Paciente(String curp, String nombre, String apellidoP, String apellidoM, String password) {
        this.curp = curp;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.password = password;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<MedicoHasPaciente> getMedicoHasPacienteCollection() {
        return medicoHasPacienteCollection;
    }

    public void setMedicoHasPacienteCollection(Collection<MedicoHasPaciente> medicoHasPacienteCollection) {
        this.medicoHasPacienteCollection = medicoHasPacienteCollection;
    }

    @XmlTransient
    public Collection<Prescripcion> getPrescripcionCollection() {
        return prescripcionCollection;
    }

    public void setPrescripcionCollection(Collection<Prescripcion> prescripcionCollection) {
        this.prescripcionCollection = prescripcionCollection;
    }

    @XmlTransient
    public Collection<Estudiosmedicos> getEstudiosmedicosCollection() {
        return estudiosmedicosCollection;
    }

    public void setEstudiosmedicosCollection(Collection<Estudiosmedicos> estudiosmedicosCollection) {
        this.estudiosmedicosCollection = estudiosmedicosCollection;
    }

    public Direccionpaciente getDireccionPacienteidDireccionPaciente() {
        return direccionPacienteidDireccionPaciente;
    }

    public void setDireccionPacienteidDireccionPaciente(Direccionpaciente direccionPacienteidDireccionPaciente) {
        this.direccionPacienteidDireccionPaciente = direccionPacienteidDireccionPaciente;
    }

    @XmlTransient
    public Collection<Sintoma> getSintomaCollection() {
        return sintomaCollection;
    }

    public void setSintomaCollection(Collection<Sintoma> sintomaCollection) {
        this.sintomaCollection = sintomaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (curp != null ? curp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.curp == null && other.curp != null) || (this.curp != null && !this.curp.equals(other.curp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.Paciente[ curp=" + curp + " ]";
    }

    public Historiaclinica getHistoriaClinicaidHistoriaClinica() {
        return historiaClinicaidHistoriaClinica;
    }

    public void setHistoriaClinicaidHistoriaClinica(Historiaclinica historiaClinicaidHistoriaClinica) {
        this.historiaClinicaidHistoriaClinica = historiaClinicaidHistoriaClinica;
    }
    
}
