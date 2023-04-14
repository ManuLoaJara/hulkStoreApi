package com.mlj.hulkStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mlj.hulkStore.model.Producto;
import com.mlj.hulkStore.model.Variable;
import com.mlj.hulkStore.repository.ProductosRepository;

@Component
public class ProductosService {

	@Autowired
	ProductosRepository repository;
	
	@Autowired
	VariablesService variablesService;
	
	int movimiento_salida = 6;
	int movimiento_entrada = 7;
	
	public List<Producto> getProductos(){
		List<Producto> lista = repository.getProductos();
		for (Producto prod : lista) {
			Variable variable = variablesService.getVariableById(prod.getIdTipo());
			prod.setNombreTipo(variable.getValor());
		}
		return lista;
	}
	
	public Boolean compra(List<Producto> request){
		Boolean response = false;
		for (Producto prod : request) {
			prod.setStock(prod.getStock() - prod.getCantidad());
			response = repository.updateStock(prod);
			repository.insertKardex(prod, movimiento_salida);
		}
		return response;
	}
	
	public Boolean addProduct(Producto prod){
		Boolean response = false;
		if (prod.getEsNuevo()) {
			prod.setStock(prod.getCantidad());
			int idProd = repository.addProduct(prod);
			prod.setId(idProd);
		}else {
			prod.setStock(prod.getCantidad() + prod.getStock());
			prod.setId(Integer.valueOf(prod.getReferencia()));
			repository.updateProduct(prod);
		}
		response = repository.insertKardex(prod, movimiento_entrada);
		return response;
	}
}
