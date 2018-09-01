package br.ce.wcaquino.suites;

import static br.ce.wcaquino.core.DriverFactory.killDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.wcaquino.core.DriverFactory;
import br.ce.wcaquino.pages.LoginPage;
import br.ce.wcaquino.testes.ContaTest;
import br.ce.wcaquino.testes.MovimentacaoTeste;
import br.ce.wcaquino.testes.RemoverMovimentacaoContaTest;
import br.ce.wcaquino.testes.ResumoTeste;
import br.ce.wcaquino.testes.SaldoTeste;

@RunWith(Suite.class)
@SuiteClasses({
	
	ContaTest.class,
	MovimentacaoTeste.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTeste.class,
	ResumoTeste.class
	
})
public class SuiteGeral {
	
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void inicializa() {
		
		page.acessarTelaInicial();
		page.setEmail("cursoselenium@gmail.com");
		page.setSenha("123");
		page.entrar();
		
	}
	
	@AfterClass
	public static void finalizar() {
		
		killDriver();
	}

}
