package br.ce.wcaquino.pages;

import org.openqa.selenium.By;

import br.ce.wcaquino.core.BasePage;

public class ContasPage extends BasePage {

	public void setNome(String nome) {
		escrever("nome", nome);
	}

	public void salvar() {
		clicarBotaoPorTexto("Salvar");
	}

	public String obterMensagemSucesso() {

		return obterTexto(By.xpath(".//body/div[.='Conta adicionada com sucesso!']"));

	}
	
	public String obterMensagemAlteradaSucesso() {

		return obterTexto(By.xpath(".//body/div[.='Conta alterada com sucesso!']"));

	}

	public String obterMensagemErro() {

		return obterTexto(By.xpath(".//body/div[.='Já existe uma conta com esse nome!']"));

	}

	public void ClicarAlterarConta(String string) {

		obterCelula("Conta", string, "Ações", "tabelaContas")
				.findElement(By.xpath("//span[@class='glyphicon glyphicon-edit']")).click();

	}
}
