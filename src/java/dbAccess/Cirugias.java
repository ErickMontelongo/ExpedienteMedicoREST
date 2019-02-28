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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cirugias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cirugias.findAll", query = "SELECT c FROM Cirugias c")
    , @NamedQuery(name = "Cirugias.findByIdCirugias", query = "SELECT c FROM Cirugias c WHERE c.idCirugias = :idCirugias")
    , @NamedQuery(name = "Cirugias.findByFecha", query = "SELECT c FROM Cirugias c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "Cirugias.findByClinica", query = "SELECT c FROM Cirugias c WHERE c.clinica = :clinica")
    , @NamedQuery(name = "Cirugias.findByNombreOperacion", query = "SELECT c FROM Cirugias c WHERE c.nombreOperacion = :nombreOperacion")})
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "idCirugias")
public class Cirugias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCirugias")
    private Integer idCirugias;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "clinica")
    private String clinica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombreOperacion")
    private String nombreOperacion;
    @JoinColumn(name = "HistoriaClinica_idHistoriaClinica", referencedColumnName = "idHistoriaClinica")
    @ManyToOne(optional = false)
    private Historiaclinica historiaClinicaidHistoriaClinica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cirugiasidCirugias")
    private Collection<Resumencirugia> resumencirugiaCollection;

    public Cirugias() {
    }

    public Cirugias(Integer idCirugias) {
        this.idCirugias = idCirugias;
    }

    public Cirugias(Integer idCirugias, Date fecha, String clinica, String nombreOperacion) {
        this.idCirugias = idCirugias;
        this.fecha = fecha;
        this.clinica = clinica;
        this.nombreOperacion = nombreOperacion;
    }

    public Integer getIdCirugias() {
        return idCirugias;
    }

    public void setIdCirugias(Integer idCirugias) {
        this.idCirugias = idCirugias;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getClinica() {
        return clinica;
    }

    public void setClinica(String clinica) {
        this.clinica = clinica;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    public Historiaclinica getHistoriaClinicaidHistoriaClinica() {
        return historiaClinicaidHistoriaClinica;
    }

    public void setHistoriaClinicaidHistoriaClinica(Historiaclinica historiaClinicaidHistoriaClinica) {
        this.historiaClinicaidHistoriaClinica = historiaClinicaidHistoriaClinica;
    }

    @XmlTransient
    public Collection<Resumencirugia> getResumencirugiaCollection() {
        return resumencirugiaCollection;
    }

    public void setResumencirugiaCollection(Collection<Resumencirugia> resumencirugiaCollection) {
        this.resumencirugiaCollection = resumencirugiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCirugias != null ? idCirugias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cirugias)) {
            return false;
        }
        Cirugias other = (Cirugias) object;
        if ((this.idCirugias == null && other.idCirugias != null) || (this.idCirugias != null && !this.idCirugias.equals(other.idCirugias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataHolders.Cirugias[ idCirugias=" + idCirugias + " ]";
    }
    
}
