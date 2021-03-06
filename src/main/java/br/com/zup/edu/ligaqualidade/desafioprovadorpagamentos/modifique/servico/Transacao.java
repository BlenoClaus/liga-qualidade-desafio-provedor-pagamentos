package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.servico;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.util.Utils;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimentoAdiantado;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;

import java.math.BigDecimal;

public interface Transacao {
	
	default String[] executar(DadosTransacao transacao, DadosRecebimentoAdiantado adiantamento) {
		return new String[] {getInfo(),
				transacao.valor.toString(),
				Utils.calcularDesconto(transacao.valor, getRate()).toString(),
				getDataTransacao()};
	}

	String getInfo();

	BigDecimal getRate();

	String getDataTransacao();

}
