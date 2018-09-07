package br.ce.wcaquino.core;

public class Propriedades {
	
	public static boolean FECHAR_BROWSER = true;
	
	public static Browsers BROWSER = Browsers.IE;
	
	public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.LOCAL;
	
	public enum Browsers{
		CHROME,
		FIREFOX,
		IE,
		EDGE
		
	}
	
	public enum TipoExecucao{
		
		LOCAL,
		GRID,
		NUVEM
		
	}
}
