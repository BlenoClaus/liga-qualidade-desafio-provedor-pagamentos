package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.servico;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.mapper.DadosRecebimentoAdiantadoMapper;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.mapper.DadosTransacaoMapper;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimentoAdiantado;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;

public class TransacaoPagamentoService {
	
	public static List<String[]> processar(List<String> infoTransacoes, List<String> infoAdiantamentos) {
		Map<Integer, DadosTransacao> transacoes = DadosTransacaoMapper.toMap(infoTransacoes);
		Map<Integer, DadosRecebimentoAdiantado> adiantamentos = DadosRecebimentoAdiantadoMapper.toMap(infoAdiantamentos);
		
		return transacoes.values().stream().map(transacao -> {
			DadosRecebimentoAdiantado adiantamento = getAdiantamento(transacao.id, adiantamentos);
			return getTransacao(transacao,adiantamento).executar(transacao, adiantamento);
		}).collect(Collectors.toList());
	}

	public static DadosRecebimentoAdiantado getAdiantamento(Integer transacao, Map<Integer, DadosRecebimentoAdiantado> adiantamentos) {
		return adiantamentos.getOrDefault(transacao, new DadosRecebimentoAdiantado(transacao, new BigDecimal("0.05"))) ;
	}
	
	public static Transacao getTransacao(DadosTransacao transacao, DadosRecebimentoAdiantado adiantamento) {
		return TransacaoPagamento.valueOf(transacao.metodo.name()).instance(adiantamento.taxa);
	}
	

}
