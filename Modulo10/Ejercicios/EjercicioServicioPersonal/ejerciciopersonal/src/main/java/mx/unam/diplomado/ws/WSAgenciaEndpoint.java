package mx.unam.diplomado.ws;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mx.unam.diplomado.pojo.AgenciaPojo;
import mx.unam.diplomado.xml.XMLCreatorData;

@Path("/agencia")
public class WSAgenciaEndpoint {

    @GET
    @Path("/xml")
    @Produces(MediaType.APPLICATION_XML)
    public String xmlAgencia() {
        AgenciaPojo agencia = new AgenciaPojo();
        agencia.setIdAgencia(1);
        agencia.setNombreAgencia("Agencia 1");
        agencia.setUbicacion("Ciudad de México");

        return XMLCreatorData.createBasicXML(agencia);
    }

    @GET
    @Path("/getAgencia/{idAgencia}")
    @Produces
    public Response getAgencia(@PathParam("idAgencia") Integer idAgencia) {
        return Response.ok().entity(new AgenciaPojo(1, "Agencia1", "Ciudad de México")).build();
    }

    @POST
    @Path("/postAgencia")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postAgencia(AgenciaPojo agencia) {
        return Response.status(201).entity(agencia).build();
    }

    @DELETE
    @Path("/borrarAgencia/{idAgencia}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAgencia(@PathParam("idAgencia") Integer idAgencia) {
        if (idAgencia == 1) {
            return Response.status(200).entity("Agencia borrada").build();
        } else {
            return Response.status(200).entity("Agencia no borrada").build();
        }
    }
}
