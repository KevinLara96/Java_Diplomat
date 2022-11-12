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

import dgtic.core.proyecto6.persistencia.dao.interfaces.TipoViajeDAO;
import dgtic.core.proyecto6.persistencia.modelo.viaje.TipoViaje;

@CrossOrigin(origins = "*")
@RestController
public class MicroServiciosTipoViaje {

    @Autowired
    private TipoViajeDAO tipoViajeDAO;

    @GetMapping(value = "/tipoViaje", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TipoViaje> consultaTipoViaje() {
        return tipoViajeDAO.consultaTipoViaje();
    }

    @DeleteMapping(value = "borrarTipoViaje/{idTipoViaje}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminarTipoViaje(@PathVariable("idTipoViaje") String idTipoViaje) {
        tipoViajeDAO.borrarTipoViaje(tipoViajeDAO.consultaIdTipoViaje(Integer.parseInt(idTipoViaje)));
    }

    @PutMapping(value = "/cambiarTipoViaje", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void cambiartipoTourDao(@RequestBody TipoViaje tipoViajeNuevo) {
        tipoViajeDAO.cambiarTipoViaje(tipoViajeNuevo);
    }

    @PostMapping(value = "/nuevoTipoViaje", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void nuevotipoTourDao(@RequestBody TipoViaje tipoViajeNuevo) {
        tipoViajeDAO.insertarTipoViaje(tipoViajeNuevo);
    }
}
