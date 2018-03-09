package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
	/**
	 * Metodo para salvar o log da aplicacao em txt
	 * @param log historico do log
	 * @throws IOException 
	 */
	public void escreverLog(String log){
		
		File arquivo = null;
		try {
			arquivo = new File(new File(".\\src\\text\\log.txt").getCanonicalPath());
			
			if(!arquivo.exists()) {
				arquivo.createNewFile();//cria um arquivo (vazio)
			}
			
		} catch (IOException e1) {
			System.out.println("Erro ao recuperar o path do log "+ e1.getMessage());
			e1.printStackTrace();
		}

			
	        BufferedWriter buffWrite = null;
	     
	        
			try {
				 //construtor que recebe o objeto do tipo arquivo
		        FileWriter fw = new FileWriter( arquivo );
				buffWrite = new BufferedWriter(fw);
				String linha = "";
		        System.out.println("Escreva Log: " + log);

		        buffWrite.write(log + "\n");
		        buffWrite.close();
		        fw.close();
			} catch (FileNotFoundException e) {
				System.out.println("Erro ao escrever o log "+ e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	    
		
	}
	
}
