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

import dgtic.core.proyecto6.persistencia.dao.interfaces.AgenciaDAO;
import dgtic.core.proyecto6.persistencia.modelo.agencia.Agencia;

@CrossOrigin(origins = "*")
@RestController
public class MicroServiciosAgencia {

    @Autowired
    private AgenciaDAO tipoViajeDAO;

    @GetMapping(value = "/agencia", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Agencia> consultaAgencia() {
        return tipoViajeDAO.consultaAgencias();
    }

    @DeleteMapping(value = "borrarAgencia/{idAgencia}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminarAgencia(@PathVariable("idAgencia") String idAgencia) {
        tipoViajeDAO.borrarAgencia(tipoViajeDAO.consultaIdAgencia(Integer.parseInt(idAgencia)));
    }

    @PutMapping(value = "/cambiarAgencia", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void cambiartipoTourDao(@RequestBody Agencia tipoViajeNuevo) {
        tipoViajeDAO.cambiarAgencia(tipoViajeNuevo);
    }

    @PostMapping(value = "/nuevaAgencia", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void nuevotipoTourDao(@RequestBody Agencia tipoViajeNuevo) {
        tipoViajeDAO.insertarAgencia(tipoViajeNuevo);
    }

}
