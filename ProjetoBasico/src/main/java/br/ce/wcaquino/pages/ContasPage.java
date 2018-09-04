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

		return obterTexto(By.xpath("//div[@class='alert alert-success']"));

	}

	public String obterMensagemAlteradaSucesso() {

		return obterTexto(By.xpath(".//body/div[.='Conta alterada com sucesso!']"));

	}

	public String obterMensagemErro() {

		return obterTexto(By.xpath("//div[@class='alert alert-danger']"));

	}

	public void ClicarAlterarConta(String nomeConta) {

		obterCelula("Conta", nomeConta, "A��es", "tabelaContas")
				.findElement(By.xpath("//span[@class='glyphicon glyphicon-edit']")).click();

	}

	public void clicarExcluirConta(String string) {
		obterCelula("Conta", string, "A��es", "tabelaContas")
				.findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
	}
}
