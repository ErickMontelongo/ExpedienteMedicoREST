package dbAccess;

import dbAccess.Medico;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-16T16:52:02")
@StaticMetamodel(Universidad.class)
public class Universidad_ { 

    public static volatile SingularAttribute<Universidad, String> clave;
    public static volatile SingularAttribute<Universidad, Integer> idUniversidad;
    public static volatile CollectionAttribute<Universidad, Medico> medicoCollection;
    public static volatile SingularAttribute<Universidad, String> nombre;

}