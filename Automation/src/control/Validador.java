package control;

import Model.Country;
import Model.Estado_cidades;

public class Validador {
	private Country brasil= new Country();
//	Acre|AC|Brasileia
	
	public void povoarEstados(String dadosCorretos) {
		
		
		String [] arrayOfLines = dadosCorretos.split("\n");
//		System.out.println(arrayOfLines.length);
		Estado_cidades estado ;
		for (String linha : arrayOfLines) {
//			System.out.println(linha);
			String [] dadosEstadoCidade = linha.split("\\|");
			estado =  new Estado_cidades();// Sempre haverar uma cidade no vetor
			estado.setNomeEstado(dadosEstadoCidade[0]);
			estado.setSiglaEstado(dadosEstadoCidade[1]);
			estado.setCidades(dadosEstadoCidade[2]);
			
			brasil.addEstados(estado);
		}
//		System.out.println(estado.toString());
		System.out.println(brasil.toString());
	}

	/**
	 * Metodo tratamentoDados trata os dados lidos dos arquivos
	 * @param dadosCorretos Estados + cidades corretos
	 * @param dadosErrados  Estados + cidades errados
	 * @param resultados    Resultados da comparacao (dadosCorretos e dadosErrados)
	 */
	
	public void tratamentoDados(String dadosCorretos, String dadosErrados, String resultados) {
		povoarEstados(dadosCorretos);
		
	}


	


	
}
