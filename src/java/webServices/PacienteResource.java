/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServices;

import com.fasterxml.jackson.databind.ObjectMapper;
import dbAccess.Direccionpaciente;
import dbAccess.MedicoHasPaciente;
import dbAccess.Paciente;
import DataHolders.ShowPaciente;
import dbAccess.Estudiosmedicos;
import dbAccess.Historiaclinica;
import dbAccess.Prescripcion;
import dbAccess.Sintoma;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Servicios web REST para los pacientes del expediente médico.
 *
 * @author Erick Montelongo
 */
@Path("Paciente")
public class PacienteResource {

    @Context
    private UriInfo context;

    /**
     * Crea una nueva instancia de PacienteResource
     */
    public PacienteResource() {
    }

    /**
     * Obtiene una lista de tipo ShowPaciente en formato JSON correspondiente a los pacientes de un médico.
     * @param idMedico cédula profesional del médico
     * @return Un objeto Response que representa un código HTTP y una lista de objetos de tipo ShowPaciente en formato JSON.
     */
    
    @GET
    @Path("/getPacienteForShow/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPacientesForShow(@QueryParam("idMedico")String idMedico){
        String queryStr2 = "SELECT p1.medicoHasPacientePK.pacientecurp FROM MedicoHasPaciente AS p1 WHERE p1.medicoHasPacientePK.medicoidMedico="+Integer.valueOf(idMedico)+")";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExpedienteMedicoTomcatPU");
        EntityManager em = emf.createEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        List<ShowPaciente> pacientes = new ArrayList<>();
        try{
            Query result = em.createQuery(queryStr2);
            List<String> pac = result.getResultList();
            for(String s: pac){
                Paciente p = (Paciente) em.createNamedQuery("Paciente.findByCurp").setParameter("curp", s).getSingleResult();
                pacientes.add(new ShowPaciente(p.getCurp(), p.getNombre(), p.getApellidoP(), p.getApellidoM()));
            }
            if(!pacientes.isEmpty()){
                String json = mapper.writeValueAsString(pacientes);
                return Response.status(Response.Status.OK).entity(json).build();
            }
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        catch(Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * Método que obtiene un objeto Paciente en base a su ID.
     * @param id curp de un paciente.
     * @return Objeto Response que tiene un codigo HTTP y una cadena JSON que representa el objeto Paciente.
     */
    @GET
    @Path("/getByIdPaciente/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPacienteByID(@QueryParam("id") String id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExpedienteMedicoTomcatPU");
        EntityManager em = emf.createEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        try{
        Paciente paciente = (Paciente) em.createNamedQuery("Paciente.findByCurp").setParameter("curp", id).getSingleResult();
        if(paciente!=null){
            String res = mapper.writeValueAsString(paciente);
            return Response.status(Response.Status.OK).entity(res).build();
        }
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        catch(Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * Método para registrar los permisos en una relación médico - paciente.
     * @param content Cadena JSON que representa un objeto MedicoHasPaciente para ingresar los permisos de visualización.
     */
    @PUT
    @Path("/registraPermisos/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void registraVisualizacion(String content){
        ObjectMapper mapper = new ObjectMapper();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExpedienteMedicoTomcatPU");
        EntityManager em = emf.createEntityManager();
        try{
            MedicoHasPaciente permisos = mapper.readValue(content, MedicoHasPaciente.class);
            em.getTransaction().begin();
            em.persist(permisos);
            em.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
    
    /**
     * Método que obtiene los ID y permisos de los pacientes asignados a un médico.
     * @param idMedico cédula profesional que identifica a un médico.
     * @return Objeto Response que representa un código HTTP y una lista de objetos MedicoHasPaciente en formato JSON.
     */
    @GET
    @Path("/getPacientesByIdMedico/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPacienteByIdMedico(@QueryParam("idMedico") String idMedico){
        ObjectMapper mapper = new ObjectMapper();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExpedienteMedicoTomcatPU");
        EntityManager em = emf.createEntityManager();
        try{
            List<MedicoHasPaciente> medicoPaciente = (List<MedicoHasPaciente>)em.createNamedQuery("MedicoHasPaciente.findByMedicoidMedico").setParameter("medicoidMedico", Integer.valueOf(idMedico)).getResultList();
            String respuesta = mapper.writeValueAsString(medicoPaciente);
            if(!medicoPaciente.isEmpty()){
                return Response.status(Response.Status.OK).entity(respuesta).build();
            }
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        catch(Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            
        }
    }

    /**
     * Método para registrar en la base de datos a un paciente.
     * @param content Cadena JSON que representa a un objeto Paciente.
     */
    @PUT
    @Path("/registraPaciente/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void registraPaciente(String content) {
        ObjectMapper mapper = new ObjectMapper();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExpedienteMedicoTomcatPU");
        EntityManager em = emf.createEntityManager();
        try{
            Paciente paciente = mapper.readValue(content, Paciente.class);
            Direccionpaciente direccion = paciente.getDireccionPacienteidDireccionPaciente();
            direccion.setIdDireccionPaciente(null);
            em.getTransaction().begin();
            em.persist(direccion);
            em.flush();
            em.persist(paciente);
            em.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
    
    /**
     * Método para agregar un síntoma a un paciente.
     * @param idPaciente curp del paciente.
     * @param content cadena JSON que reperesenta al objeto Sintoma.
     * @return Objeto Response con el código HTTP resultante de la operación.
     */
    @PUT
    @Path("/agregarSintoma/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response agregarSintoma(@QueryParam("id") String idPaciente, String content){
        ObjectMapper mapper = new ObjectMapper();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExpedienteMedicoTomcatPU");
        EntityManager em = emf.createEntityManager();
        try{
            Paciente paciente = em.getReference(Paciente.class, idPaciente);
            Sintoma sintoma = mapper.readValue(content, Sintoma.class);
            if(paciente!=null){
                em.getTransaction().begin();
                sintoma.setPacientecurp(paciente);
                em.persist(sintoma);
                em.getTransaction().commit();
                return Response.status(Response.Status.OK).build();
            }
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    
    /**
     * Método para agregar un estudio de laboratorio a un paciente.
     * @param idPaciente curp del paciente.
     * @param content cadena JSON que representa al objeto Estudiosmedicos
     * @return Objeto Response con el código HTTP resultante de la operación.
     */
    @PUT
    @Path("/agregarEstudio/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response agregarEstudio(@QueryParam("id") String idPaciente, String content){
        ObjectMapper mapper = new ObjectMapper();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExpedienteMedicoTomcatPU");
        EntityManager em = emf.createEntityManager();
        try{
            Paciente paciente = em.getReference(Paciente.class, idPaciente);
            Estudiosmedicos estudio = mapper.readValue(content, Estudiosmedicos.class);
            if(paciente!=null){
                em.getTransaction().begin();
                estudio.setPacientecurp(paciente);
                em.persist(estudio);
                em.getTransaction().commit();
                return Response.status(Response.Status.OK).build();
            }
            
           return Response.status(Response.Status.BAD_REQUEST).build();
        }
        catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    
    /**
     * Método que agrega una prescripción a un paciente
     * @param idPaciente curp del paciente.
     * @param content cadena JSON que representa al objeto Prescripcion
     * @return Objeto Response con el código HTTP resultante de la operación.
     */
    @PUT
    @Path("/agregarPrescripcion/")
    @Consumes (MediaType.APPLICATION_JSON)
    public Response agregarPrescripcion(@QueryParam("id") String idPaciente, String content){
        ObjectMapper mapper = new ObjectMapper();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExpedienteMedicoTomcatPU");
        EntityManager em = emf.createEntityManager();
        try{
            Paciente paciente = em.getReference(Paciente.class, idPaciente);
            Prescripcion prescripcion = mapper.readValue(content, Prescripcion.class);
            if(paciente != null){
                em.getTransaction().begin();
                prescripcion.setPacientecurp(paciente);
                em.persist(prescripcion);
                em.getTransaction().commit();
                return Response.status(Response.Status.OK).build();
            }
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    
    /**
     * Método que agrega un historial clínico a un paciente.
     * @param idPaciente curp del paciente.
     * @param content cadena JSON que representa al objeto Historiaclinica del paciente.
     * @return Objeto Response con el código HTTP resultante de la operación.
     */
    @PUT
    @Path("/agregarHistorial/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response agregarHistorial(@QueryParam("id") String idPaciente, String content){
        ObjectMapper mapper = new ObjectMapper();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExpedienteMedicoTomcatPU");
        EntityManager em = emf.createEntityManager();
        try{
            Paciente paciente = em.getReference(Paciente.class, idPaciente);
            Historiaclinica historial = mapper.readValue(content, Historiaclinica.class);
            if(paciente != null){
                em.getTransaction().begin();
                em.persist(historial);
                em.flush();
                paciente.setHistoriaClinicaidHistoriaClinica(historial);
                em.getTransaction().commit();
                return Response.status(Response.Status.OK).build();
            }
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
