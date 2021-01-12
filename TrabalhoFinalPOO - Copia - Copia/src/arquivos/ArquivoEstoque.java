package arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import classesbasicas.Produto;
import colecaoDados.Estoque;

public class ArquivoEstoque <T>{
private File arq;

public ArquivoEstoque(String arq) throws IOException {
	super();
	this.arq = new File(arq);
	if(!this.arq.exists()) this.arq.createNewFile();
}

public ArquivoEstoque(String arq, int i) throws IOException {
	super();
	this.arq = new File(arq);
	this.arq.createNewFile();
}

public void add(List aa) throws IOException{
	BufferedWriter bf = new BufferedWriter(new PrintWriter(new FileWriter(arq, false), true));
	for(int i=0;i<aa.size();i++){
	bf.write(aa.get(i).toString());
	bf.newLine();
	}
	bf.close();
}
public void add2(Produto aux) throws IOException{
	BufferedWriter bf = new BufferedWriter(new PrintWriter(new FileWriter(arq, true), true));
	bf.write(aux.toString());
	bf.newLine();
	bf.close();
}

public int calcID() throws IOException{
	List<T> a = new Estoque();
	a= this.get();
	String z[]=a.get(a.size()-1).toString().split(" ");
	int b =Integer.parseInt(z[3]); return b+1;
}

public void imp(List a) throws Exception{
	BufferedReader br = new BufferedReader(new FileReader(arq));
	Scanner scan = new Scanner(arq);String linha = null;String[] campos = null;
	while(scan.hasNextLine()){
		   linha = scan.nextLine();
		   campos = linha.split(",");
		   String as[] = campos[4].split(" ");
		   System.out.println("----------------------------------------------------------------------------------");
		   System.out.println(campos[0]+"\n"+campos[1]+"\n"+campos[2]+"\n"+campos[3]+"\nData de Entrada: "+as[4]+"/"+as[3]+"/"+as[7]);
		   if(campos[6].equals("Perecivel: true")==true && campos[7].equals("Data de Validade:null")==false){
		   String dv[] = campos[7].split(" ");
		   System.out.println("Data de Validade: "+dv[4]+"/"+dv[3]+"/"+dv[7]);}
		   else System.out.println("Data Validade: Produto Não Perecivel");
		   System.out.println(campos[5]);
}
	br.close();
}

public List<T> get() throws IOException{
	List<T> l = new ArrayList<T>();
	BufferedReader br = new BufferedReader(new FileReader(arq));
	
	String linha = br.readLine();
	while(linha!=null){
		l.add((T)linha);
		linha = br.readLine();
	}
	br.close();
	return l;
}

public String busca(String id) throws IOException{
	BufferedReader br = new BufferedReader(new FileReader(arq));
	Scanner scan = new Scanner(arq);String linha = null;
	while(scan.hasNextLine()){
		   linha = scan.nextLine();
		   String[] campos = linha.split(",");
		   String id1 = (campos[0]);
		   if(id1.equals(id))return linha;
}
	br.close();
	return null;
}
public String buscaNome(String nome) throws IOException{
	BufferedReader br = new BufferedReader(new FileReader(arq));
	Scanner scan = new Scanner(arq);String linha = null;
	while(scan.hasNextLine()){
		   linha = scan.nextLine();
		   String[] campos = linha.split(",");
		   String nome1 = (campos[2]);
		   if(nome1.equals(nome))return linha;
}
	br.close();
	return null;
}

public List exclui(String id) throws IOException{
	List<T> l = new ArrayList<T>();
	BufferedReader br = new BufferedReader(new FileReader(arq));
	Scanner scan = new Scanner(arq);String linha = null;
	while(scan.hasNextLine()){
		   linha = scan.nextLine();
		   String[] campos = linha.split(",");
		   String id1 = (campos[0]);
		   if(id1.equals(id)==false){
			   l.add((T) linha);
		   }
}
	br.close();
	return l;
}
public void del(){
	this.arq.delete();
}
}
