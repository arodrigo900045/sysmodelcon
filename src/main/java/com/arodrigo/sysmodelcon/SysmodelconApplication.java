package com.arodrigo.sysmodelcon;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.arodrigo.sysmodelcon.domain.Categoria;
import com.arodrigo.sysmodelcon.domain.Cliente;
import com.arodrigo.sysmodelcon.domain.Endereco;
import com.arodrigo.sysmodelcon.domain.ItemPedido;
import com.arodrigo.sysmodelcon.domain.Municipio;
import com.arodrigo.sysmodelcon.domain.Pagamento;
import com.arodrigo.sysmodelcon.domain.PagamentoComBoleto;
import com.arodrigo.sysmodelcon.domain.PagamentoComCartao;
import com.arodrigo.sysmodelcon.domain.Pedido;
import com.arodrigo.sysmodelcon.domain.Produto;
import com.arodrigo.sysmodelcon.domain.Provincia;
import com.arodrigo.sysmodelcon.domain.enums.EstadoPagamento;
import com.arodrigo.sysmodelcon.domain.enums.TipoCliente;
import com.arodrigo.sysmodelcon.repositories.CategoriaRepository;
import com.arodrigo.sysmodelcon.repositories.ClienteRepository;
import com.arodrigo.sysmodelcon.repositories.EnderecoRepository;
import com.arodrigo.sysmodelcon.repositories.ItemPedidoRepository;
import com.arodrigo.sysmodelcon.repositories.MunicipioRepository;
import com.arodrigo.sysmodelcon.repositories.PagamentoRepository;
import com.arodrigo.sysmodelcon.repositories.PedidoRepository;
import com.arodrigo.sysmodelcon.repositories.ProdutoRepository;
import com.arodrigo.sysmodelcon.repositories.ProvinciaRepository;

@SpringBootApplication
public class SysmodelconApplication implements CommandLineRunner
{
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private ProvinciaRepository provinciaRepository;
	@Autowired
	private MunicipioRepository municipioRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	
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
		
		Provincia prov1 = new Provincia(null, "Luanda");
		Provincia prov2 = new Provincia(null, "Benguela");
		
		Municipio mun1 = new Municipio(null, "Viana", prov1);
		mun1.getDestritoUrbano().addAll(Arrays.asList("Zango","Estalagem"));
		Municipio mun2 = new Municipio(null, "Lobito", prov2);
		Municipio mun3 = new Municipio(null, "Bocoio", prov2);
		
		prov1.getMunicipios().addAll(Arrays.asList(mun1));
		prov2.getMunicipios().addAll(Arrays.asList(mun2, mun3));
		
		provinciaRepository.saveAll(Arrays.asList(prov1, prov2));
		municipioRepository.saveAll(Arrays.asList(mun1, mun2, mun3));
		
		
		Cliente cli1 = new Cliente(null, "Elison Gomes", "Elison.gomes@youthrodive.com", "000142506LA021", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("923765422", "912432175"));
		
		Endereco e1 = new Endereco(null, "Rua Manjorca Yangulo", "300", "Apto 201", "Prenda", "23213445", cli1, mun1);		
		Endereco e2 = new Endereco(null, "Avenida Brasil", "105", "Sala 800", "Luanda", "838382742", cli1, mun2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2020 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2020 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/04/2021 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 240000.0);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 11000.0);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 20000.00, 1, 72000.0);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		
	}

}
