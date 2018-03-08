package control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Util {

	
	public Util() {
		
	}
	 /**
	   * lerArquivo Ler dados de um arquivo.
	   * @return Dados lidos do arquivo.
	   */
	public String lerArquivo(String  absolutePath) {
		BufferedReader br = null;
		String txtArea = ""; //Armazena dados para textArea
		try {
			br = new BufferedReader(new FileReader(absolutePath));
			while(br.ready()){
				   String linha = br.readLine();
				   txtArea+=linha+ "\n" ;
				}
				br.close();
		} catch ( IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",e.getMessage());
		}
//		System.out.println(txtArea);
		return txtArea;
	}
	
}
