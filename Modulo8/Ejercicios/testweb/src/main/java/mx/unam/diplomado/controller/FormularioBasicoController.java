package mx.unam.diplomado.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mx.unam.diplomado.data.Producto;

@Controller
@RequestMapping("/productoForm")
public class FormularioBasicoController {

	@RequestMapping("/inicio")
	public String form(Model model) {
		model.addAttribute("producto", new Producto());
		return "formularioBasico";
	}
	
	
	@RequestMapping(value = "/guardaProducto", method=RequestMethod.POST)
	public ModelAndView guarda(Producto producto, HttpServletRequest request) {
		ModelAndView vista = new ModelAndView("productosForm");
		List<Producto> productos = request.getSession().getAttribute("productos") != null 
				?  (List<Producto>)request.getSession().getAttribute("productos") : new ArrayList<>();
		productos.add(producto);
		request.getSession().setAttribute("productos", productos);
		return vista;
	}

}
