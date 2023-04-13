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
	
	public Boolean update(Producto prod) {		
		String sql = "UPDATE PRODUCTOS SET STOCK = ? WHERE ID = ?";
        int response = jdbc.update(sql, prod.getStock(), prod.getId());
		return response > 0;
	}
	
	public Boolean insertKardex(Producto prod, int movimiento) {		
		String sql = "INSERT INTO KARDEX (FECHA, ID_MOVIMIENTO, ID_PRODUCTO, CANTIDAD, PRECIO) VALUES (CURRENT_DATE, ?, ?, ?, ?)";
        int response = jdbc.update(sql, movimiento, prod.getId(), prod.getCantidad(), prod.getPrecio());
        System.out.println(response);
		return response > 0;
	}
}
