package com.arodrigo.sysmodelcon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arodrigo.sysmodelcon.domain.Provincia;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Integer> 
{
    
}
