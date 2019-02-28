package dbAccess;

import dbAccess.Archivosmedicos;
import dbAccess.Historiaclinica;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-16T16:52:02")
@StaticMetamodel(Hospitalizacion.class)
public class Hospitalizacion_ { 

    public static volatile SingularAttribute<Hospitalizacion, Date> fechaIngreso;
    public static volatile CollectionAttribute<Hospitalizacion, Archivosmedicos> archivosmedicosCollection;
    public static volatile SingularAttribute<Hospitalizacion, String> causa;
    public static volatile SingularAttribute<Hospitalizacion, Historiaclinica> historiaClinicaidHistoriaClinica;
    public static volatile SingularAttribute<Hospitalizacion, String> clinica;
    public static volatile SingularAttribute<Hospitalizacion, Date> fechaSalida;
    public static volatile SingularAttribute<Hospitalizacion, Integer> idHospitalizacion;

}