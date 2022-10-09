package unam.dgtic.core.ejercicio4;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/*import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Sort;*/

@Controller
@RequestMapping("/automoviles")
public class AutomovilController {

    @Autowired
    AutomovilRepositorio repositorioAutomovil;

    @RequestMapping(value = "buscarTodos") // Componente a mapear.
    public String buscarTodos(Model model) {
        Iterable<Automovil> iterable = repositorioAutomovil.findAll();
        model.addAttribute("automoviles", iterable);

        return "automoviles"; // Marca del archivo HTML.
    }

    @RequestMapping(value = "buscarTodos", params = "marca") // Componente a mapear.
    public String buscarPorMarca(Model model, String marca) {
        Iterable<Automovil> iterable = repositorioAutomovil.getByMarca(marca);
        model.addAttribute("automoviles", iterable);

        return "automoviles"; // Marca del archivo HTML.
    }

    @RequestMapping(value = "buscarTodos", params = "modelo") // Componente a mapear.
    public String buscarPormodel(Model model, String modelo) {
        Iterable<Automovil> iterable = repositorioAutomovil.getByModelo(modelo);
        model.addAttribute("automoviles", iterable);

        return "automoviles"; // Marca del archivo HTML.
    }

    @RequestMapping(value = "buscarTodos", params = { "marca", "modelo" }) // Componente a mapear.
    public String buscarPormodel(Model model, String modelo, String marca) {
        Iterable<Automovil> iterable = repositorioAutomovil.getByMarcaAndModelo(marca, modelo);
        model.addAttribute("automoviles", iterable);

        return "automoviles"; // Marca del archivo HTML.
    }

    /*
     * @RequestMapping(value = "buscarTodos", params = "orden")
     * public String buscarTodos(Model model,
     * 
     * @RequestParam(name = "orden", defaultValue = "id_automovil") String orden) {
     * // Recibe el orden de los
     * // parámetros.
     * Iterable<Automovil> iterable = repositorioAutomovil.findAll(Sort.by(orden));
     * model.addAttribute("automoviles", iterable);
     * 
     * return "automoviles"; // Marca del archivo HTML.
     * }
     */

    /* CRUD */
    @RequestMapping("/nuevo") // Nuevo automovil
    public String nuevoAutomovil(Model model) {
        Automovil automovil = new Automovil();
        model.addAttribute("automovil", automovil);

        return "automovil_nuevo";
    }

    @RequestMapping("/editar/{id_automovil}") // Nuevo automovil
    public ModelAndView editarAutomovil(@PathVariable(name = "id_automovil") Integer id_automovil) {
        ModelAndView mav = new ModelAndView("automovil_editar");

        Optional<Automovil> optional = repositorioAutomovil.findByIdAutomovil(id_automovil);
        Automovil automovil = null;
        if (optional.isPresent()) {
            automovil = optional.get();
        }
        mav.addObject("automovil", automovil);

        return mav;
    }

    @RequestMapping(value = "guardar", method = RequestMethod.POST)
    public String guardar(@ModelAttribute("automovil") Automovil automovil) {
        repositorioAutomovil.save(automovil);

        return "redirect:buscarTodos";
    }

    @RequestMapping("/eliminar/{id_automovil}")
    public String eliminarAutomovil(@PathVariable(name = "id_automovil") Integer id_automovil) {
        Optional<Automovil> optional = repositorioAutomovil.findByIdAutomovil(id_automovil);
        if (optional.isPresent()) {
            repositorioAutomovil.deleteById(id_automovil);
        }

        return "redirect:/automoviles/buscarTodos";
    }
}
