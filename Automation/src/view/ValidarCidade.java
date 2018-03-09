package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import control.Util;
import control.Validador;
import java.awt.Font;

public class ValidarCidade extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ValidarCidade frame = new ValidarCidade();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ValidarCidade() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1150, 776);
		getContentPane().setLayout(null);
		
		
		Validador validador = new Validador();
		Util util= new Util();
	
		JTextArea textAreaFile1 = new JTextArea();
		textAreaFile1.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textAreaFile1.setEditable(false);
		textAreaFile1.setBounds(31, 86, 326, 320);
		JScrollPane scrollPane = new JScrollPane(textAreaFile1);
		scrollPane.setBounds(31, 86, 450, 320);
		getContentPane().add(scrollPane);

		JTextArea textAreaFile2 = new JTextArea();
		textAreaFile2.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textAreaFile2.setBounds(479, 86, 318, 320);
		textAreaFile2.setEditable(true);
		JScrollPane scrollPane2 = new JScrollPane(textAreaFile2);
		scrollPane2.setBounds(651, 86, 450, 320);
		getContentPane().add(scrollPane2);

		
		JTextArea textAreaFile3 = new JTextArea();
		textAreaFile3.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textAreaFile3.setEditable(false);
		textAreaFile3.setBounds(31, 486, 775, 213);
		JScrollPane scrollPane3 = new JScrollPane(textAreaFile3);
		scrollPane3.setBounds(31, 514, 1070, 210);
		getContentPane().add(scrollPane3);
		
		
		JButton btnFile1 = new JButton("Estados + Cidades ");
		btnFile1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFile1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textAreaFile2.setText("");
				String path = abrirArquivo();
				if(path != null) { //So pode ler arquivo se tem caminho
					textAreaFile1.setText(util.lerArquivo(path)); //Limpa antes de Escrever
				}
				if(textAreaFile1.getText().isEmpty() ) {
					System.out.println( "Obs. Este arquivo esta vazio");
				}
				
			}

			
		});
		
		
		btnFile1.setBackground(new Color(102, 205, 170));
		btnFile1.setToolTipText("Ocorr\u00EAncia de Estados e Cidades corretos");
		btnFile1.setBounds(31, 33, 450, 40);
		getContentPane().add(btnFile1);
		
		JButton btnFile2 = new JButton("Estados + Cidades ");
		btnFile2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFile2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaFile2.setText("");
				String path = abrirArquivo();
				if(path != null) { //So pode ler arquivo se tem caminho
					textAreaFile2.setText(util.lerArquivo(path)); //Limpa antes de Escrever
				}
				
				if(textAreaFile2.getText().isEmpty() ) {
					System.out.println( "Obs. Este arquivo esta vazio");
				}
			}
		});
		btnFile2.setBackground(new Color(255, 99, 71));
		btnFile2.setToolTipText("Ocorr\u00EAncia de Estados e Cidades errados");
		btnFile2.setBounds(651, 33, 450, 40);
		getContentPane().add(btnFile2);
		
		JButton btnValidaEstadoCidade = new JButton("Valida Estados e Cidades");
		btnValidaEstadoCidade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnValidaEstadoCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Validar estado e cidades");
				textAreaFile3.setText("");
				String log =validador.tratamentoDados(textAreaFile1.getText(),
						 textAreaFile2.getText());
				textAreaFile3.setText(log);
				util.escreverLog(log);
							
			}
		});
		btnValidaEstadoCidade.setToolTipText("Clique para iniciar valida\u00E7\u00E3o de estado de cidade");
		btnValidaEstadoCidade.setBackground(Color.ORANGE);
		btnValidaEstadoCidade.setBounds(408, 447, 326, 40);
		getContentPane().add(btnValidaEstadoCidade);
		
		
		
		
	
		
		
	}

	public String abrirArquivo() {
		JFileChooser chooser = new JFileChooser();
		String path = null;
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		    "Arquivo texto .txt", "txt");
		chooser.setFileFilter(filter);
		chooser.setDialogTitle("Selecione um arquivo .txt"); //titulo
		 File currentDirectory = null;
		try {
			//TODO remover \\src\\text\\
			currentDirectory = new File(new File(".\\src\\text\\").getCanonicalPath());
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",e.getMessage());
		}
		    chooser.setCurrentDirectory(currentDirectory);

		int returnVal = chooser.showOpenDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			
		   System.out.println("Você escolheu abrir este arquivo: " +
		        chooser.getSelectedFile().getAbsolutePath());
		   path = chooser.getSelectedFile().getAbsolutePath();
		   
		}
		return path;
		
				
	}
}
