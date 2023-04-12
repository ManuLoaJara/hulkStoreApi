package com.mlj.hulkStore.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mlj.hulkStore.model.Variable;

public class VariableRowMapper implements RowMapper<Variable>{

	@Override
	public Variable mapRow(ResultSet rs, int rowNum) throws SQLException {
		Variable variable = new Variable();
		variable.setId(rs.getInt("ID"));
		variable.setCategoria(rs.getString("CATEGORIA"));
		variable.setValor(rs.getString("VALOR"));
		return variable;
	}
	
}