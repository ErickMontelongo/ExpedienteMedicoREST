package dbAccess;

import dbAccess.Direccionpaciente;
import dbAccess.Estudiosmedicos;
import dbAccess.Historiaclinica;
import dbAccess.MedicoHasPaciente;
import dbAccess.Prescripcion;
import dbAccess.Sintoma;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-16T16:52:02")
@StaticMetamodel(Paciente.class)
public class Paciente_ { 

    public static volatile CollectionAttribute<Paciente, Prescripcion> prescripcionCollection;
    public static volatile SingularAttribute<Paciente, Direccionpaciente> direccionPacienteidDireccionPaciente;
    public static volatile SingularAttribute<Paciente, String> password;
    public static volatile SingularAttribute<Paciente, Historiaclinica> historiaClinicaidHistoriaClinica;
    public static volatile CollectionAttribute<Paciente, Estudiosmedicos> estudiosmedicosCollection;
    public static volatile SingularAttribute<Paciente, String> apellidoP;
    public static volatile CollectionAttribute<Paciente, MedicoHasPaciente> medicoHasPacienteCollection;
    public static volatile CollectionAttribute<Paciente, Sintoma> sintomaCollection;
    public static volatile SingularAttribute<Paciente, String> apellidoM;
    public static volatile SingularAttribute<Paciente, String> nombre;
    public static volatile SingularAttribute<Paciente, String> curp;

}