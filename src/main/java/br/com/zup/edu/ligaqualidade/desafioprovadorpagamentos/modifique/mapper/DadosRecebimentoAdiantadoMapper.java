package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.mapper;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimentoAdiantado;

public class DadosRecebimentoAdiantadoMapper {
	
	public static DadosRecebimentoAdiantado toObject(List<String> dados) {
		
		return new DadosRecebimentoAdiantado(
				Integer.parseInt(dados.get(0)), 
				new BigDecimal(dados.get(1)));
	}
	
	public static Map<Integer,DadosRecebimentoAdiantado> toMap(List<String> dados) {
		return dados
				.stream()
				.map(it -> toObject(Arrays.asList(it.split(","))))
				.collect(Collectors.toMap(s -> s.idTransacao, s1 -> s1));
		
	}

}
