package principal;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import arquivos.ArquivoEstoque;
import classesbasicas.Produto;
import colecaoDados.Estoque;


public class PrincipalEstoque {

public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
Estoque lista=  new Estoque();
ArquivoEstoque<Estoque> arq= new ArquivoEstoque<Estoque>("C:\\Users\\Adriano O Pinto\\workspace\\TrabalhoFinalPOO\\arquivoEstoque.txt");
Scanner sc = new Scanner(System.in);
int op;
do{
	System.out.println("Usuario... Digite a op��o desejada de acordo com as op��es abaixo:\n1 - Inserir um item no estoque;\n2 - Remover um item no estoque;\n3 - Imprimir o estoque\n4 - Pesquisar por ID\n5 - Pesquisar por Nome\n0 - Sair...");
    op=sc.nextInt();
    switch (op){
    case 0:
    	System.out.println("\nSaindo...");
    	System.in.read();
    	break;
    case 1:
    	Produto aux = new Produto();
    	aux.setId(arq.calcID());
    	System.out.println("Digite o Nome do item: ");
    	aux.setNome(sc.next());
    	System.out.println("Digite a quantidade do item: ");
    	aux.setQtde(sc.nextInt());
    	System.out.println("Digite uma descri��o para o item: ");
    	Scanner sc1 = new Scanner(System.in);
    	aux.setDescricao(sc1.nextLine());
    	System.out.println("Digite o pre�o do item: ");
    	aux.setValor(sc.nextFloat());
    	System.out.println("O item � perecivel? ");
    	String res = sc.next();
    	if(res.equalsIgnoreCase("sim")) aux.setPerecivel(true);
    	else aux.setPerecivel(false);
    	Date x = new Date();
    	aux.setEntrada(x);
    	if(res.equalsIgnoreCase("sim")){
    	try {
        System.out.println("Digite a data de validade: ");
    	String dataRecebida = sc.next();
    	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");  
    	Date dt = df.parse(dataRecebida);
    	aux.setValidade(dt);
        } catch (Exception ex) {ex.printStackTrace();}} else aux.setValidade(null);
    	lista.cadastrarProduto(aux);
    	arq.add2(aux);
    	break;
    case 2:
    	System.out.println("Digite o ID do produto que voc� quer remover do estoque: ");
    	String id0=sc.next();
    	List aa = new ArrayList();
    	aa= arq.exclui("C�digo do Produto: "+id0+" ");
    	//arq.del(); 
    	int i = 0;
    	ArquivoEstoque<Estoque> arq2= new ArquivoEstoque<Estoque>("C:\\Users\\Adriano O Pinto\\workspace\\TrabalhoFinalPOO\\arquivoEstoque.txt", i);
    	arq2.add(aa);
    	break;
    case 3:
    	List a = new Estoque();
    	a=arq.get();
    	//lista.imprimirEstoque(a);
    	arq.imp(a);
    	System.in.read();
    	break;
    case 4:
    	List b = new Estoque();
    	b=arq.get();
    	System.out.println("Digite o ID do produto que voc� quer pesquisar: ");
    	String id1=sc.next();
		String ress = arq.busca("C�digo do Produto: "+id1+" ");
		if(ress!=null)System.out.println("O produto com o ID informado �:\n"+ress);
		else System.out.println("N�o existe produto informado com o ID "+id1);
		System.in.read();
    	break;
    case 5:
    	System.out.println("Digite o Nome do produto que voc� quer pesquisar: ");
    	String nome=sc.next();
		String resul = arq.buscaNome("Nome: "+nome);
		if(resul!=null)System.out.println("O produto com o Nome informado �:\n"+resul);
		else System.out.println("N�o existe produto informado com o Nome "+nome);
		System.in.read();
    	break;
    default:
    	System.out.println("<<<Digite uma op��o v�lida>>>");
    	System.in.read();
    	break;
    }
}while(op!=0);

	}
}
