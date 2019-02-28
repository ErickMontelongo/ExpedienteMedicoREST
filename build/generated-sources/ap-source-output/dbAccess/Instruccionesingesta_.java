package dbAccess;

import dbAccess.Medicamento;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-16T16:52:02")
@StaticMetamodel(Instruccionesingesta.class)
public class Instruccionesingesta_ { 

    public static volatile SingularAttribute<Instruccionesingesta, String> frecuencia;
    public static volatile SingularAttribute<Instruccionesingesta, String> domingo;
    public static volatile SingularAttribute<Instruccionesingesta, String> miercoles;
    public static volatile SingularAttribute<Instruccionesingesta, String> martes;
    public static volatile SingularAttribute<Instruccionesingesta, String> jueves;
    public static volatile CollectionAttribute<Instruccionesingesta, Medicamento> medicamentoCollection;
    public static volatile SingularAttribute<Instruccionesingesta, String> duracion;
    public static volatile SingularAttribute<Instruccionesingesta, String> sabado;
    public static volatile SingularAttribute<Instruccionesingesta, String> lunes;
    public static volatile SingularAttribute<Instruccionesingesta, String> viernes;
    public static volatile SingularAttribute<Instruccionesingesta, Integer> idInstruccionesIngesta;

}