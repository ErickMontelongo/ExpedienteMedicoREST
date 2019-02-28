package dbAccess;

import dbAccess.Historiaclinica;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-16T16:52:02")
@StaticMetamodel(Vacunas.class)
public class Vacunas_ { 

    public static volatile SingularAttribute<Vacunas, Date> fecha;
    public static volatile SingularAttribute<Vacunas, Historiaclinica> historiaClinicaidHistoriaClinica;
    public static volatile SingularAttribute<Vacunas, Integer> idVacunas;
    public static volatile SingularAttribute<Vacunas, String> nombre;

}