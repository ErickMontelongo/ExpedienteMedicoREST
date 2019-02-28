package dbAccess;

import dbAccess.Medico;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-16T16:52:02")
@StaticMetamodel(Direcciontrabajo.class)
public class Direcciontrabajo_ { 

    public static volatile SingularAttribute<Direcciontrabajo, String> estado;
    public static volatile SingularAttribute<Direcciontrabajo, String> numeroTel;
    public static volatile SingularAttribute<Direcciontrabajo, String> codigoPostal;
    public static volatile SingularAttribute<Direcciontrabajo, String> municipio;
    public static volatile SingularAttribute<Direcciontrabajo, String> consultorio;
    public static volatile SingularAttribute<Direcciontrabajo, String> calle;
    public static volatile CollectionAttribute<Direcciontrabajo, Medico> medicoCollection;
    public static volatile SingularAttribute<Direcciontrabajo, String> nombreEmpresa;
    public static volatile SingularAttribute<Direcciontrabajo, Integer> idDireccionTrabajo;
    public static volatile SingularAttribute<Direcciontrabajo, String> colonia;

}