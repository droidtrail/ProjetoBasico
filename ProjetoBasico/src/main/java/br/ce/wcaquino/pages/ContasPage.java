package br.ce.wcaquino.pages;

import org.openqa.selenium.By;

import br.ce.wcaquino.core.BasePage;

public class ContasPage extends BasePage {

	public void setNome(String nome) {
		escrever("nome", nome);
	}
	
	public void salvar() {	
		clicarBotao(By.xpath(".//button[.='Salvar']"));
	}
	
	public String obterMensagemSucesso() {
		
		return obterTexto(By.xpath(".//body/div[.='Conta alterada com sucesso!']"));
			
	}
	
	public void ClicarAlterarConta(String string) {
		
		obterCelula("Conta", string, "Ações", "tabelaContas")
		.findElement(By.xpath("//span[@class='glyphicon glyphicon-edit']")).click();
		
	}
}
