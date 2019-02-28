package dbAccess;

import dbAccess.Direcciontrabajo;
import dbAccess.Especialidad;
import dbAccess.MedicoHasPaciente;
import dbAccess.Universidad;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-16T16:52:02")
@StaticMetamodel(Medico.class)
public class Medico_ { 

    public static volatile SingularAttribute<Medico, String> password;
    public static volatile SingularAttribute<Medico, String> apellidoP;
    public static volatile CollectionAttribute<Medico, MedicoHasPaciente> medicoHasPacienteCollection;
    public static volatile SingularAttribute<Medico, Integer> idMedico;
    public static volatile SingularAttribute<Medico, String> apellidoM;
    public static volatile SingularAttribute<Medico, Universidad> universidadidUniversidad;
    public static volatile SingularAttribute<Medico, Especialidad> especialidadidEspecialidad;
    public static volatile SingularAttribute<Medico, String> nombre;
    public static volatile SingularAttribute<Medico, Direcciontrabajo> direccionTrabajoidDireccionTrabajo;

}