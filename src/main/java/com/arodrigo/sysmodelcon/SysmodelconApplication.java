package com.arodrigo.sysmodelcon;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.arodrigo.sysmodelcon.domain.Categoria;
import com.arodrigo.sysmodelcon.domain.Produto;
import com.arodrigo.sysmodelcon.repositories.CategoriaRepository;
import com.arodrigo.sysmodelcon.repositories.ProdutoRepository;

@SpringBootApplication
public class SysmodelconApplication implements CommandLineRunner
{
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) 
	{
		SpringApplication.run(SysmodelconApplication.class, args);
	}

	@Override  //implementando o metodo CommandLineRunner
	public void run(String... args) throws Exception 
	{
		Categoria cat1 = new Categoria(null, "Informmática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador SX",240000.00);
		Produto p2 = new Produto(null, "Impressora HP z",72000.00);
		Produto p3 = new Produto(null, "Teclado",11000.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
				
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
	}

}
