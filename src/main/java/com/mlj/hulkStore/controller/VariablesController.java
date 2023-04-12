package com.mlj.hulkStore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mlj.hulkStore.model.Variable;
import com.mlj.hulkStore.service.VariablesService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/variables")
public class VariablesController {

	@Autowired
	VariablesService service;
	
	@PostMapping("/getById")
	public Variable getVariableById(@RequestBody Map<String, String> request){
		return service.getVariableById(Integer.getInteger(request.get("id")));
	}
	
	@PostMapping("/getByCategory")
	public List<Variable> getByCategory(@RequestBody Map<String, String> request){
		return service.getByCategory(request.get("category"));
	}
}
