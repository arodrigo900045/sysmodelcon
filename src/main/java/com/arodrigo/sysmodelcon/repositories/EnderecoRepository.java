package com.arodrigo.sysmodelcon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arodrigo.sysmodelcon.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> 
{
    
}
