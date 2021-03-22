package com.arodrigo.sysmodelcon.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arodrigo.sysmodelcon.domain.Categoria;
import com.arodrigo.sysmodelcon.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource 
{
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) 
	{
	    Categoria obj = service.busca(id); //REST acessa ao servico
	    return ResponseEntity.ok().body(obj);		
	}

}
