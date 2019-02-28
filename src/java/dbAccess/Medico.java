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
@Table(name = "medico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m")
    , @NamedQuery(name = "Medico.findByIdMedico", query = "SELECT m FROM Medico m WHERE m.idMedico = :idMedico")
    , @NamedQuery(name = "Medico.findByNombre", query = "SELECT m FROM Medico m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Medico.findByApellidoP", query = "SELECT m FROM Medico m WHERE m.apellidoP = :apellidoP")
    , @NamedQuery(name = "Medico.findByApellidoM", query = "SELECT m FROM Medico m WHERE m.apellidoM = :apellidoM")
    , @NamedQuery(name = "Medico.findByPassword", query = "SELECT m FROM Medico m WHERE m.password = :password")})
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "idMedico")
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMedico")
    private Integer idMedico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
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
    @Size(min = 1, max = 130)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medico")
    //@JsonManagedReference(value="medicoPacientes")
    private Collection<MedicoHasPaciente> medicoHasPacienteCollection;
    @JoinColumn(name = "DireccionTrabajo_idDireccionTrabajo", referencedColumnName = "idDireccionTrabajo")
    @ManyToOne(optional = false)
    //@JsonManagedReference(value="direcciones")
    private Direcciontrabajo direccionTrabajoidDireccionTrabajo;
    @JoinColumn(name = "Especialidad_idEspecialidad", referencedColumnName = "idEspecialidad")
    @ManyToOne(optional = false)
    //@JsonManagedReference(value="especialidades")
    private Especialidad especialidadidEspecialidad;
    @JoinColumn(name = "Universidad_idUniversidad", referencedColumnName = "idUniversidad")
    @ManyToOne(optional = false)
    //@JsonManagedReference(value="universidades")
    private Universidad universidadidUniversidad;

    public Medico() {
    }

    public Medico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public Medico(Integer idMedico, String nombre, String apellidoP, String apellidoM, String password) {
        this.idMedico = idMedico;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.password = password;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
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

    public Direcciontrabajo getDireccionTrabajoidDireccionTrabajo() {
        return direccionTrabajoidDireccionTrabajo;
    }

    public void setDireccionTrabajoidDireccionTrabajo(Direcciontrabajo direccionTrabajoidDireccionTrabajo) {
        this.direccionTrabajoidDireccionTrabajo = direccionTrabajoidDireccionTrabajo;
    }

    public Especialidad getEspecialidadidEspecialidad() {
        return especialidadidEspecialidad;
    }

    public void setEspecialidadidEspecialidad(Especialidad especialidadidEspecialidad) {
        this.especialidadidEspecialidad = especialidadidEspecialidad;
    }

    public Universidad getUniversidadidUniversidad() {
        return universidadidUniversidad;
    }

    public void setUniversidadidUniversidad(Universidad universidadidUniversidad) {
        this.universidadidUniversidad = universidadidUniversidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedico != null ? idMedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.idMedico == null && other.idMedico != null) || (this.idMedico != null && !this.idMedico.equals(other.idMedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.Medico[ idMedico=" + idMedico + " ]";
    }
    
}
