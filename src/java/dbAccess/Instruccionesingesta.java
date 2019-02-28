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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Punkid PC
 */
@Entity
@Table(name = "instruccionesingesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instruccionesingesta.findAll", query = "SELECT i FROM Instruccionesingesta i")
    , @NamedQuery(name = "Instruccionesingesta.findByIdInstruccionesIngesta", query = "SELECT i FROM Instruccionesingesta i WHERE i.idInstruccionesIngesta = :idInstruccionesIngesta")
    , @NamedQuery(name = "Instruccionesingesta.findByDuracion", query = "SELECT i FROM Instruccionesingesta i WHERE i.duracion = :duracion")
    , @NamedQuery(name = "Instruccionesingesta.findByFrecuencia", query = "SELECT i FROM Instruccionesingesta i WHERE i.frecuencia = :frecuencia")
    , @NamedQuery(name = "Instruccionesingesta.findByLunes", query = "SELECT i FROM Instruccionesingesta i WHERE i.lunes = :lunes")
    , @NamedQuery(name = "Instruccionesingesta.findByMartes", query = "SELECT i FROM Instruccionesingesta i WHERE i.martes = :martes")
    , @NamedQuery(name = "Instruccionesingesta.findByMiercoles", query = "SELECT i FROM Instruccionesingesta i WHERE i.miercoles = :miercoles")
    , @NamedQuery(name = "Instruccionesingesta.findByJueves", query = "SELECT i FROM Instruccionesingesta i WHERE i.jueves = :jueves")
    , @NamedQuery(name = "Instruccionesingesta.findByViernes", query = "SELECT i FROM Instruccionesingesta i WHERE i.viernes = :viernes")
    , @NamedQuery(name = "Instruccionesingesta.findBySabado", query = "SELECT i FROM Instruccionesingesta i WHERE i.sabado = :sabado")
    , @NamedQuery(name = "Instruccionesingesta.findByDomingo", query = "SELECT i FROM Instruccionesingesta i WHERE i.domingo = :domingo")})
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "idInstruccionesIngesta")
public class Instruccionesingesta implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instruccionesIngestaidInstruccionesIngesta")
    private Collection<Medicamento> medicamentoCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idInstruccionesIngesta")
    private Integer idInstruccionesIngesta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "duracion")
    private String duracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "frecuencia")
    private String frecuencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "lunes")
    private String lunes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "martes")
    private String martes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "miercoles")
    private String miercoles;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "jueves")
    private String jueves;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "viernes")
    private String viernes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "sabado")
    private String sabado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "domingo")
    private String domingo;

    public Instruccionesingesta() {
    }

    public Instruccionesingesta(Integer idInstruccionesIngesta) {
        this.idInstruccionesIngesta = idInstruccionesIngesta;
    }

    public Instruccionesingesta(Integer idInstruccionesIngesta, String duracion, String frecuencia, String lunes, String martes, String miercoles, String jueves, String viernes, String sabado, String domingo) {
        this.idInstruccionesIngesta = idInstruccionesIngesta;
        this.duracion = duracion;
        this.frecuencia = frecuencia;
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.sabado = sabado;
        this.domingo = domingo;
    }

    public Integer getIdInstruccionesIngesta() {
        return idInstruccionesIngesta;
    }

    public void setIdInstruccionesIngesta(Integer idInstruccionesIngesta) {
        this.idInstruccionesIngesta = idInstruccionesIngesta;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getLunes() {
        return lunes;
    }

    public void setLunes(String lunes) {
        this.lunes = lunes;
    }

    public String getMartes() {
        return martes;
    }

    public void setMartes(String martes) {
        this.martes = martes;
    }

    public String getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(String miercoles) {
        this.miercoles = miercoles;
    }

    public String getJueves() {
        return jueves;
    }

    public void setJueves(String jueves) {
        this.jueves = jueves;
    }

    public String getViernes() {
        return viernes;
    }

    public void setViernes(String viernes) {
        this.viernes = viernes;
    }

    public String getSabado() {
        return sabado;
    }

    public void setSabado(String sabado) {
        this.sabado = sabado;
    }

    public String getDomingo() {
        return domingo;
    }

    public void setDomingo(String domingo) {
        this.domingo = domingo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstruccionesIngesta != null ? idInstruccionesIngesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instruccionesingesta)) {
            return false;
        }
        Instruccionesingesta other = (Instruccionesingesta) object;
        if ((this.idInstruccionesIngesta == null && other.idInstruccionesIngesta != null) || (this.idInstruccionesIngesta != null && !this.idInstruccionesIngesta.equals(other.idInstruccionesIngesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.Instruccionesingesta[ idInstruccionesIngesta=" + idInstruccionesIngesta + " ]";
    }

    @XmlTransient
    public Collection<Medicamento> getMedicamentoCollection() {
        return medicamentoCollection;
    }

    public void setMedicamentoCollection(Collection<Medicamento> medicamentoCollection) {
        this.medicamentoCollection = medicamentoCollection;
    }
    
}
