package interfacegrafica;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Rectangle;
import javax.swing.UIManager;

import arquivos.ArquivoEstoque;
import classesbasicas.Produto;
import colecaoDados.Estoque;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class CadastroJanela1 extends JInternalFrame {
	private JTextField nomeField;
	private JTextField quantidadeField;
	private JTextField descricaoField;
	private JTextField validadeField;
	private JTextField precoField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroJanela1 frame = new CadastroJanela1();
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
	public CadastroJanela1() {
		setTitle("Cadastro");
		setToolTipText("");
		setClosable(true);
		setBounds(100, 100, 677, 438);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 45, 46, 14);
		getContentPane().add(lblNome);
		
		nomeField = new JTextField();
		nomeField.setBounds(51, 45, 498, 20);
		getContentPane().add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(10, 87, 81, 14);
		getContentPane().add(lblQuantidade);
		
		quantidadeField = new JTextField();
		quantidadeField.setBounds(88, 84, 58, 20);
		getContentPane().add(quantidadeField);
		quantidadeField.setColumns(10);
		
		JLabel lblDescrioItem = new JLabel("Descri\u00E7\u00E3o item");
		lblDescrioItem.setBounds(10, 130, 97, 14);
		getContentPane().add(lblDescrioItem);
		
		descricaoField = new JTextField();
		descricaoField.setBounds(107, 127, 498, 20);
		getContentPane().add(descricaoField);
		descricaoField.setColumns(10);
		
		JLabel lblValidade = new JLabel("Validade (dd/mm/aaaa)");
		lblValidade.setBounds(10, 210, 150, 23);
		getContentPane().add(lblValidade);
		
		validadeField = new JTextField();
		validadeField.setBounds(170, 211, 109, 20);
		getContentPane().add(validadeField);
		validadeField.setColumns(10);
		
		
		JLabel lblPerecvel = new JLabel("Perec\u00EDvel");
		lblPerecvel.setBounds(10, 177, 58, 14);
		getContentPane().add(lblPerecvel);
		ButtonGroup asd=new ButtonGroup();
		JRadioButton rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.setBounds(74, 173, 109, 23);
		getContentPane().add(rdbtnSim);
		
		JRadioButton rdbtnNo = new JRadioButton("N\u00E3o");
		rdbtnNo.setBounds(182, 173, 109, 23);
		getContentPane().add(rdbtnNo);
		
		asd.add(rdbtnSim);
		asd.add(rdbtnNo);
		if(rdbtnSim.isSelected()) rdbtnNo.setEnabled(false);
		else if (rdbtnNo.isSelected()) rdbtnSim.setEnabled(false);
		
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estoque lista=  new Estoque();
				ArquivoEstoque<Estoque> arq = null;
				try {
					arq= new ArquivoEstoque<Estoque>("C:\\Users\\Adriano O Pinto\\workspace\\TrabalhoFinalPOO\\arquivoEstoque.txt");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Scanner sc = new Scanner(System.in);
				Produto aux = new Produto();
		    	try {
					aux.setId(arq.calcID());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				String nome = nomeField.getText();
				String quantidade = null;
				
				quantidade = quantidadeField.getText();
				String decricao = descricaoField.getText();
				String preco = precoField.getText();
				String validade=validadeField.getText();
				aux.setNome(nome);
				try{
				aux.setQtde(Integer.parseInt(quantidade));
				}catch(java.lang.NumberFormatException e2){e2.printStackTrace();JOptionPane.showMessageDialog(null, "<Você inseriu uma quantidade invalida>", "Atenção!!!",JOptionPane.INFORMATION_MESSAGE);}
				aux.setDescricao(decricao);
				try{
				aux.setValor(Float.parseFloat(preco));}catch(java.lang.NumberFormatException e2){e2.printStackTrace();}
				Date x = new Date(); aux.setEntrada(x);
				if(rdbtnNo.isSelected()) aux.setPerecivel(false);
				else if(rdbtnSim.isSelected()) {aux.setPerecivel(true);
				try {
			    	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");  
			    	Date dt = df.parse(validade);
			    	aux.setValidade(dt);
			        } catch (Exception ex) {ex.printStackTrace();}}
				lista.cadastrarProduto(aux);
		    	try {
					arq.add2(aux);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				JOptionPane.showMessageDialog(null, "Incluido com sucesso !!", "Atenção!!!",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnSalvar.setBounds(207, 292, 97, 36);
		getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(348, 292, 97, 36);
		getContentPane().add(btnCancelar);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(10, 258, 46, 14);
		getContentPane().add(lblPreo);
		
		precoField = new JTextField();
		precoField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		precoField.setBounds(66, 255, 58, 20);
		getContentPane().add(precoField);
		precoField.setColumns(10);
		
		

	}
}
