package mx.unam.diplomado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.unam.diplomado.forms.EmpleadoForm;
import mx.unam.diplomado.modelo.entidades.Empleado;
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
}
