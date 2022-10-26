package mx.unam.diplomado.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mx.unam.diplomado.forms.EmpleadoForm;
import mx.unam.diplomado.modelo.agencia.Agencia;
import mx.unam.diplomado.modelo.empleado.Empleado;
import mx.unam.diplomado.modelo.puesto.Puesto;
import mx.unam.diplomado.modelo.repository.AgenciaRepositorio;
import mx.unam.diplomado.modelo.repository.EmpleadoRepositorio;
import mx.unam.diplomado.modelo.repository.PuestoRepositorio;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    @Autowired
    private AgenciaRepositorio agenciaRepositorio;

    @Autowired
    private PuestoRepositorio puestoRepositorio;

    @ResponseBody
    @RequestMapping(value = { "/jsonEmpleado" })
    public List<Empleado> tipoEmpleadoJson() {
        return empleadoRepositorio.buscarTodos();
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String cargaEmpleado(Model model) {
        model.addAttribute("empleados", empleadoRepositorio.buscarTodos());
        return "listaEmpleados";
    }

    @RequestMapping("/empleadoForm")
    public String empleadoForm(Model model) {
        model.addAttribute("empleado", new EmpleadoForm());
        return "empleadoForm";
    }

    @RequestMapping(value = "/guardaEmpleado", method = RequestMethod.POST)
    public ModelAndView guardaEmpleado(@ModelAttribute("empleado") @Valid EmpleadoForm empleadoForm,
            BindingResult result) {
        ModelAndView vista = new ModelAndView();
        if (result.hasErrors()) {
            vista.addObject(empleadoForm);
            vista.setViewName("empleadoForm");
        } else {
            System.out.println("OBJECT FORM==" + empleadoForm);
            Empleado empleado = empleadoForm.getIdEmpleado() != null
                    ? empleadoRepositorio.findByIdEmpleado(empleadoForm.getIdEmpleado()).get()
                    : new Empleado();
            empleado.setNombre(empleadoForm.getNombre());
            empleado.setCorreo((empleadoForm.getCorreo()));
            empleado.setRfc(empleadoForm.getRfc());
            empleado.setContrasena(empleadoForm.getContrasena());
            Agencia agencia = agenciaRepositorio.findByNombreAgencia(empleadoForm.getPuesto()).get();
            empleado.setAgencia(agencia);
            Puesto puesto = puestoRepositorio.findByPuesto(empleadoForm.getPuesto()).get();
            empleado.setPuesto(puesto);

            empleadoRepositorio.save(empleado);

            vista.addObject("empleados", empleadoRepositorio.buscarTodos());
            vista.setViewName("listaEmpleados");
        }
        return vista;

    }

    @RequestMapping("/actualizar/{idEmpleado}")
    public String showFormForUpdate(@PathVariable Integer idEmpleado, Model model) {
        Empleado empleado = empleadoRepositorio.findById(idEmpleado).get();
        if (empleado != null) {
            EmpleadoForm empleadoForm = new EmpleadoForm();
            empleadoForm.setIdEmpleado(idEmpleado);
            empleadoForm.setNombre(empleado.getNombre());
            empleadoForm.setCorreo(empleado.getCorreo());
            empleadoForm.setContrasena((empleado.getContrasena()));
            empleadoForm.setRfc(empleado.getRfc());
            empleadoForm.setSalario(empleado.getSalario());
            empleadoForm.setAgencia(empleado.getAgencia().getNombreAgencia());
            empleadoForm.setPuesto(empleado.getPuesto().getPuesto());

            model.addAttribute("empleado", empleadoForm);
        } else {
            model.addAttribute("empleado", new EmpleadoForm());
        }
        return "empleadoForm";
    }

    @RequestMapping("eliminar")
    public String eliminaEmpleado(@RequestParam("empleadoId") Integer idEmpleado) {
        empleadoRepositorio.deleteByIdEmpleado(idEmpleado);
        return "redirect:/empleados/listar";
    }

}
