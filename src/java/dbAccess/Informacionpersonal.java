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
import javax.persistence.Id;
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
@Table(name = "informacionpersonal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Informacionpersonal.findAll", query = "SELECT i FROM Informacionpersonal i")
    , @NamedQuery(name = "Informacionpersonal.findByIdInformacionPersonal", query = "SELECT i FROM Informacionpersonal i WHERE i.idInformacionPersonal = :idInformacionPersonal")
    , @NamedQuery(name = "Informacionpersonal.findBySexo", query = "SELECT i FROM Informacionpersonal i WHERE i.sexo = :sexo")
    , @NamedQuery(name = "Informacionpersonal.findByFechaNac", query = "SELECT i FROM Informacionpersonal i WHERE i.fechaNac = :fechaNac")
    , @NamedQuery(name = "Informacionpersonal.findByAltura", query = "SELECT i FROM Informacionpersonal i WHERE i.altura = :altura")
    , @NamedQuery(name = "Informacionpersonal.findByPeso", query = "SELECT i FROM Informacionpersonal i WHERE i.peso = :peso")
    , @NamedQuery(name = "Informacionpersonal.findByTipoSangre", query = "SELECT i FROM Informacionpersonal i WHERE i.tipoSangre = :tipoSangre")
    , @NamedQuery(name = "Informacionpersonal.findByTransfuciones", query = "SELECT i FROM Informacionpersonal i WHERE i.transfuciones = :transfuciones")})
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "idInformacionPersonal")
public class Informacionpersonal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idInformacionPersonal")
    private Integer idInformacionPersonal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaNac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "altura")
    private float altura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso")
    private float peso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "tipoSangre")
    private String tipoSangre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "transfuciones")
    private boolean transfuciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "informacionPersonalidInformacionPersonal")
    private Collection<Historiaclinica> historiaclinicaCollection;

    public Informacionpersonal() {
    }

    public Informacionpersonal(Integer idInformacionPersonal) {
        this.idInformacionPersonal = idInformacionPersonal;
    }

    public Informacionpersonal(Integer idInformacionPersonal, String sexo, Date fechaNac, float altura, float peso, String tipoSangre, boolean transfuciones) {
        this.idInformacionPersonal = idInformacionPersonal;
        this.sexo = sexo;
        this.fechaNac = fechaNac;
        this.altura = altura;
        this.peso = peso;
        this.tipoSangre = tipoSangre;
        this.transfuciones = transfuciones;
    }

    public Integer getIdInformacionPersonal() {
        return idInformacionPersonal;
    }

    public void setIdInformacionPersonal(Integer idInformacionPersonal) {
        this.idInformacionPersonal = idInformacionPersonal;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public boolean getTransfuciones() {
        return transfuciones;
    }

    public void setTransfuciones(boolean transfuciones) {
        this.transfuciones = transfuciones;
    }

    @XmlTransient
    public Collection<Historiaclinica> getHistoriaclinicaCollection() {
        return historiaclinicaCollection;
    }

    public void setHistoriaclinicaCollection(Collection<Historiaclinica> historiaclinicaCollection) {
        this.historiaclinicaCollection = historiaclinicaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInformacionPersonal != null ? idInformacionPersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Informacionpersonal)) {
            return false;
        }
        Informacionpersonal other = (Informacionpersonal) object;
        if ((this.idInformacionPersonal == null && other.idInformacionPersonal != null) || (this.idInformacionPersonal != null && !this.idInformacionPersonal.equals(other.idInformacionPersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataHolders.Informacionpersonal[ idInformacionPersonal=" + idInformacionPersonal + " ]";
    }
    
}
