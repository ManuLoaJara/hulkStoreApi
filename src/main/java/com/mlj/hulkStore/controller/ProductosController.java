package com.mlj.hulkStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mlj.hulkStore.model.Producto;
import com.mlj.hulkStore.service.ProductosService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/producto")
public class ProductosController {

	@Autowired
	ProductosService service;
	
	@GetMapping("/getList")
	public List<Producto> getProductos(){
		return service.getProductos();
	}
	
	@PostMapping("/compra")
	public Boolean compra(@RequestBody List<Producto> request){
		return service.compra(request);
	}
	
	@PostMapping("/addProduct")
	public Boolean addProduct(@RequestBody Producto request){
		return service.addProduct(request);
	}
}
