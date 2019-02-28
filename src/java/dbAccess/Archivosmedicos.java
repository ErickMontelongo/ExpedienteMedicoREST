/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbAccess;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Punkid PC
 */
@Entity
@Table(name = "archivosmedicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Archivosmedicos.findAll", query = "SELECT a FROM Archivosmedicos a")
    , @NamedQuery(name = "Archivosmedicos.findByIdArchivosMedicos", query = "SELECT a FROM Archivosmedicos a WHERE a.idArchivosMedicos = :idArchivosMedicos")
    , @NamedQuery(name = "Archivosmedicos.findByRuta", query = "SELECT a FROM Archivosmedicos a WHERE a.ruta = :ruta")})
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "idArchivosMedicos")
public class Archivosmedicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idArchivosMedicos")
    private Integer idArchivosMedicos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ruta")
    private String ruta;
    @JoinColumn(name = "Hospitalizacion_idHospitalizacion", referencedColumnName = "idHospitalizacion")
    @ManyToOne(optional = false)
    private Hospitalizacion hospitalizacionidHospitalizacion;

    public Archivosmedicos() {
    }

    public Archivosmedicos(Integer idArchivosMedicos) {
        this.idArchivosMedicos = idArchivosMedicos;
    }

    public Archivosmedicos(Integer idArchivosMedicos, String ruta) {
        this.idArchivosMedicos = idArchivosMedicos;
        this.ruta = ruta;
    }

    public Integer getIdArchivosMedicos() {
        return idArchivosMedicos;
    }

    public void setIdArchivosMedicos(Integer idArchivosMedicos) {
        this.idArchivosMedicos = idArchivosMedicos;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Hospitalizacion getHospitalizacionidHospitalizacion() {
        return hospitalizacionidHospitalizacion;
    }

    public void setHospitalizacionidHospitalizacion(Hospitalizacion hospitalizacionidHospitalizacion) {
        this.hospitalizacionidHospitalizacion = hospitalizacionidHospitalizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArchivosMedicos != null ? idArchivosMedicos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Archivosmedicos)) {
            return false;
        }
        Archivosmedicos other = (Archivosmedicos) object;
        if ((this.idArchivosMedicos == null && other.idArchivosMedicos != null) || (this.idArchivosMedicos != null && !this.idArchivosMedicos.equals(other.idArchivosMedicos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataHolders.Archivosmedicos[ idArchivosMedicos=" + idArchivosMedicos + " ]";
    }
    
}
