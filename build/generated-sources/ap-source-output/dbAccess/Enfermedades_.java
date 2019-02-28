package dbAccess;

import dbAccess.Historiaclinica;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-16T16:52:02")
@StaticMetamodel(Enfermedades.class)
public class Enfermedades_ { 

    public static volatile SingularAttribute<Enfermedades, Historiaclinica> historiaClinicaidHistoriaClinica;
    public static volatile SingularAttribute<Enfermedades, Integer> idEnfermedades;
    public static volatile SingularAttribute<Enfermedades, String> nombre;
    public static volatile SingularAttribute<Enfermedades, Date> fechaDiagnostico;
    public static volatile SingularAttribute<Enfermedades, String> tratamiento;

}