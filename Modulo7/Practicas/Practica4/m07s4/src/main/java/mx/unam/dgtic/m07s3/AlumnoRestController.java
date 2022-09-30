package mx.unam.dgtic.m07s3;

import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoRestController {

    @Autowired
    AlumnoRepositorio repositorioAlumno;

    @Autowired
    CalificacionRepository repositorioCalificacion;

    /*
     * @GetMapping
     * public Iterable<Alumno> listarAlumnos() {
     * return repositorioAlumno.findAll();
     * }
     */

    @GetMapping("/{matricula}")
    public ResponseEntity<Alumno> listarAlumnosPorMatricula(@PathVariable String matricula) {
        Optional<Alumno> optional = repositorioAlumno.findById(matricula);

        if (optional.isPresent()) {
            return new ResponseEntity<Alumno>(optional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public Iterable<Alumno> listarAlumnosParametros(@RequestParam Map<String, String> parametros) {
        Iterable<Alumno> alumnos = null;
        int leidos = 0;

        if (parametros.containsKey("nombre")) {
            alumnos = repositorioAlumno.findByNombreContaining(parametros.get("nombre"));
            leidos = 1;
        }
        if (parametros.containsKey("paterno")) {
            alumnos = repositorioAlumno.findByPaternoContaining(parametros.get("paterno"));
            leidos = 1;
        }
        if (parametros.containsKey("estatura")) {
            alumnos = repositorioAlumno.findByEstaturaGreaterThanEqual(
                    Double.parseDouble(parametros.get("estatura")));
            leidos = 1;
        }
        if (parametros.containsKey("paterno")) {
            try {
                alumnos = repositorioAlumno.findByFnacAfter(
                        new SimpleDateFormat("yyyy-MM-dd").parse(parametros.get("fnac")));
                leidos = 1;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (parametros.containsKey("nombre") && parametros.containsKey("paterno")) {
            alumnos = repositorioAlumno.buscarPorNombreYPaterno(
                    parametros.get("nombre"), parametros.get("paterno"));
            leidos = 1;
        }

        if (leidos == 0) {
            alumnos = repositorioAlumno.findAll();
        }

        return alumnos;
    }
    /* Postman -> GET para todos los métodos anteriores. */

    @DeleteMapping("/{matricula}") // Postman -> DELETE.
    public ResponseEntity<Alumno> eliminarAlumnosPorMatricula(@PathVariable String matricula) {
        Optional<Alumno> optional = repositorioAlumno.findById(matricula);

        if (optional.isPresent()) {
            repositorioAlumno.deleteById(matricula);
            return new ResponseEntity<Alumno>(optional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED) // Postman -> POST.
    public void insertarAlumno(@RequestBody Alumno alumno) {
        repositorioAlumno.save(alumno);
        // En Postman -> Headers -> Key(Content-Type), Value(application/json).
    }

    @PutMapping("/{matricula}") // Postman -> PUT.
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Alumno> actualizarAlumno(@PathVariable String matricula, @RequestBody Alumno alumno) {
        Optional<Alumno> optional = repositorioAlumno.findById(matricula);
        if (optional.isPresent()) {
            Alumno a = alumno;
            a.setMatricula(matricula);
            repositorioAlumno.save(a);

            for (Calificacion c : alumno.getCalificaciones()) {
                c.setAlumno(a);
                repositorioCalificacion.save(c);
            }

            return new ResponseEntity<Alumno>(a, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException(
                    String.format("Alumno con la matrícula %s no localizado.", matricula));
        }
    }
    // Postman -> Headers -> KEY(Content-Type), VALUE(application/json)
    // Body -> Raw -> Alumno en formato JSON.
    // URL -> Debe tener la matrícula del alumno a actualizar.

}
