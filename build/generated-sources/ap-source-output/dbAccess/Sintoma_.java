package dbAccess;

import dbAccess.Descripcionsintoma;
import dbAccess.Paciente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-16T16:52:02")
@StaticMetamodel(Sintoma.class)
public class Sintoma_ { 

    public static volatile SingularAttribute<Sintoma, Integer> idSintoma;
    public static volatile SingularAttribute<Sintoma, Date> fechaInicio;
    public static volatile SingularAttribute<Sintoma, Descripcionsintoma> descripcionSintomaidDescripcionSintoma;
    public static volatile SingularAttribute<Sintoma, Date> dateFin;
    public static volatile SingularAttribute<Sintoma, Date> fechaFin;
    public static volatile SingularAttribute<Sintoma, String> nombre;
    public static volatile SingularAttribute<Sintoma, Paciente> pacientecurp;
    public static volatile SingularAttribute<Sintoma, Date> dateInicio;

}