package com.arodrigo.sysmodelcon.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arodrigo.sysmodelcon.domain.Cliente;
import com.arodrigo.sysmodelcon.repositories.ClienteRepository;
import com.arodrigo.sysmodelcon.services.exceptions.ObjectNotFoundException;


@Service
public class ClienteService 
{
	@Autowired
	private ClienteRepository repo;
	
    public Cliente busca(Integer id)
    {
    	Optional<Cliente> obj = repo.findById(id);
    	return obj.orElseThrow(() -> new ObjectNotFoundException("Objecto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }
}
