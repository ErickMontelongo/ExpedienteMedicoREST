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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "datosestudiosmedicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datosestudiosmedicos.findAll", query = "SELECT d FROM Datosestudiosmedicos d")
    , @NamedQuery(name = "Datosestudiosmedicos.findByIdDatosEstudiosMedicos", query = "SELECT d FROM Datosestudiosmedicos d WHERE d.idDatosEstudiosMedicos = :idDatosEstudiosMedicos")
    , @NamedQuery(name = "Datosestudiosmedicos.findByCategoriaEstudio", query = "SELECT d FROM Datosestudiosmedicos d WHERE d.categoriaEstudio = :categoriaEstudio")
    , @NamedQuery(name = "Datosestudiosmedicos.findByNombreEstudio", query = "SELECT d FROM Datosestudiosmedicos d WHERE d.nombreEstudio = :nombreEstudio")
    , @NamedQuery(name = "Datosestudiosmedicos.findByNombreMedico", query = "SELECT d FROM Datosestudiosmedicos d WHERE d.nombreMedico = :nombreMedico")
    , @NamedQuery(name = "Datosestudiosmedicos.findByNombreClinica", query = "SELECT d FROM Datosestudiosmedicos d WHERE d.nombreClinica = :nombreClinica")})
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "idDatosEstudiosMedicos")
public class Datosestudiosmedicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDatosEstudiosMedicos")
    private Integer idDatosEstudiosMedicos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "categoriaEstudio")
    private String categoriaEstudio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreEstudio")
    private String nombreEstudio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "nombreMedico")
    private String nombreMedico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombreClinica")
    private String nombreClinica;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "interpretacion")
    private String interpretacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datosEstudiosMedicosidDatosEstudiosMedicos")
    //@JsonIgnore
    private Collection<Estudiosmedicos> estudiosmedicosCollection;

    public Datosestudiosmedicos() {
    }

    public Datosestudiosmedicos(Integer idDatosEstudiosMedicos) {
        this.idDatosEstudiosMedicos = idDatosEstudiosMedicos;
    }

    public Datosestudiosmedicos(Integer idDatosEstudiosMedicos, String categoriaEstudio, String nombreEstudio, String nombreMedico, String nombreClinica, String interpretacion) {
        this.idDatosEstudiosMedicos = idDatosEstudiosMedicos;
        this.categoriaEstudio = categoriaEstudio;
        this.nombreEstudio = nombreEstudio;
        this.nombreMedico = nombreMedico;
        this.nombreClinica = nombreClinica;
        this.interpretacion = interpretacion;
    }

    public Integer getIdDatosEstudiosMedicos() {
        return idDatosEstudiosMedicos;
    }

    public void setIdDatosEstudiosMedicos(Integer idDatosEstudiosMedicos) {
        this.idDatosEstudiosMedicos = idDatosEstudiosMedicos;
    }

    public String getCategoriaEstudio() {
        return categoriaEstudio;
    }

    public void setCategoriaEstudio(String categoriaEstudio) {
        this.categoriaEstudio = categoriaEstudio;
    }

    public String getNombreEstudio() {
        return nombreEstudio;
    }

    public void setNombreEstudio(String nombreEstudio) {
        this.nombreEstudio = nombreEstudio;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getNombreClinica() {
        return nombreClinica;
    }

    public void setNombreClinica(String nombreClinica) {
        this.nombreClinica = nombreClinica;
    }

    public String getInterpretacion() {
        return interpretacion;
    }

    public void setInterpretacion(String interpretacion) {
        this.interpretacion = interpretacion;
    }

    @XmlTransient
    public Collection<Estudiosmedicos> getEstudiosmedicosCollection() {
        return estudiosmedicosCollection;
    }

    public void setEstudiosmedicosCollection(Collection<Estudiosmedicos> estudiosmedicosCollection) {
        this.estudiosmedicosCollection = estudiosmedicosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDatosEstudiosMedicos != null ? idDatosEstudiosMedicos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datosestudiosmedicos)) {
            return false;
        }
        Datosestudiosmedicos other = (Datosestudiosmedicos) object;
        if ((this.idDatosEstudiosMedicos == null && other.idDatosEstudiosMedicos != null) || (this.idDatosEstudiosMedicos != null && !this.idDatosEstudiosMedicos.equals(other.idDatosEstudiosMedicos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.Datosestudiosmedicos[ idDatosEstudiosMedicos=" + idDatosEstudiosMedicos + " ]";
    }
    
}
