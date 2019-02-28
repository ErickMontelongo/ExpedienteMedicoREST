package dbAccess;

import dbAccess.Sintoma;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-16T16:52:02")
@StaticMetamodel(Descripcionsintoma.class)
public class Descripcionsintoma_ { 

    public static volatile SingularAttribute<Descripcionsintoma, String> descripcion;
    public static volatile SingularAttribute<Descripcionsintoma, String> frecuencia;
    public static volatile SingularAttribute<Descripcionsintoma, String> intensidad;
    public static volatile SingularAttribute<Descripcionsintoma, Integer> idDescripcionSintoma;
    public static volatile CollectionAttribute<Descripcionsintoma, Sintoma> sintomaCollection;
    public static volatile SingularAttribute<Descripcionsintoma, String> regionEspecifica;
    public static volatile SingularAttribute<Descripcionsintoma, String> regionCuerpo;

}