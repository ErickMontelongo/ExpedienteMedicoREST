/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServices;

import DataHolders.Permisos;
import com.fasterxml.jackson.databind.ObjectMapper;
import dbAccess.Medico;
import dbAccess.MedicoHasPaciente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
import utils.PasswordAuthentication;

/**
 * Conjunto de servicios web orientados a distintas operaciones utiles para el expediente médico.
 *
 * @author Erick Montelongo
 */

@Path("ExpedienteUtils")
public class ExpedienteUtilsResource {

    @Context
    private UriInfo context;

    /**
     * Crea una nueva instancia de ExpedienteUtilsResource
     */
    public ExpedienteUtilsResource() {
    }

    /**
     * Obtiene la representación de un objeto de tipo médico.
     * @param id cédula profesional del médico.
     * @param token contraseña ingresada por el médico.
     * @return En caso de que las credenciales coincidan, se obtiene una cadena JSON que representa un objeto de tipo Medico.
     * En caso contrario, se envia un código HTTP de error.
     */
    @GET
    @Path("/loginMedico")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginMedico(@QueryParam("id") String id, @QueryParam("pass") String token) {
        PasswordAuthentication autentifica = new PasswordAuthentication();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExpedienteMedicoTomcatPU");
        EntityManager em = emf.createEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        try{
            Medico med = (Medico) em.createNamedQuery("Medico.findByIdMedico").setParameter("idMedico", Integer.valueOf(id)).getSingleResult();
            if(autentifica.authenticate(token.toCharArray(), med.getPassword())){
                String res = mapper.writeValueAsString(med);
                return Response.status(Response.Status.OK).entity(res).build();
            }
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        catch(Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
    * Método que obtiene los permisos de visualización específicos de una relación médico - paciente.
    *@param id cédula profesional del médico.
    * @param curp curp del paciente.
    * @return En caso de que exista la relación se regresa una cadena JSON que representa un objeto Permisos.
    * En caso de que no exista dicha relación se envía un código HTTP de error.
    */
    @GET
    @Path("/getPermisos/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPermisos(@QueryParam("id") int id, @QueryParam("curp") String curp) {
        String res;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExpedienteMedicoTomcatPU");
        EntityManager em = emf.createEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        try{
            MedicoHasPaciente med = (MedicoHasPaciente) em.createNamedQuery("MedicoHasPaciente.findByBothid").setParameter("idMedico", id).setParameter("curp", curp).getSingleResult();
            if(med != null){
                Permisos permisos = new Permisos(med.getAppHistorial(), med.getAppMedicamentos(), med.getAppSintomas(), med.getAppEstudios());               
                return Response.status(Response.Status.OK).entity(mapper.writeValueAsString(permisos)).build();
            }
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        catch(Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
