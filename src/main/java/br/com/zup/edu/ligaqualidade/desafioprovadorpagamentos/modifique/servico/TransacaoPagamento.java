package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.servico;

import java.math.BigDecimal;

public enum TransacaoPagamento  {
	DEBITO {
		@Override
		public Transacao instance(BigDecimal rate) {
			return Debito.INSTANCE;
		}
	},
	CREDITO {
		@Override
		public Transacao instance(BigDecimal rate) {
			return Credito.newInstance(rate);
		}
	};
	
	public abstract Transacao instance(BigDecimal rate);
}
