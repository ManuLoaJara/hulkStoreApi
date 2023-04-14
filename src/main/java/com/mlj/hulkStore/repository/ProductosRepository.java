package com.mlj.hulkStore.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
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
	
	public Boolean updateProduct(Producto prod) {
		String sql = "UPDATE PRODUCTOS SET ID_TIPO = ?, PRECIO = ?, STOCK = ?, IMAGEN = ?  WHERE ID = ?";
		int response = jdbc.update(sql, prod.getIdTipo(), prod.getPrecio(), prod.getStock(), prod.getImagenBase64(), prod.getId());
		return response > 0;
	}

	public Boolean updateStock(Producto prod) {
		String sql = "UPDATE PRODUCTOS SET STOCK = ? WHERE ID = ?";
		int response = jdbc.update(sql, prod.getStock(), prod.getId());
		return response > 0;
	}

	public Boolean insertKardex(Producto prod, int movimiento) {
		String sql = "INSERT INTO KARDEX (FECHA, ID_MOVIMIENTO, ID_PRODUCTO, CANTIDAD, PRECIO) VALUES (CURRENT_DATE, ?, ?, ?, ?)";
		int response = jdbc.update(sql, movimiento, prod.getId(), prod.getCantidad(), prod.getPrecio());
		return response > 0;
	}

	public int addProduct(Producto prod) {
		GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder(); 
		String sql = "INSERT INTO PRODUCTOS (ID_TIPO, REFERENCIA, PRECIO, STOCK, IMAGEN) VALUES (?, ?, ?, ?, ?);";
		jdbc.update(conn -> {
			PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, prod.getIdTipo());
			preparedStatement.setString(2, prod.getReferencia());
			preparedStatement.setInt(3, prod.getPrecio());
			preparedStatement.setInt(4, prod.getStock());
			preparedStatement.setString(5, prod.getImagenBase64());
			return preparedStatement;
		}, generatedKeyHolder);
		return generatedKeyHolder.getKey().intValue();
	}
}
