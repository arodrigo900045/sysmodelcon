package com.arodrigo.sysmodelcon;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.arodrigo.sysmodelcon.domain.Categoria;
import com.arodrigo.sysmodelcon.repositories.CategoriaRepository;

@SpringBootApplication
public class SysmodelconApplication implements CommandLineRunner
{
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) 
	{
		SpringApplication.run(SysmodelconApplication.class, args);
	}

	@Override  //implementando o metodo CommandLineRunner
	public void run(String... args) throws Exception 
	{
		Categoria cat1 = new Categoria(null, "Informmática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));		
		
	}

}
