package dbAccess;

import dbAccess.Historiaclinica;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-16T16:52:02")
@StaticMetamodel(Informacionpersonal.class)
public class Informacionpersonal_ { 

    public static volatile SingularAttribute<Informacionpersonal, Date> fechaNac;
    public static volatile SingularAttribute<Informacionpersonal, Boolean> transfuciones;
    public static volatile SingularAttribute<Informacionpersonal, String> tipoSangre;
    public static volatile SingularAttribute<Informacionpersonal, Float> altura;
    public static volatile SingularAttribute<Informacionpersonal, Float> peso;
    public static volatile SingularAttribute<Informacionpersonal, Integer> idInformacionPersonal;
    public static volatile SingularAttribute<Informacionpersonal, String> sexo;
    public static volatile CollectionAttribute<Informacionpersonal, Historiaclinica> historiaclinicaCollection;

}