package dbAccess;

import dbAccess.Historiaclinica;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-16T16:52:02")
@StaticMetamodel(Antecedentes.class)
public class Antecedentes_ { 

    public static volatile SingularAttribute<Antecedentes, String> causa;
    public static volatile SingularAttribute<Antecedentes, Historiaclinica> historiaClinicaidHistoriaClinica;
    public static volatile SingularAttribute<Antecedentes, String> familiar;
    public static volatile SingularAttribute<Antecedentes, Boolean> vivo;
    public static volatile SingularAttribute<Antecedentes, Integer> idAntecedentes;

}