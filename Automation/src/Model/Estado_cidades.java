package Model;

import java.util.ArrayList;

public class Estado_cidades {
//	Acre|AC|Brasileia
	private ArrayList<String> cidades = new ArrayList<String>();
	private String nomeEstado;
	private String siglaEstado;
	
	
	public ArrayList<String> getCidades() {
		return cidades;
	}
	public void setCidades(String cidades) {
		this.cidades.add(cidades);
		
	}
	public void addCidades( ArrayList<String> cidades) {
		this.cidades.addAll(cidades);
		
	}
	public String getNomeEstado() {
		return nomeEstado;
	}
	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}
	public String getSiglaEstado() {
		return siglaEstado;
	}
	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}
	@Override
	public String toString() {
		String  addCidades="cidades= ";
//		for (String cidade : cidades) {
//			cidade+= " "+cidade+"\n";
//		}
		return "Estado_cidades ["+ addCidades + ", nomeEstado=" + nomeEstado + ", siglaEstado=" + siglaEstado
				+ "]\n";
	}
	
}
