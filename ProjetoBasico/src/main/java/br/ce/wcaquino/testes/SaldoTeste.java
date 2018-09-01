package br.ce.wcaquino.testes;

import org.junit.Assert;
import org.junit.Test;
import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.HomePage;


public class SaldoTeste extends BaseTest {
	
	HomePage homePage = new HomePage();
	
	@Test
	public void testeSaldoConta() {
		
		Assert.assertEquals("800.00", homePage.obterSaldoConta("Conta do Teste"));		
	}

}
