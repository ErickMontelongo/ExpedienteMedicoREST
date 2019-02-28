package dbAccess;

import dbAccess.Historiaclinica;
import dbAccess.Resumencirugia;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-16T16:52:02")
@StaticMetamodel(Cirugias.class)
public class Cirugias_ { 

    public static volatile SingularAttribute<Cirugias, Date> fecha;
    public static volatile SingularAttribute<Cirugias, Historiaclinica> historiaClinicaidHistoriaClinica;
    public static volatile SingularAttribute<Cirugias, String> clinica;
    public static volatile SingularAttribute<Cirugias, Integer> idCirugias;
    public static volatile CollectionAttribute<Cirugias, Resumencirugia> resumencirugiaCollection;
    public static volatile SingularAttribute<Cirugias, String> nombreOperacion;

}