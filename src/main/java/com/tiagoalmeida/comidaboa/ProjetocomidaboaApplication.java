package com.tiagoalmeida.comidaboa;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tiagoalmeida.comidaboa.domain.Cliente;
import com.tiagoalmeida.comidaboa.domain.Cozinheiro;
import com.tiagoalmeida.comidaboa.domain.Pedido;
import com.tiagoalmeida.comidaboa.domain.Refeicao;
import com.tiagoalmeida.comidaboa.repositories.ClienteRepository;
import com.tiagoalmeida.comidaboa.repositories.CozinheiroRepository;
import com.tiagoalmeida.comidaboa.repositories.PedidoRepository;
import com.tiagoalmeida.comidaboa.repositories.RefeicaoRepository;

@SpringBootApplication
public class ProjetocomidaboaApplication implements CommandLineRunner{
	
	@Autowired
	private CozinheiroRepository cozinheiroRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private RefeicaoRepository refeicaoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetocomidaboaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {			
		
		Cozinheiro coz1 = new Cozinheiro(null, "Pedro", "96857485");
		Cozinheiro coz2 = new Cozinheiro(null, "João", "85749685");				

		Refeicao ref1 = new Refeicao(null, "bife", 10.00, "rua anum, 00", 2,coz1);
		Refeicao ref2 = new Refeicao(null, "lasanha", 15.00, "rua sla, 01", 2,coz1);
		Refeicao ref3 = new Refeicao(null, "pizza", 10.00, "boi, 23", 2,coz2);
		
		Refeicao ref4 = new Refeicao(null, "alcatra", 10.00, "rua anum, 40", 2,coz1);
		Refeicao ref5 = new Refeicao(null, "alaminuta", 15.00, "rua bb, 110", 1,coz1);
		Refeicao ref6 = new Refeicao(null, "risoliszza", 10.00, "rua mona, 220", 2,coz2);
		Refeicao ref7 = new Refeicao(null, "hamburguer", 10.00, "rua picles, 49", 1,coz1);
		Refeicao ref8 = new Refeicao(null, "fricace", 15.00, "rua pedro joaquim, 03", 1,coz1);
		Refeicao ref9 = new Refeicao(null, "massa ao molho", 10.00, "rua carlos freitas, 11", 2,coz2);
		Refeicao ref10 = new Refeicao(null, "feijoada", 10.00, "av Pires Maia, 04", 2,coz1);
		Refeicao ref11 = new Refeicao(null, "carreteiro", 15.00, "rua silas, 01", 2,coz1);
		Refeicao ref12= new Refeicao(null, "estrogonofe", 10.00, "rua frodo, 22", 2,coz2);
		
		coz1.getRefeicoes().addAll(Arrays.asList(ref1, ref2, ref4, ref5, ref7, ref8, ref10, ref11));
		coz2.getRefeicoes().addAll(Arrays.asList(ref3, ref6, ref9, ref12));
		
		cozinheiroRepository.saveAll(Arrays.asList(coz1,coz2));
		refeicaoRepository.saveAll(Arrays.asList(ref1, ref2, ref3, ref4, ref5, ref6, ref7, ref8, ref9, ref10, ref11, ref12));
		
		Cliente cli1 = new Cliente(null, "Neiva", "96857489");
		Cliente cli2 = new Cliente(null, "Vania", "89748596");		
		
		clienteRepository.saveAll(Arrays.asList(cli1,cli2));
		
		Pedido ped1 = new Pedido(null, ref1, cli1);
		Pedido ped2 = new Pedido(null, ref2, cli2);
		
		ref1.getPedidos().addAll(Arrays.asList(ped1));
		ref2.getPedidos().addAll(Arrays.asList(ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		
		
	}

}
