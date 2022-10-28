package mx.unam.diplomado.controller.empleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.unam.diplomado.modelo.entidades.empleado.Empleado;
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
}
