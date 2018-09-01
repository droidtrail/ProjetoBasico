package br.ce.wcaquino.testes;

import static br.ce.wcaquino.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.sun.xml.internal.bind.v2.runtime.Name;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.core.DriverFactory;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.ResumoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTeste extends BaseTest {

	MenuPage menuPage = new MenuPage();
	ResumoPage resumoPage = new ResumoPage();

	@Test
	public void Teste1_ExcluirMovimentacao() {

		menuPage.acessarTelaResumo();

		resumoPage.excluirMovimentacao();

		Assert.assertEquals("Movimentação removida com sucesso!",
				resumoPage.obterMensagemMovimentacaoExcluidaSucesso());

	}

	@Test
	public void teste2_ResumoMensal() {

		menuPage.acessarTelaResumo();

		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());

	}

}
