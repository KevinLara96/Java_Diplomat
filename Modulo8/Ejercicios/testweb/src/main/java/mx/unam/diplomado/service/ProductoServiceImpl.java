package mx.unam.diplomado.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.unam.diplomado.data.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Override
	public List<Producto> productList() {
		List<Producto> productos = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Producto producto = new Producto();
			producto.setId(i+1);
			producto.setNombre("Producto" + (i + 1));
			productos.add(producto);
		}
		return productos;
	}

}
