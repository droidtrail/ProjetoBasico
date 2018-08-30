package br.ce.wcaquino.testes;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.MovimentacaoPage;
import br.ce.wcaquino.utils.DataUtils;


public class MovimentacaoTeste extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage= new MovimentacaoPage();
	
	@Test
	public void testeInserirMovimentacao() {
		
		menuPage.acessarTelaCriarMovimentacao();
		
		movPage.setDataMovimentacao("29/08/2018");
		movPage.setDataPagamento("30/08/2018");
		movPage.setDescricao("Movimenta��o Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("500");
		movPage.setConta("Conta do Teste alterada 4");
		movPage.setSituacaoPago();
		movPage.clicarBotaoSalvar();
		
		Assert.assertEquals("Movimenta��o adicionada com sucesso!", movPage.obterMensagemSucesso());	
	}
	
	@Test
	public void testeCamposObrigatorios() {
		
		menuPage.acessarTelaCriarMovimentacao();
		movPage.clicarBotaoSalvar();
		
		List<String> erros = movPage.obterErros();
		//Assert.assertEquals("Data da Movimenta��o � obrigat�rio", erros.get(0));
		//Assert.assertTrue(erros.contains("Data da Movimenta��o � obrigat�rio"));
		//Assert.assertTrue(erros.contains("Data do pagamento � obrigat�rio"));
		//Assert.assertTrue(erros.contains("Descri��o � obrigat�rio"));
		//Assert.assertTrue(erros.contains("Interessado � obrigat�rio"));
		//Assert.assertTrue(erros.contains("Valor � obrigat�rio"));
		//Assert.assertTrue(erros.contains("Valor deve ser um n�mero"));
		
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimenta��o � obrigat�rio",
				"Data do pagamento � obrigat�rio",
				"Descri��o � obrigat�rio",
				"Interessado � obrigat�rio",
				"Valor � obrigat�rio",
				"Valor deve ser um n�mero")));
		Assert.assertEquals(6, erros.size());
	}
	
	@Test
	public void TesteInserirMovimentacaoFuturo() {
		
		menuPage.acessarTelaCriarMovimentacao();
		
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		
		movPage.setDataMovimentacao(DataUtils.obterDataFormatada(dataFutura));
		movPage.setDataPagamento(DataUtils.obterDataFormatada(dataFutura));
		movPage.setDescricao("Movimenta��o Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("500");
		movPage.setConta("Conta do Teste alterada 4");
		movPage.setSituacaoPago();
		movPage.clicarBotaoSalvar();
		
		List<String> erros = movPage.obterErros();
		Assert.assertTrue(erros.contains("Data da Movimenta��o deve ser menor ou igual � data atual"));
		Assert.assertEquals(1, erros.size());
		
//		Assert.assertEquals("Data da Movimenta��o deve ser menor ou igual � data atual", movPage.
//				obterMensagemMovimentacaoMaiorDataAtual());
		
			
	}
}
