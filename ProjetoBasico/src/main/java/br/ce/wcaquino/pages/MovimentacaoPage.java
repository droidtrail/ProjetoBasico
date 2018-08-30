package br.ce.wcaquino.pages;

import static br.ce.wcaquino.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
	
	public List<String> obterErros(){
		List <WebElement> erros = getDriver().findElements(By.xpath(".//div[@class='alert alert-danger']/ul/li"));
		List<String> retorno = new ArrayList<String>();
		for(WebElement erro: erros) {
			
			retorno.add(erro.getText());
		}
		return retorno;
	}
	
	public String obterMensagemMovimentacaoMaiorDataAtual() {
		
		return obterTexto(By.xpath(".//div[@class='alert alert-danger']/ul/li"));
	}
	
}
