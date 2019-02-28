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
@Table(name = "antecedentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Antecedentes.findAll", query = "SELECT a FROM Antecedentes a")
    , @NamedQuery(name = "Antecedentes.findByIdAntecedentes", query = "SELECT a FROM Antecedentes a WHERE a.idAntecedentes = :idAntecedentes")
    , @NamedQuery(name = "Antecedentes.findByFamiliar", query = "SELECT a FROM Antecedentes a WHERE a.familiar = :familiar")
    , @NamedQuery(name = "Antecedentes.findByVivo", query = "SELECT a FROM Antecedentes a WHERE a.vivo = :vivo")
    , @NamedQuery(name = "Antecedentes.findByCausa", query = "SELECT a FROM Antecedentes a WHERE a.causa = :causa")})
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "idAntecedentes")
public class Antecedentes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAntecedentes")
    private Integer idAntecedentes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "familiar")
    private String familiar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vivo")
    private boolean vivo;
    @Size(max = 255)
    @Column(name = "causa")
    private String causa;
    @JoinColumn(name = "HistoriaClinica_idHistoriaClinica", referencedColumnName = "idHistoriaClinica")
    @ManyToOne(optional = false)
    private Historiaclinica historiaClinicaidHistoriaClinica;

    public Antecedentes() {
    }

    public Antecedentes(Integer idAntecedentes) {
        this.idAntecedentes = idAntecedentes;
    }

    public Antecedentes(Integer idAntecedentes, String familiar, boolean vivo) {
        this.idAntecedentes = idAntecedentes;
        this.familiar = familiar;
        this.vivo = vivo;
    }

    public Integer getIdAntecedentes() {
        return idAntecedentes;
    }

    public void setIdAntecedentes(Integer idAntecedentes) {
        this.idAntecedentes = idAntecedentes;
    }

    public String getFamiliar() {
        return familiar;
    }

    public void setFamiliar(String familiar) {
        this.familiar = familiar;
    }

    public boolean getVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
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
        hash += (idAntecedentes != null ? idAntecedentes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Antecedentes)) {
            return false;
        }
        Antecedentes other = (Antecedentes) object;
        if ((this.idAntecedentes == null && other.idAntecedentes != null) || (this.idAntecedentes != null && !this.idAntecedentes.equals(other.idAntecedentes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataHolders.Antecedentes[ idAntecedentes=" + idAntecedentes + " ]";
    }
    
}
