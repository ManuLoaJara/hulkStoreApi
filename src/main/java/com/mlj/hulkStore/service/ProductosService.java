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
	
	public List<Producto> getProductos(){
		return repository.getProductos();
	}
}
