package com.mlj.hulkStore.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mlj.hulkStore.model.Producto;

public class ProductoRowMapper implements RowMapper<Producto> {

	@Override
	public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
		Producto producto = new Producto();
		producto.setId(rs.getInt("ID"));
		producto.setIdTipo(rs.getInt("ID_TIPO"));
		producto.setReferencia(rs.getString("REFERENCIA"));
		producto.setPrecio(rs.getInt("PRECIO"));
		producto.setStock(rs.getInt("STOCK"));
		producto.setImagenBase64(rs.getString("IMAGEN"));
		return producto;
	}

}