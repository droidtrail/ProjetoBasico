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
		movPage.setDescricao("Movimentação Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("500");
		movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
		movPage.setSituacaoPago();
		movPage.clicarBotaoSalvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());	
	}
	
	@Test
	public void teste2_CamposObrigatorios() {
		
		menuPage.acessarTelaCriarMovimentacao();
		movPage.clicarBotaoSalvar();
		
		List<String> erros = movPage.obterErros();
		//Assert.assertEquals("Data da Movimentação é obrigatório", erros.get(0));
		//Assert.assertTrue(erros.contains("Data da Movimentação é obrigatório"));
		//Assert.assertTrue(erros.contains("Data do pagamento é obrigatório"));
		//Assert.assertTrue(erros.contains("Descrição é obrigatório"));
		//Assert.assertTrue(erros.contains("Interessado é obrigatório"));
		//Assert.assertTrue(erros.contains("Valor é obrigatório"));
		//Assert.assertTrue(erros.contains("Valor deve ser um número"));
		
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório",
				"Data do pagamento é obrigatório",
				"Descrição é obrigatório",
				"Interessado é obrigatório",
				"Valor é obrigatório",
				"Valor deve ser um número")));
		Assert.assertEquals(6, erros.size());
	}
	
	@Test
	public void Teste3_InserirMovimentacaoFuturo() {
		
		menuPage.acessarTelaCriarMovimentacao();
		
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		
		movPage.setDataMovimentacao(DataUtils.obterDataFormatada(dataFutura));
		movPage.setDataPagamento(DataUtils.obterDataFormatada(dataFutura));
		movPage.setDescricao("Movimentação Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("500");
		movPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
		movPage.setSituacaoPago();
		movPage.clicarBotaoSalvar();
		
		List<String> erros = movPage.obterErros();
		Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
		Assert.assertEquals(1, erros.size());
		
//		Assert.assertEquals("Data da Movimentação deve ser menor ou igual à data atual", movPage.
//				obterMensagemMovimentacaoMaiorDataAtual());
		
			
	}
}
