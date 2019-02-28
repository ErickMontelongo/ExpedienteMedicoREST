package dbAccess;

import dbAccess.Instruccionesingesta;
import dbAccess.Prescripcion;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-16T16:52:02")
@StaticMetamodel(Medicamento.class)
public class Medicamento_ { 

    public static volatile SingularAttribute<Medicamento, Integer> idMedicamento;
    public static volatile SingularAttribute<Medicamento, String> concentracion;
    public static volatile SingularAttribute<Medicamento, String> reaccionesAdversas;
    public static volatile SingularAttribute<Medicamento, String> nombreGenerico;
    public static volatile SingularAttribute<Medicamento, Prescripcion> prescripcionidPrescripcion;
    public static volatile SingularAttribute<Medicamento, Instruccionesingesta> instruccionesIngestaidInstruccionesIngesta;
    public static volatile SingularAttribute<Medicamento, String> resultadoUso;
    public static volatile SingularAttribute<Medicamento, String> viaAdministracion;
    public static volatile SingularAttribute<Medicamento, String> nombreComercial;
    public static volatile SingularAttribute<Medicamento, Boolean> alergia;
    public static volatile SingularAttribute<Medicamento, Boolean> activo;

}