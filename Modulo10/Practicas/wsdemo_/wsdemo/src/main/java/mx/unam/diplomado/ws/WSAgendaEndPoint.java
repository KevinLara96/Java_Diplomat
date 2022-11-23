package mx.unam.diplomado.ws;



import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mx.unam.tic.diplomado.agenda.servicios.ServiciosCatalogos;
import mx.unam.tic.diplomado.agenda.servicios.ServiciosCatalogosImpl;
import mx.unam.tic.diplomado.agenda.servicios.ServiciosContactos;
import mx.unam.tic.diplomado.agenda.servicios.ServiciosContactosImpl;

@Path("/agenda")
public class WSAgendaEndPoint {
	
	
	
	@GET
	@Path("/catalogo/tipocontacto")
	@Produces(MediaType.APPLICATION_JSON)
	public Response cargaTipoContactoCatalog() {
		ServiciosCatalogos catalogosService = ServiciosCatalogosImpl.getInstance();
		return Response.ok().entity(catalogosService.cargaTiposContacto()).build();
	}
	
	
	@GET
	@Path("/catalogo/tipomediocontacto")
	@Produces(MediaType.APPLICATION_JSON)
	public Response cargaTipoMedioCatalog() {
		ServiciosCatalogos catalogosService = ServiciosCatalogosImpl.getInstance();
		return Response.ok().entity(catalogosService.cargaMediosContacto()).build();
	}
	
	
	@GET
	@Path("/catalogo/contacto")
	@Produces(MediaType.APPLICATION_JSON)
	public Response cargaContactos() {
		ServiciosContactos contactosService = ServiciosContactosImpl.getInstance();
		return Response.ok().entity(contactosService.cargaContactos()).build();
	}
}
