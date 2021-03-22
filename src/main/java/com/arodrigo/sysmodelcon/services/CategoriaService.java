package com.arodrigo.sysmodelcon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arodrigo.sysmodelcon.domain.Categoria;
import com.arodrigo.sysmodelcon.repositories.CategoriaRepository;
import java.util.Optional;

@Service
public class CategoriaService 
{
	@Autowired
	private CategoriaRepository repo;
	
    public Categoria busca(Integer id)
    {
    	Optional<Categoria> obj = repo.findById(id);
    	return obj.orElse(null);
    }
}
