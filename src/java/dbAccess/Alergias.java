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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Punkid PC
 */
@Entity
@Table(name = "alergias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alergias.findAll", query = "SELECT a FROM Alergias a")
    , @NamedQuery(name = "Alergias.findByIdAlergias", query = "SELECT a FROM Alergias a WHERE a.idAlergias = :idAlergias")
    , @NamedQuery(name = "Alergias.findByNombre", query = "SELECT a FROM Alergias a WHERE a.nombre = :nombre")})
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "idAlergias")
public class Alergias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAlergias")
    private Integer idAlergias;
    @Size(max = 60)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "HistoriaClinica_idHistoriaClinica", referencedColumnName = "idHistoriaClinica")
    @ManyToOne(optional = false)
    private Historiaclinica historiaClinicaidHistoriaClinica;

    public Alergias() {
    }

    public Alergias(Integer idAlergias) {
        this.idAlergias = idAlergias;
    }

    public Integer getIdAlergias() {
        return idAlergias;
    }

    public void setIdAlergias(Integer idAlergias) {
        this.idAlergias = idAlergias;
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
        hash += (idAlergias != null ? idAlergias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alergias)) {
            return false;
        }
        Alergias other = (Alergias) object;
        if ((this.idAlergias == null && other.idAlergias != null) || (this.idAlergias != null && !this.idAlergias.equals(other.idAlergias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataHolders.Alergias[ idAlergias=" + idAlergias + " ]";
    }
    
}
