package dgtic.core.proyecto6.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dgtic.core.proyecto6.persistencia.dao.interfaces.ViajesDAO;
import dgtic.core.proyecto6.persistencia.modelo.viaje.Viaje;

@CrossOrigin(origins = "*")
@RestController
public class MicroserviciosViaje {

    @Autowired
    private ViajesDAO viajeDAO;

    @GetMapping(value = "/viajes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Viaje> consultaViaje() {
        return viajeDAO.consultaViajes();
    }

    @DeleteMapping(value = "borrarViaje/{idViaje}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminarViaje(@PathVariable("idViaje") String idViaje) {
        viajeDAO.borrarViaje(viajeDAO.consultaIdViaje(Integer.parseInt(idViaje)));
    }

    @PutMapping(value = "/cambiarViaje", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void cambiartipoTourDao(@RequestBody Viaje viajeNuevo) {
        viajeDAO.cambiarViaje(viajeNuevo);
    }

    @PostMapping(value = "/nuevoViaje", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void nuevotipoTourDao(@RequestBody Viaje viajeNuevo) {
        viajeDAO.insertarViaje(viajeNuevo);
    }
}
