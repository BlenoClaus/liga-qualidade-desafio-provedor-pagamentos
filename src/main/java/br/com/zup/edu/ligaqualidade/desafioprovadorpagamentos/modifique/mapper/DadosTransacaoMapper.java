package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.mapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.MetodoPagamento;

public class DadosTransacaoMapper {
	
	
	public static DadosTransacao toObject(List<String> dados) {
		
		return new DadosTransacao(
				new BigDecimal(dados.get(0)),
				MetodoPagamento.valueOf(dados.get(1)), 
				dados.get(2),
				dados.get(3), 
				LocalDate.parse(dados.get(4), DateTimeFormatter.ofPattern("dd/MM/yyyy")), 
				Integer.parseInt(dados.get(5)),
				Integer.parseInt(dados.get(6)));
	}
	
	
	public static Map<Integer, DadosTransacao> toMap(List<String> dados) {

		return dados
				.stream()
				.map(it -> toObject(Arrays.asList(it.split(","))))
				.collect(Collectors.toMap(s -> s.id, s1 -> s1));
		
	}
	
}
