package mx.unam.diplomado.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mx.unam.diplomado.modelo.agencia.Agencia;
import mx.unam.diplomado.modelo.repository.AgenciaRepositorio;

@Controller
public class HomeController {

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private AgenciaRepositorio agenciaRepositorio;

    @RequestMapping(value = "/")
    public ModelAndView test(HttpServletResponse response) throws IOException {
        Iterable<Agencia> lista = agenciaRepositorio.findAll();
        List<String> listaAgencia = new ArrayList<String>();
        for (Agencia agencia : lista) {
            listaAgencia.add(agencia.getNombreAgencia());
        }

        // servletContext.setAttribute("agenciaList", listaAgencia);
        return new ModelAndView("home");
    }
}
