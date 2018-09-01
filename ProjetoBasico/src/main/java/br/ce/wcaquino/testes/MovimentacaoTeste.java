package br.ce.wcaquino.testes;

import static br.ce.wcaquino.utils.DataUtils.obterDataFormatada;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.core.Propriedades;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.MovimentacaoPage;
import br.ce.wcaquino.utils.DataUtils;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTeste extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage= new MovimentacaoPage();
	
	@Test
	public void teste1_InserirMovimentacao() {
		
		menuPage.acessarTelaCriarMovimentacao();
		
		movPage.setDataMovimentacao(obterDataFormatada(new Date()));
		movPage.setDataPagamento(obterDataFormatada(new Date()));
		movPage.setDescricao("Movimenta��o Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("500");
		movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
		movPage.setSituacaoPago();
		movPage.clicarBotaoSalvar();
		
		Assert.assertEquals("Movimenta��o adicionada com sucesso!", movPage.obterMensagemSucesso());	
	}
	
	@Test
	public void teste2_CamposObrigatorios() {
		
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
	public void Teste3_InserirMovimentacaoFuturo() {
		
		menuPage.acessarTelaCriarMovimentacao();
		
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		
		movPage.setDataMovimentacao(DataUtils.obterDataFormatada(dataFutura));
		movPage.setDataPagamento(DataUtils.obterDataFormatada(dataFutura));
		movPage.setDescricao("Movimenta��o Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("500");
		movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
		movPage.setSituacaoPago();
		movPage.clicarBotaoSalvar();
		
		List<String> erros = movPage.obterErros();
		Assert.assertTrue(erros.contains("Data da Movimenta��o deve ser menor ou igual � data atual"));
		Assert.assertEquals(1, erros.size());
		
//		Assert.assertEquals("Data da Movimenta��o deve ser menor ou igual � data atual", movPage.
//				obterMensagemMovimentacaoMaiorDataAtual());
		
			
	}
}
