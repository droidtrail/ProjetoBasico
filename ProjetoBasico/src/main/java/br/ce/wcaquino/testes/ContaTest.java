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
	public void teste1_InserirConta() {

		menuPage.acessarTelaInserirConta();
		
		contasPage.setNome("Conta do Teste");
		contasPage.salvar();
		
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());		
	}
	
	@Test
	public void teste2_AlterarConta() {
		menuPage.acessarTelaListarConta();
		
		contasPage.ClicarAlterarConta("Conta para alterar");
		contasPage.setNome("Conta alterada");
		contasPage.salvar();
		
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemAlteradaSucesso());
		
	}
	@Test
	public void teste3_InserirContaMesmoNome() {
		
		menuPage.acessarTelaInserirConta();
		
		contasPage.setNome("Conta mesmo nome");
		contasPage.salvar();
		
		Assert.assertEquals("J� existe uma conta com esse nome!", contasPage.obterMensagemErro());
		
	}

}
