package br.ce.wcaquino.testes;

import static br.ce.wcaquino.core.DriverFactory.getDriver;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.ResumoPage;


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

		resumoPage.selecionarAno("2016");
		resumoPage.buscar();

		List<WebElement> elementosEncontrados = getDriver()
				.findElements(By.xpath(".//table[@id='tabelaExtrato']/tbody/tr"));
		Assert.assertEquals(0, elementosEncontrados.size());
	}

}
