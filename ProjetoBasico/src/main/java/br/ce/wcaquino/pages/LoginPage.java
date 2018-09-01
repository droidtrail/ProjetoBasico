package br.ce.wcaquino.pages;

import static br.ce.wcaquino.core.DriverFactory.getDriver;

import br.ce.wcaquino.core.BasePage;

public class LoginPage extends BasePage {
	
	public void acessarTelaInicial() {
		getDriver().get("https://seubarriga.wcaquino.me/login");
	}
	
	public void setEmail(String email) {
		escrever("email", email);
	}
	
	public void setSenha(String senha) {
		escrever("senha", senha);
	}
	
	public void entrar() {
		clicarBotaoPorTexto("Entrar");
		//clicarBotao(By.xpath(".//button[.='Entrar']"));
	}

}
