package interfacegrafica;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import arquivos.ArquivoEstoque;
import colecaoDados.Estoque;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Imprimi extends JInternalFrame {
	/**
	 * @wbp.nonvisual location=665,39
	 */
	private final Component verticalStrut = Box.createVerticalStrut(20);
	private final JButton btnSair = new JButton("Sair");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Imprimi frame = new Imprimi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Imprimi() throws Exception {
		setResizable(true);
		setClosable(true);
		setTitle("Produtos Cadastrados");
		setBounds(100, 100, 695, 402);
		
		JTextArea txtrAreatext = new JTextArea();
		txtrAreatext.setWrapStyleWord(true);
		txtrAreatext.setEditable(false);
		getContentPane().add(txtrAreatext, BorderLayout.CENTER);
		txtrAreatext.setLineWrap(true);
		
		ArquivoEstoque<Estoque> arq= new ArquivoEstoque<Estoque>("C:\\Users\\Adriano O Pinto\\workspace\\TrabalhoFinalPOO\\arquivoEstoque.txt");

		List a = new Estoque();
    	a=arq.get();
    	String linha[] = null;String[] campos = null;
		for(int i =0;i<a.size();i++){
			campos = a.get(i).toString().split(",");
			String as[] = campos[4].split(" ");
			txtrAreatext.append("\n----------------------------------------------------------------------------------\n");
			txtrAreatext.append(campos[0]+"\n"+campos[1]+"\n"+campos[2]+"\n"+campos[3]+"\nData de Entrada: "+as[4]+"/"+as[3]+"/"+as[7]+"\n");
			   if(campos[6].equals("Perecivel: true")==true && campos[7].equals("Data de Validade:null")==false){
			   String dv[] = campos[7].split(" ");
			   txtrAreatext.append("Data de Validade: "+dv[4]+"/"+dv[3]+"/"+dv[7]+"\n");}
			   else txtrAreatext.append("Data de Validade: Produto Não Perecivel\n");
			   txtrAreatext.append(campos[5]);
			}
		JScrollPane x = new JScrollPane(txtrAreatext);
		getContentPane().add(x, BorderLayout.CENTER);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		x.setColumnHeaderView(btnSair);
	}
}
