package br.ce.wcaquino.core;

public class Propriedades {
	
	public static boolean FECHAR_BROWSER = true;
	
	public static Browsers BROWSER = Browsers.CHROME;
	
	public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.GRID;
	
	public enum Browsers{
		CHROME,
		FIREFOX,
		SAFARI,
		EDGE,
		INTERNETEXPLORER
	}
	
	public enum TipoExecucao{
		
		LOCAL,
		GRID
	}
}
