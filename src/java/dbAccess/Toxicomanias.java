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
@Table(name = "toxicomanias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Toxicomanias.findAll", query = "SELECT t FROM Toxicomanias t")
    , @NamedQuery(name = "Toxicomanias.findByIdToxicomanias", query = "SELECT t FROM Toxicomanias t WHERE t.idToxicomanias = :idToxicomanias")
    , @NamedQuery(name = "Toxicomanias.findByNombre", query = "SELECT t FROM Toxicomanias t WHERE t.nombre = :nombre")})
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "idToxicomanias")
public class Toxicomanias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idToxicomanias")
    private Integer idToxicomanias;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "HistoriaClinica_idHistoriaClinica", referencedColumnName = "idHistoriaClinica")
    @ManyToOne(optional = false)
    private Historiaclinica historiaClinicaidHistoriaClinica;

    public Toxicomanias() {
    }

    public Toxicomanias(Integer idToxicomanias) {
        this.idToxicomanias = idToxicomanias;
    }

    public Toxicomanias(Integer idToxicomanias, String nombre) {
        this.idToxicomanias = idToxicomanias;
        this.nombre = nombre;
    }

    public Integer getIdToxicomanias() {
        return idToxicomanias;
    }

    public void setIdToxicomanias(Integer idToxicomanias) {
        this.idToxicomanias = idToxicomanias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idToxicomanias != null ? idToxicomanias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Toxicomanias)) {
            return false;
        }
        Toxicomanias other = (Toxicomanias) object;
        if ((this.idToxicomanias == null && other.idToxicomanias != null) || (this.idToxicomanias != null && !this.idToxicomanias.equals(other.idToxicomanias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataHolders.Toxicomanias[ idToxicomanias=" + idToxicomanias + " ]";
    }
    
}
