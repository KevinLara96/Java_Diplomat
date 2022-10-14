package unam.dgtic.core.proyecto7.controlador.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import unam.dgtic.core.proyecto7.controlador.repositorios.AgenciaRepositorio;
import unam.dgtic.core.proyecto7.controlador.repositorios.EmpleadoRepositorio;
import unam.dgtic.core.proyecto7.controlador.repositorios.PuestoRepositorio;
import unam.dgtic.core.proyecto7.modelo.empleado.Empleado;
import unam.dgtic.core.proyecto7.modelo.agencia.Agencia;
import unam.dgtic.core.proyecto7.modelo.puesto.Puesto;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    EmpleadoRepositorio repositorioEmpleado;

    @Autowired
    AgenciaRepositorio repositorioAgencia;

    @Autowired
    PuestoRepositorio repositorioPuesto;

    @RequestMapping(value = "buscarTodos")
    public String buscarTodos(Model model) {
        Iterable<Empleado> iterable = repositorioEmpleado.buscarTodos();
        model.addAttribute("empleados", iterable);

        return "empleados";
    }

    @RequestMapping(value = "buscarTodos", params = "nombre") // Componente a mapear.
    public String buscarPorNombre(Model modelo, String nombre) {
        Iterable<Empleado> iterable = repositorioEmpleado.getByNombre(nombre);
        modelo.addAttribute("empleados", iterable);

        return "empleados"; // Nombre del archivo HTML.
    }

    @RequestMapping(value = "buscarTodos", params = "correo") // Componente a mapear.
    public String buscarPorCorreo(Model modelo, String correo) {
        Iterable<Empleado> iterable = repositorioEmpleado.getByCorreo(correo);
        modelo.addAttribute("empleados", iterable);

        return "empleados"; // Nombre del archivo HTML.
    }

    @RequestMapping(value = "buscarTodos", params = { "nombre", "correo" }) // Componente a mapear.

    public String buscarPorCorreo(Model modelo, String correo, String nombre) {
        Iterable<Empleado> iterable = repositorioEmpleado.getByNombreAndCorreo(nombre, correo);
        modelo.addAttribute("empleados", iterable);

        return "empleados"; // Nombre del archivo HTML.
    }

    /* CRUD */

    @RequestMapping("/nuevo") // Nuevo empleado
    public String nuevoEmpleado(Model model) {
        Empleado empleado = new Empleado();
        model.addAttribute("empleado", empleado);

        return "empleado_nuevo";
    }

    @RequestMapping("/editar/{idEmpleado}") // Editar empleado
    public ModelAndView editarEmpleado(@PathVariable(name = "idEmpleado") Integer idEmpleado) {
        ModelAndView mav = new ModelAndView("empleado_editar");

        Optional<Empleado> optional = repositorioEmpleado.findByIdEmpleado(idEmpleado);
        Empleado empleado = null;
        if (optional.isPresent()) {
            empleado = optional.get();
        }
        mav.addObject("empleado", empleado);

        return mav;
    }

    @RequestMapping(value = "guardar", method = RequestMethod.POST)
    public String guardar(@ModelAttribute("empleado") Empleado empleado) {

        Optional<Agencia> optionalAgencia = repositorioAgencia.findByIdAgencia(empleado.getIdAgenciaE());
        if (optionalAgencia.isPresent()) {
            empleado.setAgencia(optionalAgencia.get());
        } else {
            empleado.setAgencia(new Agencia(3, "Prueba", "Prueba"));
        }
        Optional<Puesto> optionalPuesto = repositorioPuesto.findByIdPuesto(empleado.getIdPuestoE());
        if (optionalPuesto.isPresent()) {
            empleado.setPuesto(optionalPuesto.get());
        } else {
            empleado.setPuesto(new Puesto(3, "Prueba"));
        }

        // empleado.setPuesto(new Puesto(empleado.getIdPuestoE(), ""));

        repositorioEmpleado.save(empleado);

        return "redirect:buscarTodos";
    }

    @RequestMapping("/eliminar/{idEmpleado}")
    public String eliminarEmpleado(@PathVariable(name = "idEmpleado") Integer idEmpleado) {
        Optional<Empleado> optional = repositorioEmpleado.findById(idEmpleado);
        if (optional.isPresent()) {
            repositorioEmpleado.deleteByIdEmpleado(idEmpleado);
        }

        return "redirect:/empleados/buscarTodos";
    }
}
