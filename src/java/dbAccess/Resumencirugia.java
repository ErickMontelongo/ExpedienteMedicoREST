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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Punkid PC
 */
@Entity
@Table(name = "resumencirugia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resumencirugia.findAll", query = "SELECT r FROM Resumencirugia r")
    , @NamedQuery(name = "Resumencirugia.findByIdResumenCirugia", query = "SELECT r FROM Resumencirugia r WHERE r.idResumenCirugia = :idResumenCirugia")
    , @NamedQuery(name = "Resumencirugia.findByRuta", query = "SELECT r FROM Resumencirugia r WHERE r.ruta = :ruta")})
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "idResumenCirugia")
public class Resumencirugia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idResumenCirugia")
    private Integer idResumenCirugia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ruta")
    private String ruta;
    @JoinColumn(name = "Cirugias_idCirugias", referencedColumnName = "idCirugias")
    @ManyToOne(optional = false)
    private Cirugias cirugiasidCirugias;

    public Resumencirugia() {
    }

    public Resumencirugia(Integer idResumenCirugia) {
        this.idResumenCirugia = idResumenCirugia;
    }

    public Resumencirugia(Integer idResumenCirugia, String ruta) {
        this.idResumenCirugia = idResumenCirugia;
        this.ruta = ruta;
    }

    public Integer getIdResumenCirugia() {
        return idResumenCirugia;
    }

    public void setIdResumenCirugia(Integer idResumenCirugia) {
        this.idResumenCirugia = idResumenCirugia;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Cirugias getCirugiasidCirugias() {
        return cirugiasidCirugias;
    }

    public void setCirugiasidCirugias(Cirugias cirugiasidCirugias) {
        this.cirugiasidCirugias = cirugiasidCirugias;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResumenCirugia != null ? idResumenCirugia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resumencirugia)) {
            return false;
        }
        Resumencirugia other = (Resumencirugia) object;
        if ((this.idResumenCirugia == null && other.idResumenCirugia != null) || (this.idResumenCirugia != null && !this.idResumenCirugia.equals(other.idResumenCirugia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataHolders.Resumencirugia[ idResumenCirugia=" + idResumenCirugia + " ]";
    }
    
}
