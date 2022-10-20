package mx.unam.diplomado.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.unam.diplomado.data.Producto;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/productos")
public class ProductosController {
	
	@RequestMapping("/listar")
    public String productList(Model model) {
        model.addAttribute("productList", productList());
        return "productos";
    }
	
	private List<Producto> productList() {
		List<Producto> productos = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Producto producto = new Producto();
			producto.setId(i+1);
			producto.setNombre("Producto" + (i + 1));
			productos.add(producto);
		}
		return productos;
	}
	
	@RequestMapping(value = "/parametro/{accion}/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String productoParam(Model model, @PathVariable String accion, @PathVariable Integer id) {
		String vista = "";
		if (accion.equals("editar")) {
			//voy a la base
			//returno el jsp para mostrar datos del producto
			model.addAttribute("producto", new Producto());
			vista = "editarProducto";
		} else if (accion.equals("eliminar")) {
			List<Producto> productos = productList();
			Producto productoRemove = productos.get(id);
			productos.remove(productoRemove);
			model.addAttribute("productList", productos);
			vista = "productos";
		}
		return vista;
	}
	

	@ResponseBody
    @RequestMapping(value = "/producto/{id}", method = RequestMethod.GET)
    public Producto productoJsonById(@PathVariable Integer id) {
		List<Producto> productos = productList();
        return id < productos.size() && id > 0 ? productos.get(id) : new Producto();
    }

}
