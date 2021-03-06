package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.servico;

import java.math.BigDecimal;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.util.Utils;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimentoAdiantado;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;

public class Credito implements Transacao {

	private String info = "aguardando_pagamento";
	private BigDecimal rate = new BigDecimal("0.05");

	public Credito() {
	}

	public Credito(String info, BigDecimal rate) {
		this.info = info;
		this.rate = rate;
	}


	@Override
	public String getInfo() {
		return info;
	}

	@Override
	public BigDecimal getRate() {
		return rate;
	}

	@Override
	public String getDataTransacao() {
		return Utils.getDataTransacaoCredito();
	}

	public static final Transacao newInstance(BigDecimal rate) {
		return rate.equals(rate) ?  new Credito() : new Credito("pago", rate);
	}

}
