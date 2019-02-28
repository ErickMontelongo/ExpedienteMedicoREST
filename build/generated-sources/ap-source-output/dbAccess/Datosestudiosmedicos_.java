package dbAccess;

import dbAccess.Estudiosmedicos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-16T16:52:02")
@StaticMetamodel(Datosestudiosmedicos.class)
public class Datosestudiosmedicos_ { 

    public static volatile SingularAttribute<Datosestudiosmedicos, Integer> idDatosEstudiosMedicos;
    public static volatile SingularAttribute<Datosestudiosmedicos, String> categoriaEstudio;
    public static volatile CollectionAttribute<Datosestudiosmedicos, Estudiosmedicos> estudiosmedicosCollection;
    public static volatile SingularAttribute<Datosestudiosmedicos, String> nombreEstudio;
    public static volatile SingularAttribute<Datosestudiosmedicos, String> nombreMedico;
    public static volatile SingularAttribute<Datosestudiosmedicos, String> nombreClinica;
    public static volatile SingularAttribute<Datosestudiosmedicos, String> interpretacion;

}