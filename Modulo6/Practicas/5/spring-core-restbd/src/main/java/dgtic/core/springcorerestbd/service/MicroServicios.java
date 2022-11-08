package dgtic.core.springcorerestbd.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dgtic.core.springcorerestbd.persistence.dao.EstudianteDao;
import dgtic.core.springcorerestbd.persistence.modelo.Estudiante;

@CrossOrigin(origins = "*")
@RestController
public class MicroServicios {
    @Autowired
    private EstudianteDao estudiante;

    @GetMapping(value = "estudiantes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Estudiante> servicioUno() {
        return estudiante.consulta();
    }

    @DeleteMapping(value = "borrar/{cuenta}")
    public void eliminar(@PathVariable("cuenta") String cuenta) {
        estudiante.borrar(estudiante.consultaId(cuenta));
    }
}