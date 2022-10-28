package mx.unam.diplomado.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mx.unam.diplomado.forms.EmpleadoForm;
import mx.unam.diplomado.modelo.entidades.Agencia;
import mx.unam.diplomado.modelo.entidades.Empleado;
import mx.unam.diplomado.modelo.entidades.Puesto;
import mx.unam.diplomado.service.AgenciaService;
import mx.unam.diplomado.service.EmpleadoService;
import mx.unam.diplomado.service.PuestoService;

public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private AgenciaService agenciaService;

    @Autowired
    private PuestoService puestoService;

    @ResponseBody
    @RequestMapping(value = { "/jsonEmpleado" })
    public List<Empleado> tipoEmpleadoJson() {
        return empleadoService.cargaEmpleados();
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String cargcaEmpleado(Model model) {
        model.addAttribute("empleados", empleadoService.cargaEmpleados());

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
            Empleado empleado = empleadoForm.getIdEmpleado() != null
                    ? empleadoService.cargaEmpleado(empleadoForm.getIdEmpleado()).get()
                    : new Empleado();
            empleado.setIdEmpleado(empleadoForm.getIdEmpleado());
            empleado.setNombre(empleadoForm.getNombre());
            empleado.setCorreo(empleadoForm.getCorreo());
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
}
