package br.ce.wcaquino.testes;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.ResumoPage;

public class ResumoTeste extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ResumoPage resumoPage = new ResumoPage();
	
	@Test
	public void TesteExcluirMovimentacao() {
		
		menuPage.acessarTelaResumo();
		
		resumoPage.excluirMovimentacao();
	
		Assert.assertEquals("Movimentação removida com sucesso!",
				resumoPage.obterMensagemMovimentacaoExcluidaSucesso());
		
	}

}
