/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbAccess;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Punkid PC
 */
@Entity
@Table(name = "sintoma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sintoma.findAll", query = "SELECT s FROM Sintoma s")
    , @NamedQuery(name = "Sintoma.findByIdSintoma", query = "SELECT s FROM Sintoma s WHERE s.idSintoma = :idSintoma")
    , @NamedQuery(name = "Sintoma.findByFechaInicio", query = "SELECT s FROM Sintoma s WHERE s.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Sintoma.findByFechaFin", query = "SELECT s FROM Sintoma s WHERE s.fechaFin = :fechaFin")
    , @NamedQuery(name = "Sintoma.findByDateInicio", query = "SELECT s FROM Sintoma s WHERE s.dateInicio = :dateInicio")
    , @NamedQuery(name = "Sintoma.findByDateFin", query = "SELECT s FROM Sintoma s WHERE s.dateFin = :dateFin")
    , @NamedQuery(name = "Sintoma.findByNombre", query = "SELECT s FROM Sintoma s WHERE s.nombre = :nombre")})
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "idSintoma")
public class Sintoma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSintoma")
    private Integer idSintoma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "DescripcionSintoma_idDescripcionSintoma", referencedColumnName = "idDescripcionSintoma")
    @ManyToOne(optional = false)
    private Descripcionsintoma descripcionSintomaidDescripcionSintoma;
    @JoinColumn(name = "Paciente_curp", referencedColumnName = "curp")
    @ManyToOne(optional = false)
    //@JsonBackReference(value="sintomas")
    private Paciente pacientecurp;

    public Sintoma() {
    }

    public Sintoma(Integer idSintoma) {
        this.idSintoma = idSintoma;
    }

    public Sintoma(Integer idSintoma, Date fechaInicio, Date fechaFin, Date dateInicio, Date dateFin, String nombre) {
        this.idSintoma = idSintoma;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.dateInicio = dateInicio;
        this.dateFin = dateFin;
        this.nombre = nombre;
    }

    public Integer getIdSintoma() {
        return idSintoma;
    }

    public void setIdSintoma(Integer idSintoma) {
        this.idSintoma = idSintoma;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getDateInicio() {
        return dateInicio;
    }

    public void setDateInicio(Date dateInicio) {
        this.dateInicio = dateInicio;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Descripcionsintoma getDescripcionSintomaidDescripcionSintoma() {
        return descripcionSintomaidDescripcionSintoma;
    }

    public void setDescripcionSintomaidDescripcionSintoma(Descripcionsintoma descripcionSintomaidDescripcionSintoma) {
        this.descripcionSintomaidDescripcionSintoma = descripcionSintomaidDescripcionSintoma;
    }

    public Paciente getPacientecurp() {
        return pacientecurp;
    }

    public void setPacientecurp(Paciente pacientecurp) {
        this.pacientecurp = pacientecurp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSintoma != null ? idSintoma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sintoma)) {
            return false;
        }
        Sintoma other = (Sintoma) object;
        if ((this.idSintoma == null && other.idSintoma != null) || (this.idSintoma != null && !this.idSintoma.equals(other.idSintoma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbAccess.Sintoma[ idSintoma=" + idSintoma + " ]";
    }
    
}
