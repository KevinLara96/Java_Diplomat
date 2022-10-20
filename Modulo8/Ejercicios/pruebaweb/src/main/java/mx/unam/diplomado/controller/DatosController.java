package mx.unam.diplomado.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DatosController {

    @RequestMapping(value = "/vista")
    public ModelAndView getVista() {
        ModelAndView vista = new ModelAndView("vista"); // Nombre del JSP.
        vista.addObject("cadena", "Esta es una cadena desde el controller");

        return vista;
    }
}
