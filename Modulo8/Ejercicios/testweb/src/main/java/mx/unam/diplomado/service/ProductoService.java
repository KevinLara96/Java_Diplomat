package mx.unam.diplomado.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.unam.diplomado.data.Producto;

@Service
public interface ProductoService {

	List<Producto> productList();
	
}
