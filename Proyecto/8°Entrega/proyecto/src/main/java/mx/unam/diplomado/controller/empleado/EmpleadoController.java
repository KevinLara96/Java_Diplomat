package mx.unam.diplomado.controller.empleado;

import java.util.List;

import javax.validation.Valid;

//import org.springframework.beans.factory.annotation.Autowired;
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

import mx.unam.diplomado.forms.empleado.EmpleadoForm;
import mx.unam.diplomado.modelo.entidades.agencia.Agencia;
import mx.unam.diplomado.modelo.entidades.empleado.Empleado;
import mx.unam.diplomado.modelo.entidades.puesto.Puesto;
import mx.unam.diplomado.service.servicioAgencia.AgenciaService;
import mx.unam.diplomado.service.servicioEmpleado.EmpleadoService;
import mx.unam.diplomado.service.servicioPuesto.PuestoService;

@Controller
@RequestMapping("/tmp")
public class EmpleadoController {

    // @Autowired
    private EmpleadoService empleadoService;

    // @Autowired
    private AgenciaService agenciaService;

    // @Autowired
    private PuestoService puestoService;

    @ResponseBody
    @RequestMapping(value = { "/jsonEmpleado" })
    public List<Empleado> tipoEmpleadoJson() {
        return null;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String cargaEmpleado(Model model) {
        model.addAttribute("empleados", empleadoService.cargaEmpleados());
        return "listaEmpleados";
    }

    @RequestMapping("/empleadoForm")
    public String empleadooForm(Model model) {
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
            Empleado empleado = empleadoForm.getIdEmpleado() != null
                    ? empleadoService.cargaEmpleado(empleadoForm.getIdEmpleado()).get()
                    : new Empleado();
            empleado.setIdEmpleado((empleadoForm.getIdEmpleado()));
            empleado.setNombre(empleadoForm.getNombre());
            empleado.setCorreo(empleadoForm.getCorreo());
            empleado.setContrasena(empleadoForm.getContrasena());
            empleado.setRfc(empleadoForm.getRfc());
            empleado.setSalario(empleadoForm.getSalario());
            Agencia agencia = agenciaService.cargaPorNombre(empleadoForm.getAgencia());
            empleado.setAgencia(agencia);
            Puesto puesto = puestoService.cargaPorNombre(empleadoForm.getPuesto());
            empleado.setPuesto(puesto);

            empleadoService.guardaEmpleado(empleado);
            vista.addObject("empleados", empleadoService.cargaEmpleados());
            vista.setViewName("listaEmpleados");
        }
        return vista;

    }

    @RequestMapping("/actualizar/{idEmpleado}")
    public String showFormForUpdate(@PathVariable Integer idEmpleado, Model model) {
        Empleado empleado = empleadoService.cargaEmpleado(idEmpleado).get();
        if (empleado != null) {
            EmpleadoForm empleadoForm = new EmpleadoForm();
            empleadoForm.setIdEmpleado(idEmpleado);
            empleadoForm.setNombre(empleado.getNombre());
            empleadoForm.setCorreo(empleado.getCorreo());
            empleadoForm.setContrasena(empleado.getContrasena());
            empleadoForm.setRfc(empleado.getRfc());
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
        empleadoService.eliminaEmpleado(idEmpleado);
        return "redirect:/empleados/listar";
    }

}
