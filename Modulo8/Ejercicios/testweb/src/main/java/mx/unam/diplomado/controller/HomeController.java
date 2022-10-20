package mx.unam.diplomado.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/modelView")
	public ModelAndView modelViewEjemplo(HttpServletResponse response) throws IOException{
		ModelAndView miVista = new ModelAndView("modelView");
		miVista.addObject("dato", "Dato desde controller");
		return miVista;
	}
}
