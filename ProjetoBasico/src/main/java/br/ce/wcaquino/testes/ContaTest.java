package br.ce.wcaquino.testes;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.ContasPage;
import br.ce.wcaquino.pages.MenuPage;

//Herda de BaseTest as informa��es de login
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
	
	@Test
	public void testeAlterarConta() {
		menuPage.acessarTelaListarConta();
		
		contasPage.ClicarAlterarConta("Conta do Teste alterada");
		contasPage.setNome("Conta do Teste alterada 2");
		contasPage.salvar();
		
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
		
	}

}
