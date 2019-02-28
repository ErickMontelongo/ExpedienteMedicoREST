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
import javax.persistence.Lob;
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
@Table(name = "medicamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicamento.findAll", query = "SELECT m FROM Medicamento m")
    , @NamedQuery(name = "Medicamento.findByIdMedicamento", query = "SELECT m FROM Medicamento m WHERE m.idMedicamento = :idMedicamento")
    , @NamedQuery(name = "Medicamento.findByNombreComercial", query = "SELECT m FROM Medicamento m WHERE m.nombreComercial = :nombreComercial")
    , @NamedQuery(name = "Medicamento.findByNombreGenerico", query = "SELECT m FROM Medicamento m WHERE m.nombreGenerico = :nombreGenerico")
    , @NamedQuery(name = "Medicamento.findByConcentracion", query = "SELECT m FROM Medicamento m WHERE m.concentracion = :concentracion")
    , @NamedQuery(name = "Medicamento.findByViaAdministracion", query = "SELECT m FROM Medicamento m WHERE m.viaAdministracion = :viaAdministracion")
    , @NamedQuery(name = "Medicamento.findByAlergia", query = "SELECT m FROM Medicamento m WHERE m.alergia = :alergia")
    , @NamedQuery(name = "Medicamento.findByActivo", query = "SELECT m FROM Medicamento m WHERE m.activo = :activo")})
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "idMedicamento")
public class Medicamento implements Serializable {

    @JoinColumn(name = "InstruccionesIngesta_idInstruccionesIngesta", referencedColumnName = "idInstruccionesIngesta")
    @ManyToOne(optional = false)
    private Instruccionesingesta instruccionesIngestaidInstruccionesIngesta;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMedicamento")
    private Integer idMedicamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombreComercial")
    private String nombreComercial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombreGenerico")
    private String nombreGenerico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "concentracion")
    private String concentracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "viaAdministracion")
    private String viaAdministracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "alergia")
    private boolean alergia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "reaccionesAdversas")
    private String reaccionesAdversas;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "resultadoUso")
    private String resultadoUso;
    @JoinColumn(name = "Prescripcion_idPrescripcion", referencedColumnName = "idPrescripcion")
    @ManyToOne(optional = false)
    private Prescripcion prescripcionidPrescripcion;

    public Medicamento() {
    }

    public Medicamento(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public Medicamento(Integer idMedicamento, String nombreComercial, String nombreGenerico, String concentracion, String viaAdministracion, boolean alergia, boolean activo, String reaccionesAdversas, String resultadoUso) {
        this.idMedicamento = idMedicamento;
        this.nombreComercial = nombreComercial;
        this.nombreGenerico = nombreGenerico;
        this.concentracion = concentracion;
        this.viaAdministracion = viaAdministracion;
        this.alergia = alergia;
        this.activo = activo;
        this.reaccionesAdversas = reaccionesAdversas;
        this.resultadoUso = resultadoUso;
    }

    public Integer getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNombreGenerico() {
        return nombreGenerico;
    }

    public void setNombreGenerico(String nombreGenerico) {
        this.nombreGenerico = nombreGenerico;
    }

    public String getConcentracion() {
        return concentracion;
    }

    public void setConcentracion(String concentracion) {
        this.concentracion = concentracion;
    }

    public String getViaAdministracion() {
        return viaAdministracion;
    }

    public void setViaAdministracion(String viaAdministracion) {
        this.viaAdministracion = viaAdministracion;
    }

    public boolean getAlergia() {
        return alergia;
    }

    public void setAlergia(boolean alergia) {
        this.alergia = alergia;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getReaccionesAdversas() {
        return reaccionesAdversas;
    }

    public void setReaccionesAdversas(String reaccionesAdversas) {
        this.reaccionesAdversas = reaccionesAdversas;
    }

    public String getResultadoUso() {
        return resultadoUso;
    }

    public void setResultadoUso(String resultadoUso) {
        this.resultadoUso = resultadoUso;
    }


    public Prescripcion getPrescripcionidPrescripcion() {
        return prescripcionidPrescripcion;
    }

    public void setPrescripcionidPrescripcion(Prescripcion prescripcionidPrescripcion) {
        this.prescripcionidPrescripcion = prescripcionidPrescripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedicamento != null ? idMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicamento)) {
            return false;
        }
        Medicamento other = (Medicamento) object;
        if ((this.idMedicamento == null && other.idMedicamento != null) || (this.idMedicamento != null && !this.idMedicamento.equals(other.idMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.Medicamento[ idMedicamento=" + idMedicamento + " ]";
    }

    public Instruccionesingesta getInstruccionesIngestaidInstruccionesIngesta() {
        return instruccionesIngestaidInstruccionesIngesta;
    }

    public void setInstruccionesIngestaidInstruccionesIngesta(Instruccionesingesta instruccionesIngestaidInstruccionesIngesta) {
        this.instruccionesIngestaidInstruccionesIngesta = instruccionesIngestaidInstruccionesIngesta;
    }
    
}
