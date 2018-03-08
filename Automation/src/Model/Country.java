package Model;

import java.util.ArrayList;

public class Country {

	private ArrayList<Estado_cidades>estados= new ArrayList<Estado_cidades>();
	private boolean hasAddEstado=true;

	public ArrayList<Estado_cidades> getEstados() {
		return estados;
	}

	public void setEstados(ArrayList<Estado_cidades> estados) {
		this.estados = estados;
	}
	
	public String  validaEstados(Estado_cidades estado) {
		String resultadoParcial = "";
		
		if(this.estados.size()==0) {
			System.out.println("Arquivo de estado e cidade corretos vazio");
		}else {
			for (Estado_cidades estado_cidades : estados) {
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
	 * Metodo addEstados Adiciona as cidades nos estados correspondente
	 * @param auxEstado Entada do estado no country
	 */
	public void addEstados(Estado_cidades auxEstado) {
		if(this.estados.size()==0) {
			this.estados.add(auxEstado);
		}else {
			for (Estado_cidades estado_cidades : estados) {
				
				hasAddEstado=true;
				if(estado_cidades.getSiglaEstado().equals(auxEstado.getSiglaEstado())) {
//					System.out.println(estado.getSiglaEstado() + " == "+ estado_cidades.getSiglaEstado());
					hasAddEstado=false;
					
					//// ja possui o estado 
					estado_cidades.addCidades(auxEstado.getCidades());
					
					break;
				}
			}
			if(hasAddEstado) { //adiciona uma novo estado
				this.estados.add(auxEstado);
			}
		}
	}

	@Override
	public String toString() {
		String estadosAdd= "Country [\n";
		
		for (Estado_cidades estado_cidades : estados) {
			estadosAdd+= "Estado= "+estado_cidades.getNomeEstado()+ " Siglas= "+estado_cidades.getSiglaEstado() +
					" Quantidade cidades "+ estado_cidades.getCidades().size() +"\n";
		}
		
		return estadosAdd + "]";
	}

	
	

}
 