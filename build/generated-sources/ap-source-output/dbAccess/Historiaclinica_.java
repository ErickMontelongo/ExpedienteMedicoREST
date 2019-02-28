package dbAccess;

import dbAccess.Alergias;
import dbAccess.Antecedentes;
import dbAccess.Cirugias;
import dbAccess.Enfermedades;
import dbAccess.Hospitalizacion;
import dbAccess.Informacionpersonal;
import dbAccess.Paciente;
import dbAccess.Toxicomanias;
import dbAccess.Vacunas;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-16T16:52:02")
@StaticMetamodel(Historiaclinica.class)
public class Historiaclinica_ { 

    public static volatile CollectionAttribute<Historiaclinica, Toxicomanias> toxicomaniasCollection;
    public static volatile CollectionAttribute<Historiaclinica, Antecedentes> antecedentesCollection;
    public static volatile SingularAttribute<Historiaclinica, Informacionpersonal> informacionPersonalidInformacionPersonal;
    public static volatile CollectionAttribute<Historiaclinica, Hospitalizacion> hospitalizacionCollection;
    public static volatile CollectionAttribute<Historiaclinica, Alergias> alergiasCollection;
    public static volatile SingularAttribute<Historiaclinica, Integer> idHistoriaClinica;
    public static volatile CollectionAttribute<Historiaclinica, Vacunas> vacunasCollection;
    public static volatile CollectionAttribute<Historiaclinica, Paciente> pacienteCollection;
    public static volatile CollectionAttribute<Historiaclinica, Cirugias> cirugiasCollection;
    public static volatile CollectionAttribute<Historiaclinica, Enfermedades> enfermedadesCollection;

}