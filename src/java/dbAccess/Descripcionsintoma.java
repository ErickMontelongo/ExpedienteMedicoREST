/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbAccess;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "descripcionsintoma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Descripcionsintoma.findAll", query = "SELECT d FROM Descripcionsintoma d")
    , @NamedQuery(name = "Descripcionsintoma.findByIdDescripcionSintoma", query = "SELECT d FROM Descripcionsintoma d WHERE d.idDescripcionSintoma = :idDescripcionSintoma")
    , @NamedQuery(name = "Descripcionsintoma.findByIntensidad", query = "SELECT d FROM Descripcionsintoma d WHERE d.intensidad = :intensidad")
    , @NamedQuery(name = "Descripcionsintoma.findByFrecuencia", query = "SELECT d FROM Descripcionsintoma d WHERE d.frecuencia = :frecuencia")
    , @NamedQuery(name = "Descripcionsintoma.findByRegionCuerpo", query = "SELECT d FROM Descripcionsintoma d WHERE d.regionCuerpo = :regionCuerpo")
    , @NamedQuery(name = "Descripcionsintoma.findByRegionEspecifica", query = "SELECT d FROM Descripcionsintoma d WHERE d.regionEspecifica = :regionEspecifica")})
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "idDescripcionSintoma")
public class Descripcionsintoma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDescripcionSintoma")
    private Integer idDescripcionSintoma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "intensidad")
    private String intensidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "frecuencia")
    private String frecuencia;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "regionCuerpo")
    private String regionCuerpo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "regionEspecifica")
    private String regionEspecifica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "descripcionSintomaidDescripcionSintoma")
    //@JsonIgnore
    private Collection<Sintoma> sintomaCollection;

    public Descripcionsintoma() {
    }

    public Descripcionsintoma(Integer idDescripcionSintoma) {
        this.idDescripcionSintoma = idDescripcionSintoma;
    }

    public Descripcionsintoma(Integer idDescripcionSintoma, String intensidad, String frecuencia, String descripcion, String regionCuerpo, String regionEspecifica) {
        this.idDescripcionSintoma = idDescripcionSintoma;
        this.intensidad = intensidad;
        this.frecuencia = frecuencia;
        this.descripcion = descripcion;
        this.regionCuerpo = regionCuerpo;
        this.regionEspecifica = regionEspecifica;
    }

    public Integer getIdDescripcionSintoma() {
        return idDescripcionSintoma;
    }

    public void setIdDescripcionSintoma(Integer idDescripcionSintoma) {
        this.idDescripcionSintoma = idDescripcionSintoma;
    }

    public String getIntensidad() {
        return intensidad;
    }

    public void setIntensidad(String intensidad) {
        this.intensidad = intensidad;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRegionCuerpo() {
        return regionCuerpo;
    }

    public void setRegionCuerpo(String regionCuerpo) {
        this.regionCuerpo = regionCuerpo;
    }

    public String getRegionEspecifica() {
        return regionEspecifica;
    }

    public void setRegionEspecifica(String regionEspecifica) {
        this.regionEspecifica = regionEspecifica;
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
        hash += (idDescripcionSintoma != null ? idDescripcionSintoma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Descripcionsintoma)) {
            return false;
        }
        Descripcionsintoma other = (Descripcionsintoma) object;
        if ((this.idDescripcionSintoma == null && other.idDescripcionSintoma != null) || (this.idDescripcionSintoma != null && !this.idDescripcionSintoma.equals(other.idDescripcionSintoma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.Descripcionsintoma[ idDescripcionSintoma=" + idDescripcionSintoma + " ]";
    }
    
}
