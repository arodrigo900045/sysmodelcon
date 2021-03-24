package com.arodrigo.sysmodelcon.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arodrigo.sysmodelcon.domain.Pedido;
import com.arodrigo.sysmodelcon.repositories.PedidoRepository;
import com.arodrigo.sysmodelcon.services.exceptions.ObjectNotFoundException;


@Service
public class PedidoService 
{
	@Autowired
	private PedidoRepository repo;
	
    public Pedido busca(Integer id)
    {
    	Optional<Pedido> obj = repo.findById(id);
    	return obj.orElseThrow(() -> new ObjectNotFoundException("Objecto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }
}
