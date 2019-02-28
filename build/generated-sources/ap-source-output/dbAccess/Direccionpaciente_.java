package dbAccess;

import dbAccess.Paciente;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-16T16:52:02")
@StaticMetamodel(Direccionpaciente.class)
public class Direccionpaciente_ { 

    public static volatile SingularAttribute<Direccionpaciente, Integer> idDireccionPaciente;
    public static volatile SingularAttribute<Direccionpaciente, String> estado;
    public static volatile SingularAttribute<Direccionpaciente, String> numeroTel;
    public static volatile SingularAttribute<Direccionpaciente, String> codigoPostal;
    public static volatile SingularAttribute<Direccionpaciente, String> municipio;
    public static volatile SingularAttribute<Direccionpaciente, String> calle;
    public static volatile CollectionAttribute<Direccionpaciente, Paciente> pacienteCollection;
    public static volatile SingularAttribute<Direccionpaciente, String> colonia;

}