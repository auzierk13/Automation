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
			if(!linha.isEmpty()) {
//			System.out.println(linha);
			String [] dadosEstadoCidade = linha.split("\\|");
			estado =  new Estado_cidades();// Sempre haverar uma cidade no vetor
			estado.setNomeEstado(dadosEstadoCidade[0]);
			estado.setSiglaEstado(dadosEstadoCidade[1]);
			estado.setCidades(dadosEstadoCidade[2]);
			
			brasil.addEstados(estado);
			}
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
	public String  validaEstados(Estado_cidades auxEstado) {
		String resultadoParcial = "";
		
		if(brasil.getEstados().size()==0) {
			System.out.println("Arquivo de estados e cidades corretos estar vazio");
		}else {
			 boolean hasSiglaErrada = true;
			 boolean hasEstadoErrada = true;
			 
			for (Estado_cidades estado_cidades : brasil.getEstados()) {
				boolean hasCidadeErrada = true;
			
				//Valida siglas
				if(estado_cidades.getSiglaEstado().equals(auxEstado.getSiglaEstado())) {
					hasSiglaErrada = false;
				}
				
				///End valida siglas
				
				//Valida estado
				if(estado_cidades.getNomeEstado().equals(auxEstado.getNomeEstado())) {
					hasEstadoErrada = false;
				}
				
				///End valida estado
				
				
				//Valida cidades 
				if(estado_cidades.getSiglaEstado().equals(auxEstado.getSiglaEstado())) {
					ArrayList<String> compararCidades = estado_cidades.getCidades();
					
					for (String cidade : compararCidades) {//Loop para comparar cidades escritas corretamente
						if(cidade.equals(auxEstado.getCidades().get(0))) {
//							System.out.println("Cidade Correta");
							hasCidadeErrada=false;
							break;
						}
					}
					if(hasCidadeErrada) {
						resultadoParcial="Error na cidade "+auxEstado.getCidades().get(0)+ " cidade nao encontrada no estado " + auxEstado.getNomeEstado() ;
						hasCidadeErrada=true;
					}
				}//end Valida Cidade
				
				
			}
			if(hasSiglaErrada) {
				
				resultadoParcial="Error na sigla "+auxEstado.getSiglaEstado()+ " nao encontrada no estado " + auxEstado.getNomeEstado() ;
				hasSiglaErrada=true;
			}
			
			if(hasEstadoErrada) {
				
				resultadoParcial="Error no estado "+auxEstado.getNomeEstado()+ " Estado nao encontrada " ;
				hasEstadoErrada=true;
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
