package dbAccess;

import dbAccess.Datosestudiosmedicos;
import dbAccess.Paciente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-16T16:52:02")
@StaticMetamodel(Estudiosmedicos.class)
public class Estudiosmedicos_ { 

    public static volatile SingularAttribute<Estudiosmedicos, Date> fechaEstudio;
    public static volatile SingularAttribute<Estudiosmedicos, Integer> idEstudiosMedicos;
    public static volatile SingularAttribute<Estudiosmedicos, String> rutaCarpetaImagenes;
    public static volatile SingularAttribute<Estudiosmedicos, String> rutaImagen;
    public static volatile SingularAttribute<Estudiosmedicos, Datosestudiosmedicos> datosEstudiosMedicosidDatosEstudiosMedicos;
    public static volatile SingularAttribute<Estudiosmedicos, Paciente> pacientecurp;

}