package unam.dgtic.diplomado.core.wsejb2.ws.api;

import jakarta.ejb.EJB;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import unam.dgtic.diplomado.core.wsejb2.ejb.ServicioPersona;

@Path("/api")
public class WSRestApp {

    @EJB
    private ServicioPersona service;

    @Path("/personas")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response personas() {
        return Response.ok().entity(service.cargaPersonas()).build();
    }
}
