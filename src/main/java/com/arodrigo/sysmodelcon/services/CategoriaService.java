package com.arodrigo.sysmodelcon.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arodrigo.sysmodelcon.domain.Categoria;
import com.arodrigo.sysmodelcon.repositories.CategoriaRepository;
import com.arodrigo.sysmodelcon.services.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService 
{
	@Autowired
	private CategoriaRepository repo;
	
    public Categoria busca(Integer id)
    {
    	Optional<Categoria> obj = repo.findById(id);
    	return obj.orElseThrow(() -> new ObjectNotFoundException("Objecto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }
}
