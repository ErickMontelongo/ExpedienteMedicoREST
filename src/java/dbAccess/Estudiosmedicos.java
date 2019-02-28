/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbAccess;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "estudiosmedicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiosmedicos.findAll", query = "SELECT e FROM Estudiosmedicos e")
    , @NamedQuery(name = "Estudiosmedicos.findByIdEstudiosMedicos", query = "SELECT e FROM Estudiosmedicos e WHERE e.idEstudiosMedicos = :idEstudiosMedicos")
    , @NamedQuery(name = "Estudiosmedicos.findByFechaEstudio", query = "SELECT e FROM Estudiosmedicos e WHERE e.fechaEstudio = :fechaEstudio")})
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "idEstudiosMedicos")
public class Estudiosmedicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstudiosMedicos")
    private Integer idEstudiosMedicos;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "rutaImagen")
    private String rutaImagen;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "rutaCarpetaImagenes")
    private String rutaCarpetaImagenes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaEstudio")
    @Temporal(TemporalType.DATE)
    private Date fechaEstudio;
    @JoinColumn(name = "DatosEstudiosMedicos_idDatosEstudiosMedicos", referencedColumnName = "idDatosEstudiosMedicos")
    @ManyToOne(optional = false)
    private Datosestudiosmedicos datosEstudiosMedicosidDatosEstudiosMedicos;
    @JoinColumn(name = "Paciente_curp", referencedColumnName = "curp")
    @ManyToOne(optional = false)
    //@JsonBackReference(value="estudios")
    private Paciente pacientecurp;

    public Estudiosmedicos() {
    }

    public Estudiosmedicos(Integer idEstudiosMedicos) {
        this.idEstudiosMedicos = idEstudiosMedicos;
    }

    public Estudiosmedicos(Integer idEstudiosMedicos, String rutaImagen, String rutaCarpetaImagenes, Date fechaEstudio) {
        this.idEstudiosMedicos = idEstudiosMedicos;
        this.rutaImagen = rutaImagen;
        this.rutaCarpetaImagenes = rutaCarpetaImagenes;
        this.fechaEstudio = fechaEstudio;
    }

    public Integer getIdEstudiosMedicos() {
        return idEstudiosMedicos;
    }

    public void setIdEstudiosMedicos(Integer idEstudiosMedicos) {
        this.idEstudiosMedicos = idEstudiosMedicos;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getRutaCarpetaImagenes() {
        return rutaCarpetaImagenes;
    }

    public void setRutaCarpetaImagenes(String rutaCarpetaImagenes) {
        this.rutaCarpetaImagenes = rutaCarpetaImagenes;
    }

    public Date getFechaEstudio() {
        return fechaEstudio;
    }

    public void setFechaEstudio(Date fechaEstudio) {
        this.fechaEstudio = fechaEstudio;
    }

    public Datosestudiosmedicos getDatosEstudiosMedicosidDatosEstudiosMedicos() {
        return datosEstudiosMedicosidDatosEstudiosMedicos;
    }

    public void setDatosEstudiosMedicosidDatosEstudiosMedicos(Datosestudiosmedicos datosEstudiosMedicosidDatosEstudiosMedicos) {
        this.datosEstudiosMedicosidDatosEstudiosMedicos = datosEstudiosMedicosidDatosEstudiosMedicos;
    }

    public Paciente getPacientecurp() {
        return pacientecurp;
    }

    public void setPacientecurp(Paciente pacientecurp) {
        this.pacientecurp = pacientecurp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstudiosMedicos != null ? idEstudiosMedicos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiosmedicos)) {
            return false;
        }
        Estudiosmedicos other = (Estudiosmedicos) object;
        if ((this.idEstudiosMedicos == null && other.idEstudiosMedicos != null) || (this.idEstudiosMedicos != null && !this.idEstudiosMedicos.equals(other.idEstudiosMedicos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.Estudiosmedicos[ idEstudiosMedicos=" + idEstudiosMedicos + " ]";
    }
    
}
