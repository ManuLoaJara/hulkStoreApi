package com.mlj.hulkStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mlj.hulkStore.model.Variable;
import com.mlj.hulkStore.repository.VariablesRepository;

@Component
public class VariablesService {

	@Autowired
	VariablesRepository repository;
	
	public Variable getVariableById(int id){
		return repository.getVariableById(id);
	}
	
	public List<Variable> getByCategory(String category){
		return repository.getByCategory(category);
	}
}
