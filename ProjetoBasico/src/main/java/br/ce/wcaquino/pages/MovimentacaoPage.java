package br.ce.wcaquino.pages;

import org.openqa.selenium.By;

import br.ce.wcaquino.core.BasePage;

public class MovimentacaoPage extends BasePage {

	public void setDataMovimentacao(String dataMovimentacao) {

		escrever("data_transacao", dataMovimentacao);
	}

	public void setDataPagamento(String dataPagamento) {

		escrever("data_pagamento", dataPagamento);
	}
	
	public void setDescricao(String descricao) {

		escrever("descricao", descricao);
	}
	
	public void setInteressado(String interessado) {
		escrever("interessado", interessado);
	}
	
	public void setValor(String valor) {
		escrever("valor", valor);
	}
	
	public void setConta(String valor) {
		
		selecionarCombo("conta", valor);	
	}
	
	public void setSituacaoPago() {
		clicarRadio("status_pago");
	}
	
	public void clicarBotaoSalvar() {
		
		clicarBotaoPorTexto("Salvar");
	}
	
	public String obterMensagemSucesso() {

		return obterTexto(By.xpath(".//body/div[.='Movimentação adicionada com sucesso!']"));
	}
	
}
