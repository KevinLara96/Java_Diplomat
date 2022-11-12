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

import dgtic.core.proyecto6.persistencia.dao.interfaces.TipoTourDAO;
import dgtic.core.proyecto6.persistencia.modelo.viaje.TipoTour;

@CrossOrigin(origins = "*")
@RestController
public class MicroServiciosTipoTour {

    @Autowired
    private TipoTourDAO tipoTourDAO;

    @GetMapping(value = "/tipoTour", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TipoTour> consultaTipoTour() {
        return tipoTourDAO.consultaTipoTour();
    }

    @DeleteMapping(value = "borrarTipoTour/{idTipoTour}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminarTipoTour(@PathVariable("idTipoTour") String idTipoTour) {
        tipoTourDAO.borrarTipoTour(tipoTourDAO.consultaIdTipoTour(Integer.parseInt(idTipoTour)));
    }

    @PutMapping(value = "/cambiarTipoTour", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void cambiartipoTourDao(@RequestBody TipoTour tipoTourNuevo) {
        tipoTourDAO.cambiarTipoTour(tipoTourNuevo);
    }

    @PostMapping(value = "/nuevoTipoTour", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void nuevotipoTourDao(@RequestBody TipoTour tipoTourNuevo) {
        tipoTourDAO.insertarTipoTour(tipoTourNuevo);
    }
}
