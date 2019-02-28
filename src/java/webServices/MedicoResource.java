/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServices;

import com.fasterxml.jackson.databind.ObjectMapper;
import dbAccess.Direcciontrabajo;
import dbAccess.Especialidad;
import dbAccess.Medico;
import dbAccess.Universidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utils.PasswordAuthentication;

/**
 * Sercivio web REST con utiles para el médico de la aplicación del expediente médico.
 *
 * @author Erick Montelongo
 */
@Path("MedicoResourse")
public class MedicoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RegistrarMedicoResource
     */
    public MedicoResource() {
    }

    /**
     * Obtiene la representación JSON de un objeto Médico a través de su ID.
     * @param id cédula profesional del médico.
     * @return Una cadena JSON que representa un objeto de tipo Medico.
     */
    @GET
    @Path("/medByID")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMedicoByID(@QueryParam("id") int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExpedienteMedicoTomcatPU");
        EntityManager em = emf.createEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        try{
        Medico med = (Medico) em.createNamedQuery("Medico.findByIdMedico").setParameter("idMedico", id).getSingleResult();
        String res = mapper.writeValueAsString(med);
        return res;
        }
        catch(Exception e){
            e.printStackTrace();
            return "Problema";
        }
    }
    /**
     * Método que obtiene la lista de todos los médicos registrados en la aplicación.
     * @return Cadena JSON que representa una lista de objetos de tipo Medico.
     */
    @GET
    @Path("/allMedicos")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllMedicos(){
        String res = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExpedienteMedicoTomcatPU");
        EntityManager em = emf.createEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        try{
        List<Medico> medicos = em.createNamedQuery("Medico.findAll").getResultList();
        res = mapper.writeValueAsString(medicos);
        return res;
        }
        catch(Exception e){
            return res;
        }
    }
    


    /**
     * Método que recibe un objeto JSON que representa un Medico para ser guardado en la base de datos.
     * @param content Cadena JSON que representa el objeto Medico.
     * @return Objeto Response con el código HTTP correspondiente.
     */
    @POST
    @Path("/registraMedico")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registraMedico(String content) {
        ObjectMapper mapper = new ObjectMapper();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExpedienteMedicoTomcatPU");
        EntityManager em = emf.createEntityManager();
        PasswordAuthentication pass = new PasswordAuthentication();
        try{
        Medico med = mapper.readValue(content, Medico.class);
        String hash = pass.hash(med.getPassword().toCharArray());
        med.setPassword(hash);
        Direcciontrabajo direccion = med.getDireccionTrabajoidDireccionTrabajo();
        Especialidad especialidad = med.getEspecialidadidEspecialidad();
        Universidad universidad = med.getUniversidadidUniversidad();
        direccion.setIdDireccionTrabajo(null);
        especialidad.setIdEspecialidad(null);
        universidad.setIdUniversidad(null);
        em.getTransaction().begin();
        em.persist(direccion);
        em.persist(especialidad);
        em.persist(universidad);
        em.flush();
        em.persist(med);
        em.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.status(Response.Status.OK).build();
    }
}
