package mx.unam.diplomado.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.unam.diplomado.data.Producto;

@Controller
@RequestMapping("/formatos")
public class ReportesController {
	
	@ModelAttribute("productosList")
    public List<Producto> getProductosList() {
		List<Producto> productos = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Producto producto = new Producto();
			producto.setId(i+1);
			producto.setNombre("Producto" + (i + 1));
			productos.add(producto);
		}
		return productos;
    }
	
	@RequestMapping("/pdf")
    public String generarPdf(Model model) {
        return "pdfView";
    }
	
	@RequestMapping("/xls")
    public String generarXls(Model model) {
        return "xlsView";
    }

}
