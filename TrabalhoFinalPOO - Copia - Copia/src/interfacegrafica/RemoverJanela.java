package interfacegrafica;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import arquivos.ArquivoEstoque;
import colecaoDados.Estoque;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class RemoverJanela extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoverJanela frame = new RemoverJanela();
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
	public RemoverJanela() {
		setClosable(true);
		setTitle("REMOVER PRODUTOS");
		setBounds(100, 100, 685, 412);
		getContentPane().setLayout(null);
		
		JLabel lblCodigo = new JLabel("CODIGO");
		lblCodigo.setBounds(27, 34, 46, 14);
		getContentPane().add(lblCodigo);
		
		textField = new JTextField();
		textField.setBounds(83, 31, 108, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Remover");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextArea textArea = new JTextArea();
				textArea.setEditable(false);
				textArea.setBounds(27, 73, 632, 245);
				getContentPane().add(textArea);

				ArquivoEstoque<Estoque> arq=null;
				try {
					arq= new ArquivoEstoque<Estoque>("C:\\Users\\Adriano O Pinto\\workspace\\TrabalhoFinalPOO\\arquivoEstoque.txt");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} String ress=null;
				try {
					ress = arq.busca("Código do Produto: "+textField.getText()+" ");
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if(ress!=null){textArea.append("O produto abaixo foi removido:\n");
				String campos[]=ress.split(",");
				String as[] = campos[4].split(" ");
				textArea.append("\n----------------------------------------------------------------------------------\n");
				textArea.append(campos[0]+"\n"+campos[1]+"\n"+campos[2]+"\n"+campos[3]+"\nData de Entrada: "+as[4]+"/"+as[3]+"/"+as[7]+"\n");
				   if(campos[6].equals("Perecivel: true")==true && campos[7].equals("Data de Validade:null")==false){
				   String dv[] = campos[7].split(" ");
				   textArea.append("Data de Validade: "+dv[4]+"/"+dv[3]+"/"+dv[7]+"\n");}
				   else textArea.append("Data de Validade: Produto Não Perecivel\n");
				   textArea.append(campos[5]);
				   textArea.append("\n----------------------------------------------------------------------------------\n");}
				
				else textArea.append("Não existe produto informado com o Código: "+textField.getText()+"\n");
				
				String id0=textField.getText();
		    	List aa = new ArrayList();
		    	try {
					aa= arq.exclui("Código do Produto: "+id0+" ");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	//arq.del(); 
		    	int i = 0;
		    	ArquivoEstoque<Estoque> arq2 = null;
		    	try {
					arq2= new ArquivoEstoque<Estoque>("C:\\Users\\Adriano O Pinto\\workspace\\TrabalhoFinalPOO\\arquivoEstoque.txt", i);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	try {
					arq2.add(aa);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBuscar.setBounds(222, 30, 89, 23);
		getContentPane().add(btnBuscar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(293, 351, 89, 23);
		getContentPane().add(btnCancelar);
		
	}
}
