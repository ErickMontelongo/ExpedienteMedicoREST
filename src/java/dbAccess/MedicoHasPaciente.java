/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbAccess;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Punkid PC
 */
@Entity
@Table(name = "medico_has_paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedicoHasPaciente.findAll", query = "SELECT m FROM MedicoHasPaciente m")
    , @NamedQuery(name = "MedicoHasPaciente.findByMedicoidMedico", query = "SELECT m FROM MedicoHasPaciente m WHERE m.medicoHasPacientePK.medicoidMedico = :medicoidMedico")
    , @NamedQuery(name = "MedicoHasPaciente.findByPacientecurp", query = "SELECT m FROM MedicoHasPaciente m WHERE m.medicoHasPacientePK.pacientecurp = :pacientecurp")
    , @NamedQuery(name = "MedicoHasPaciente.findByAppSintomas", query = "SELECT m FROM MedicoHasPaciente m WHERE m.appSintomas = :appSintomas")
    , @NamedQuery(name = "MedicoHasPaciente.findByAppEstudios", query = "SELECT m FROM MedicoHasPaciente m WHERE m.appEstudios = :appEstudios")
    , @NamedQuery(name = "MedicoHasPaciente.findByAppMedicamentos", query = "SELECT m FROM MedicoHasPaciente m WHERE m.appMedicamentos = :appMedicamentos")
    , @NamedQuery(name = "MedicoHasPaciente.findByAppHistorial", query = "SELECT m FROM MedicoHasPaciente m WHERE m.appHistorial = :appHistorial")
    , @NamedQuery(name = "MedicoHasPaciente.findByBothid", query = "SELECT m FROM MedicoHasPaciente m WHERE m.medicoHasPacientePK.medicoidMedico = :idMedico AND m.medicoHasPacientePK.pacientecurp = :curp")})
public class MedicoHasPaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MedicoHasPacientePK medicoHasPacientePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "appSintomas")
    private boolean appSintomas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "appEstudios")
    private boolean appEstudios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "appMedicamentos")
    private boolean appMedicamentos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "appHistorial")
    private boolean appHistorial;
    @JoinColumn(name = "Medico_idMedico", referencedColumnName = "idMedico", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonBackReference(value="medicoPaciente")
    private Medico medico;
    @JoinColumn(name = "Paciente_curp", referencedColumnName = "curp", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonBackReference(value="pacienteMedico")
    private Paciente paciente;

    public MedicoHasPaciente() {
    }

    public MedicoHasPaciente(MedicoHasPacientePK medicoHasPacientePK) {
        this.medicoHasPacientePK = medicoHasPacientePK;
    }

    public MedicoHasPaciente(MedicoHasPacientePK medicoHasPacientePK, boolean appSintomas, boolean appEstudios, boolean appMedicamentos, boolean appHistorial) {
        this.medicoHasPacientePK = medicoHasPacientePK;
        this.appSintomas = appSintomas;
        this.appEstudios = appEstudios;
        this.appMedicamentos = appMedicamentos;
        this.appHistorial = appHistorial;
    }

    public MedicoHasPaciente(int medicoidMedico, String pacientecurp) {
        this.medicoHasPacientePK = new MedicoHasPacientePK(medicoidMedico, pacientecurp);
    }

    public MedicoHasPacientePK getMedicoHasPacientePK() {
        return medicoHasPacientePK;
    }

    public void setMedicoHasPacientePK(MedicoHasPacientePK medicoHasPacientePK) {
        this.medicoHasPacientePK = medicoHasPacientePK;
    }

    public boolean getAppSintomas() {
        return appSintomas;
    }

    public void setAppSintomas(boolean appSintomas) {
        this.appSintomas = appSintomas;
    }

    public boolean getAppEstudios() {
        return appEstudios;
    }

    public void setAppEstudios(boolean appEstudios) {
        this.appEstudios = appEstudios;
    }

    public boolean getAppMedicamentos() {
        return appMedicamentos;
    }

    public void setAppMedicamentos(boolean appMedicamentos) {
        this.appMedicamentos = appMedicamentos;
    }

    public boolean getAppHistorial() {
        return appHistorial;
    }

    public void setAppHistorial(boolean appHistorial) {
        this.appHistorial = appHistorial;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicoHasPacientePK != null ? medicoHasPacientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicoHasPaciente)) {
            return false;
        }
        MedicoHasPaciente other = (MedicoHasPaciente) object;
        if ((this.medicoHasPacientePK == null && other.medicoHasPacientePK != null) || (this.medicoHasPacientePK != null && !this.medicoHasPacientePK.equals(other.medicoHasPacientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.MedicoHasPaciente[ medicoHasPacientePK=" + medicoHasPacientePK + " ]";
    }
    
}
