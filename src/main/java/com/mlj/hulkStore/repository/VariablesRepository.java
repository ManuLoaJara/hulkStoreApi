package com.mlj.hulkStore.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mlj.hulkStore.mapper.VariableRowMapper;
import com.mlj.hulkStore.model.Variable;

@Repository
public class VariablesRepository {

	@Autowired
	JdbcTemplate jdbc;
	
	public Variable getVariableById(int id) {
		List<Variable> lista = jdbc.query("SELECT * FROM VARIABLES WHERE ID = " + id, new VariableRowMapper());
		return lista.get(0);
	}
	
	public List<Variable> getByCategory(String categoria) {
		List<Variable> lista = jdbc.query("SELECT * FROM VARIABLES WHERE CATEGORIA = '" + categoria + "'", new VariableRowMapper());
		return lista;
	}
}
