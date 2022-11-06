package mx.unam.diplomado.ws;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mx.unam.diplomado.pojo.TemperaturaPojo;

@Path("/endpoints")
public class Endpoints {

    @GET
    @Path("/fecha")
    public Response getFecha() {
        DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = date.format(new Date());

        return Response.ok(fecha).type(MediaType.TEXT_PLAIN).build();
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postNotification(TemperaturaPojo tmp) {
        Double cent = (tmp.getFarenheit() - 32) / 1.8;
        Double far = (tmp.getCentigrados() * 1.8) + 32;

        tmp.setCentigrados(cent);
        tmp.setFarenheit(far);
        return Response.status(201).entity(tmp).build();
    }
}
