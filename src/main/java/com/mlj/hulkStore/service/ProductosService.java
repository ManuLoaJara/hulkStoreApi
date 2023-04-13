package com.mlj.hulkStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mlj.hulkStore.model.Producto;
import com.mlj.hulkStore.repository.ProductosRepository;

@Component
public class ProductosService {

	@Autowired
	ProductosRepository repository;
	
	int movimiento_salida = 6;
	
	public List<Producto> getProductos(){
		return repository.getProductos();
	}
	
	public Boolean compra(List<Producto> request){
		Boolean response = false;
		for (Producto prod : request) {
			prod.setStock(prod.getStock() - prod.getCantidad());
			response = repository.update(prod);
			repository.insertKardex(prod, movimiento_salida);
		}
		return response;
		
	}
}
