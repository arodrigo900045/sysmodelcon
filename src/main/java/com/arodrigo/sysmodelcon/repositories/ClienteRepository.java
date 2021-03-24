package com.arodrigo.sysmodelcon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arodrigo.sysmodelcon.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> 
{
    
}
