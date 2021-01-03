package interfacegrafica;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import arquivos.ArquivoEstoque;
import colecaoDados.Estoque;

import javax.swing.JEditorPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class PesquisarJanela extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisarJanela frame = new PesquisarJanela();
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
	public PesquisarJanela() {
		setClosable(true);
		setBounds(100, 100, 683, 420);
		getContentPane().setLayout(null);
		
		JLabel lblCadastrandoProduto = new JLabel("PESQUISA DE PRODUTOS - MARQUE A OP\u00C7\u00C3O DESEJADA");
		lblCadastrandoProduto.setForeground(Color.BLUE);
		lblCadastrandoProduto.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCadastrandoProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrandoProduto.setBounds(104, 11, 496, 50);
		getContentPane().add(lblCadastrandoProduto);
		
		JLabel lblPesquisar = new JLabel("C\u00F3digo do Produto: ");
		lblPesquisar.setBounds(25, 77, 118, 14);
		getContentPane().add(lblPesquisar);
		
		textField = new JTextField();
		textField.setBounds(144, 72, 109, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel Nome = new JLabel("Nome: ");
		Nome.setBounds(88, 153, 46, 14);
		getContentPane().add(Nome);
		
		textField_1 = new JTextField();
		textField_1.setBounds(144, 150, 109, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		ButtonGroup asd=new ButtonGroup();
		JRadioButton rdbtnSim = new JRadioButton("");
		rdbtnSim.setBounds(259, 68, 109, 23);
		getContentPane().add(rdbtnSim);
		
		JRadioButton rdbtnNo = new JRadioButton("");
		rdbtnNo.setBounds(259, 147, 109, 23);
		getContentPane().add(rdbtnNo);
		
		asd.add(rdbtnSim);
		asd.add(rdbtnNo);
		if(rdbtnSim.isSelected()) rdbtnNo.setEnabled(false);
		else if (rdbtnNo.isSelected()) rdbtnSim.setEnabled(false);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextArea textArea = new JTextArea();
				textArea.setEditable(false);
				textArea.setBounds(10, 192, 647, 187);
				getContentPane().add(textArea);
				
				ArquivoEstoque<Estoque> arq = null;
				try {
					arq= new ArquivoEstoque<Estoque>("C:\\Users\\Adriano O Pinto\\workspace\\TrabalhoFinalPOO\\arquivoEstoque.txt");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(rdbtnSim.isSelected()){
				String id1=textField.getText(); String ress=null;
				try {
					ress = arq.busca("Código do Produto: "+id1+" ");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(ress!=null){textArea.append("O produto com o ID informado é:\n");
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
				
				else textArea.append("Não existe produto informado com o Código: "+id1+"\n");
				}
				else if(rdbtnNo.isSelected()){
					String nome=textField_1.getText();
					String resul = null;
					try {
						resul = arq.buscaNome("Nome: "+nome);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(resul!=null){textArea.append("O produto com o Nome informado é:\n");
					String campos[]=resul.split(",");
					String as[] = campos[4].split(" ");
					textArea.append("\n----------------------------------------------------------------------------------\n");
					textArea.append(campos[0]+"\n"+campos[1]+"\n"+campos[2]+"\n"+campos[3]+"\nData de Entrada: "+as[4]+"/"+as[3]+"/"+as[7]+"\n");
					   if(campos[6].equals("Perecivel: true")==true && campos[7].equals("Data de Validade:null")==false){
					   String dv[] = campos[7].split(" ");
					   textArea.append("Data de Validade: "+dv[4]+"/"+dv[3]+"/"+dv[7]+"\n");}
					   else textArea.append("Data de Validade: Produto Não Perecivel\n");
					   textArea.append(campos[5]);
					   textArea.append("\n----------------------------------------------------------------------------------\n");}
					else textArea.append("Não existe produto informado com o Nome: "+nome+"\n");
				}
			}
		});
		btnPesquisar.setBounds(377, 111, 109, 23);
		getContentPane().add(btnPesquisar);
		
		JLabel lblOu = new JLabel("OU");
		lblOu.setForeground(Color.BLUE);
		lblOu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOu.setBounds(178, 113, 46, 14);
		getContentPane().add(lblOu);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(511, 111, 89, 23);
		getContentPane().add(btnSair);
		
		

	}
}
