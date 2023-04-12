package com.mlj.hulkStore.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mlj.hulkStore.mapper.ProductoRowMapper;
import com.mlj.hulkStore.model.Producto;

@Repository
public class ProductosRepository {

	@Autowired
	JdbcTemplate jdbc;
	
	public List<Producto> getProductos() {
		List<Producto> lista = jdbc.query("SELECT * FROM PRODUCTOS", new ProductoRowMapper());
		return lista;
	}
}
