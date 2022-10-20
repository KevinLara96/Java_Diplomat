package mx.unam.diplomado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.unam.diplomado.data.Producto;
import mx.unam.diplomado.service.ProductoService;

@Controller
@RequestMapping("/productos")
public class JsonController {
	
	@Autowired
	private ProductoService productoService;
	
	@ResponseBody
    @RequestMapping("/json")
    public List<Producto> productosJson() {
        return productoService.productList();
    }
	
	@RequestMapping("/jsonSinetiqueta")
	public String productosJson2(Model model) {
	    model.addAttribute(productoService.productList());
	    return "jsonView";
	}

}
