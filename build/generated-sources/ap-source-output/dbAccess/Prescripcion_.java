package dbAccess;

import dbAccess.Medicamento;
import dbAccess.Paciente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-16T16:52:02")
@StaticMetamodel(Prescripcion.class)
public class Prescripcion_ { 

    public static volatile SingularAttribute<Prescripcion, Date> fecha;
    public static volatile SingularAttribute<Prescripcion, Integer> cedula;
    public static volatile SingularAttribute<Prescripcion, String> medico;
    public static volatile CollectionAttribute<Prescripcion, Medicamento> medicamentoCollection;
    public static volatile SingularAttribute<Prescripcion, Paciente> pacientecurp;
    public static volatile SingularAttribute<Prescripcion, Integer> idPrescripcion;

}