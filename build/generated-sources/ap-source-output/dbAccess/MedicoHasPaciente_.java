package dbAccess;

import dbAccess.Medico;
import dbAccess.MedicoHasPacientePK;
import dbAccess.Paciente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-16T16:52:02")
@StaticMetamodel(MedicoHasPaciente.class)
public class MedicoHasPaciente_ { 

    public static volatile SingularAttribute<MedicoHasPaciente, Boolean> appEstudios;
    public static volatile SingularAttribute<MedicoHasPaciente, Boolean> appMedicamentos;
    public static volatile SingularAttribute<MedicoHasPaciente, Boolean> appHistorial;
    public static volatile SingularAttribute<MedicoHasPaciente, Paciente> paciente;
    public static volatile SingularAttribute<MedicoHasPaciente, Medico> medico;
    public static volatile SingularAttribute<MedicoHasPaciente, Boolean> appSintomas;
    public static volatile SingularAttribute<MedicoHasPaciente, MedicoHasPacientePK> medicoHasPacientePK;

}