package interfacegrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.OptionPaneUI;

import interfacegrafica.CadastroJanela1;
import interfacegrafica.Imprimi;
import interfacegrafica.PesquisarJanela;
import interfacegrafica.RemoverJanela;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;

import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.SystemColor;

public class JanelaPrincipal extends JFrame{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal frame = new JanelaPrincipal();
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
	public JanelaPrincipal() {
		setResizable(false);
		setTitle("CONTROLE DE ESTOQUE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 579);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.inactiveCaption);
		desktopPane.setBounds(0, 0, 850, 540);
		contentPane.add(desktopPane);
		
		JButton btnNewButton_2 = new JButton("IMPRIMIR");
		btnNewButton_2.setBounds(297, 11, 282, 197);
		desktopPane.add(btnNewButton_2);
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Adriano O Pinto\\workspace\\TrabalhoFinalPOO\\src\\Imagens\\print.png"));
		
		JButton btnSair = new JButton("SAIR");
		btnSair.setIcon(new ImageIcon("C:\\Users\\Adriano O Pinto\\workspace\\TrabalhoFinalPOO\\src\\Imagens\\images.jpg"));
		btnSair.setBounds(633, 11, 207, 197);
		desktopPane.add(btnSair);
		
		JButton btnPesquisar = new JButton("PESQUISAR");
		btnPesquisar.setBounds(633, 327, 207, 178);
		desktopPane.add(btnPesquisar);
		btnPesquisar.setIcon(new ImageIcon("C:\\Users\\Adriano O Pinto\\workspace\\TrabalhoFinalPOO\\src\\Imagens\\pesquisar.jpg"));
		
		JButton btnRemover = new JButton("REMOVER");
		btnRemover.setBounds(0, 327, 281, 178);
		desktopPane.add(btnRemover);
		btnRemover.setIcon(new ImageIcon("C:\\Users\\Adriano O Pinto\\workspace\\TrabalhoFinalPOO\\src\\Imagens\\remove-.png"));
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setBounds(0, 11, 287, 242);
		desktopPane.add(btnCadastrar);
		btnCadastrar.setIcon(new ImageIcon("C:\\Users\\Adriano O Pinto\\workspace\\TrabalhoFinalPOO\\src\\Imagens\\cadastro.png"));
		
		JLabel lblCadastrarProdutoNo = new JLabel("Cadastrar Produto no Estoque");
		lblCadastrarProdutoNo.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblCadastrarProdutoNo.setBounds(0, 247, 335, 38);
		desktopPane.add(lblCadastrarProdutoNo);
		
		JLabel lblImprimirOEstoque = new JLabel("Imprimir o Estoque");
		lblImprimirOEstoque.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblImprimirOEstoque.setBounds(332, 219, 272, 34);
		desktopPane.add(lblImprimirOEstoque);
		
		JLabel lblSair = new JLabel("Sair");
		lblSair.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblSair.setBounds(707, 219, 69, 28);
		desktopPane.add(lblSair);
		
		JLabel lblRemoverProdutoNo = new JLabel("Remover Produto do Estoque");
		lblRemoverProdutoNo.setBounds(0, 512, 305, 28);
		desktopPane.add(lblRemoverProdutoNo);
		lblRemoverProdutoNo.setFont(new Font("Tahoma", Font.BOLD, 21));
		
		JLabel lblPesquisarNoEstoque = new JLabel("Pesquisar no Estoque");
		lblPesquisarNoEstoque.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblPesquisarNoEstoque.setBounds(619, 506, 231, 34);
		desktopPane.add(lblPesquisarNoEstoque);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadastroJanela1 tela = new CadastroJanela1();
				desktopPane.add(tela);
				tela.setVisible(true);
				
			}
		});
		
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoverJanela telaRemover = new RemoverJanela();
				desktopPane.add(telaRemover);
				telaRemover.setVisible(true);
			}
		});
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PesquisarJanela telaPesquisar = new PesquisarJanela();
				desktopPane.add(telaPesquisar);
				telaPesquisar.setVisible(true);
			}
		});
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
				switch(resp){
				case JOptionPane.OK_OPTION: System.exit(0);
				case JOptionPane.NO_OPTION:
				}
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Imprimi telaImprimir = null;
				try {
					telaImprimir = new Imprimi();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				desktopPane.add(telaImprimir);
				telaImprimir.setVisible(true);
			}
		});
		
		
	}
}
