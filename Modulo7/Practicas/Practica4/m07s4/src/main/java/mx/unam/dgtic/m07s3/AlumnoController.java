package mx.unam.dgtic.m07s3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    AlumnoRepositorio repositorioAlumno;

    @RequestMapping(value = "buscarTodos")
    public String buscarTodos(Model modelo) {
        Iterable<Alumno> iterable = repositorioAlumno.findAll();
        modelo.addAttribute("alumnos", iterable);

        return "alumnos"; // Nombre del archivo HTML.
    }
}
