package mx.unam.diplomado.ws;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mx.unam.diplomado.pojo.DataPojo;
import mx.unam.diplomado.xml.XMLCreatorData;

@Path("/actions")
public class WSDemoEndPoint {

    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service online").build();
    }
    
    @GET
    @Path("/xml")
    @Produces(MediaType.APPLICATION_XML)
    public String xml() {
    	DataPojo data = new DataPojo();
    	data.setId(3);
    	data.setMessage("This is a message from WS Restful");
    	return XMLCreatorData.createBasicXML(data);
    }
    
    @GET
    @Path("/xmlobject")
    @Produces(MediaType.APPLICATION_XML)
    public DataPojo xml2() {
    	return new DataPojo(2, "test message", "true");
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNotification(@PathParam("id") int id) {
        return Response.ok()
                .entity(new DataPojo(id, "test message", "true"))
                .build();
    }

    @POST
    @Path("/post/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postNotification(DataPojo notification) {
        return Response.status(201).entity(notification).build();
    }
}
