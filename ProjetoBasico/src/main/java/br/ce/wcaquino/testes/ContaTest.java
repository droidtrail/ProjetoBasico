package br.ce.wcaquino.testes;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.ContasPage;
import br.ce.wcaquino.pages.MenuPage;


//Herda de BaseTest as informações de login
public class ContaTest extends BaseTest {

	MenuPage   menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();

	@Test
	public void testeInserirConta() {

		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta do Teste");
		contasPage.salvar();
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());		
	}
	

}
