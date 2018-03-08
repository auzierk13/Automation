package control;

import java.util.ArrayList;

import Model.Country;
import Model.Estado_cidades;

public class Validador {
	private Country brasil= new Country();
//	Acre|AC|Brasileia
	
	/**
	 * Metodo povoarEstados povoa estrutura de dados para futura comparacao
	 * @param dadosCorretos Leitura do arqivo correto
	 */
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
		System.out.println(brasil.toString());
	}
	
	/**
	 * Metodo comparadorEstadoCidade compara estados e cidades
	 * @param dadosErrados
	 * @return
	 */
	public String comparadorEstadoCidade(String dadosErrados) {

		String [] arrayOfLines = dadosErrados.split("\n");
		Estado_cidades estado ;
		String resultadosFinal="";
		int i=0;
		for (String linha : arrayOfLines) {
			i++;
//			System.out.println(linha);
			if(!linha.isEmpty()) {
				String [] dadosEstadoCidade = linha.split("\\|");
				estado =  new Estado_cidades();// Sempre haverar uma cidade no vetor
				estado.setNomeEstado(dadosEstadoCidade[0]);
				estado.setSiglaEstado(dadosEstadoCidade[1]);
				estado.setCidades(dadosEstadoCidade[2]);
				String resultadoParcial= validaEstados(estado); 
				if(!resultadoParcial.isEmpty()) {
					resultadosFinal+= "Erro na linha "+i +": "+ resultadoParcial+ "\n";
				}
					
			}else{
				resultadosFinal+="Erro na linha "+ i + ": Linha em branco \n";
			}
			
			
		}
		System.out.println(resultadosFinal );
		return resultadosFinal;
	}
	public String  validaEstados(Estado_cidades estado) {
		String resultadoParcial = "";
		
		if(brasil.getEstados().size()==0) {
			System.out.println("Arquivo de estado e cidade corretos vazio");
		}else {
			for (Estado_cidades estado_cidades : brasil.getEstados()) {
				boolean hasCidadeErrada = true;
				if(estado_cidades.getSiglaEstado().equals(estado.getSiglaEstado())) {
					ArrayList<String> compararCidades = estado_cidades.getCidades();
					
					for (String cidade : compararCidades) {//Loop para comparar cidades escritas corretamente
						if(cidade.equals(estado.getCidades().get(0))) {
//							System.out.println("Cidade Correta");
							hasCidadeErrada=false;
							break;
						}
					}
					if(hasCidadeErrada) {
						resultadoParcial="Error na cidade "+estado.getCidades().get(0);
						hasCidadeErrada=true;
					}
				}
			}
			
			
		}
		return resultadoParcial;
	}

	/**
	 * Metodo tratamentoDados trata os dados lidos dos arquivos
	 * @param dadosCorretos Estados + cidades corretos
	 * @param dadosErrados  Estados + cidades errados
	 * @param resultados    Resultados da comparacao (dadosCorretos e dadosErrados)
	 */
	
	public String  tratamentoDados(String dadosCorretos, String dadosErrados) {
		String resultados ="";
		if(!dadosCorretos.isEmpty() && !dadosErrados.isEmpty()) {
			povoarEstados(dadosCorretos);
			resultados = comparadorEstadoCidade(dadosErrados);
		}else {
			if(dadosCorretos.isEmpty() || dadosErrados.isEmpty() ) {
				resultados= "Obs. Este arquivo esta vazio";
			}
		}
		
		return resultados; 
		
	}


	


	
}
