package br.ce.wcaquino.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.wcaquino.testes.ContaTest;
import br.ce.wcaquino.testes.MovimentacaoTeste;
import br.ce.wcaquino.testes.RemoverMovimentacaoContaTest;
import br.ce.wcaquino.testes.ResumoTeste;
import br.ce.wcaquino.testes.SaldoTeste;

@RunWith(Suite.class)
@SuiteClasses({

		ContaTest.class, MovimentacaoTeste.class, RemoverMovimentacaoContaTest.class, SaldoTeste.class,
		ResumoTeste.class

})
public class SuiteGeral {

}
