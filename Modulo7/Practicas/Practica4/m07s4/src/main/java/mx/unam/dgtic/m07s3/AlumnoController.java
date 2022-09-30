package mx.unam.dgtic.m07s3;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    AlumnoRepositorio repositorioAlumno;

    @RequestMapping(value = "buscarTodos") // Componente a mapear.
    public String buscarTodos(Model modelo) {
        Iterable<Alumno> iterable = repositorioAlumno.findAll();
        modelo.addAttribute("alumnos", iterable);

        return "alumnos"; // Nombre del archivo HTML.
    }

    @RequestMapping(value = "buscarTodos", params = "nombre") // Componente a mapear.
    public String buscarPorNombre(Model modelo, String nombre) {
        Iterable<Alumno> iterable = repositorioAlumno.buscarPorNombre(nombre);
        modelo.addAttribute("alumnos", iterable);

        return "alumnos"; // Nombre del archivo HTML.
    }

    @RequestMapping(value = "buscarTodos", params = "paterno") // Componente a mapear.
    public String buscarPorPaterno(Model modelo, String paterno) {
        Iterable<Alumno> iterable = repositorioAlumno.searchByPaterno(paterno);
        modelo.addAttribute("alumnos", iterable);

        return "alumnos"; // Nombre del archivo HTML.
    }

    @RequestMapping(value = "buscarTodos", params = { "nombre", "paterno" }) // Componente a mapear.
    public String buscarPorPaterno(Model modelo, String paterno, String nombre) {
        Iterable<Alumno> iterable = repositorioAlumno.buscarPorNombreYPaterno(nombre, paterno);
        modelo.addAttribute("alumnos", iterable);

        return "alumnos"; // Nombre del archivo HTML.
    }

    @RequestMapping(value = "buscarTodos", params = "orden")
    public String buscarTodos(Model modelo,
            @RequestParam(name = "orden", defaultValue = "matricula") String orden) { // Recibe el orden de los
                                                                                      // parámetros.
        Iterable<Alumno> iterable = repositorioAlumno.findAll(Sort.by(orden));
        modelo.addAttribute("alumnos", iterable);

        return "alumnos"; // Nombre del archivo HTML.
    }

    /* CRUD */
    @RequestMapping("/nuevo") // Nuevo alumno
    public String nuevoAlumno(Model model) {
        Alumno alumno = new Alumno();
        model.addAttribute("alumno", alumno);

        return "alumno_nuevo";
    }

    @RequestMapping("/editar/{matricula}") // Nuevo alumno
    public ModelAndView editarAlumno(@PathVariable(name = "matricula") String matricula) {
        ModelAndView mav = new ModelAndView("alumno_editar");

        Optional<Alumno> optional = repositorioAlumno.findById(matricula);
        Alumno alumno = null;
        if (optional.isPresent()) {
            alumno = optional.get();
        }
        mav.addObject("alumno", alumno);

        return mav;
    }

    @RequestMapping(value = "guardar", method = RequestMethod.POST)
    public String guardar(@ModelAttribute("alumno") Alumno alumno) {
        repositorioAlumno.save(alumno);

        return "redirect:buscarTodos";
    }

    @RequestMapping("/eliminar/{matricula}")
    public String eliminarAlumno(@PathVariable(name = "matricula") String matricula) {
        Optional<Alumno> optional = repositorioAlumno.findById(matricula);
        if (optional.isPresent()) {
            repositorioAlumno.deleteById(matricula);
        }

        return "redirect:/alumnos/buscarTodos";
    }
}
