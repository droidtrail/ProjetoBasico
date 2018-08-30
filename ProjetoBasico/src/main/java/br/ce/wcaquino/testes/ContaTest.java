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
	
	@Test
	public void testeAlterarConta() {
		menuPage.acessarTelaListarConta();
		
		contasPage.ClicarAlterarConta("Conta do Teste alterada 3");
		contasPage.setNome("Conta do Teste alterada 4");
		contasPage.salvar();
		
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemAlteradaSucesso());
		
	}
	@Test
	public void testeInserirContaMesmoNome() {
		
		menuPage.acessarTelaInserirConta();
		
		contasPage.setNome("Conta do Teste alterada 4");
		contasPage.salvar();
		
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
		
	}
	
	@Test
	public void testeExcluirContaComMovimentacao() {
		
		menuPage.acessarTelaListarConta();
		contasPage.ClicarExcluirConta("Conta do Teste");
		
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemContaEmUso());
		
	}

}
