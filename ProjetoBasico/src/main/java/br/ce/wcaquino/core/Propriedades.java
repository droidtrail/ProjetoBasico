package br.ce.wcaquino.core;

public class Propriedades {
	
	public static boolean FECHAR_BROWSER = true;
	
	public static Browsers browser = Browsers.FIREFOX;
	
	public static String NOME_CONTA_ALTERADA = "Conta Alterada" + System.nanoTime();//Nome da conta alterada ser� sempre diferente para que eu n�o precise deletar a conta para executar o teste novamente
	
	public enum Browsers{
		CHROME,
		FIREFOX,
		SAFARI,
		EDGE,
		INTERNETEXPLORER
	}
}
