package colecaoDados;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import classesbasicas.Produto;

public class Estoque extends ArrayList{
	private List<Produto> produtos;
	public Estoque(){
		produtos=new ArrayList<Produto>();
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


	public void cadastrarProduto(Produto p){
		this.produtos.add(p);
	}
	
	public void removerProduto(int id) throws IOException{
		Produto b = new Produto(); int i;
		for(i=0;i<this.produtos.size();i++){
			boolean a=b.idigual2(this.produtos.get(i), id);
			if(a){
				b=this.produtos.get(i);
				this.produtos.remove(b);
				System.out.println("PRODUTO REMOVIDO DO ESTOQUE COM SUCESSO");System.in.read();
				break;
			}
		}
		if(this.produtos.size()==i){
		System.out.printf("PRODUTO NÃO ENCONTRADO NO ESTOQUE\n");System.in.read();
	}
	}
	public void pesquisarProdutoID(int id, List<Produto> produto) throws IOException{
		int i=0; Produto b = new Produto();
		for(i=0;i<produto.size();i++){
			boolean a=b.idigual3(id, (Produto) produto.get(i));
			if(a) break;
		}
		if(produto.size()==i){
				System.out.printf("O Produto com o ID %d não está cadastrado\n", id);System.in.read();
		}
	}
	
	public void imprimirEstoque(List produtos){
	int i;
	if(!produtos.isEmpty()){
	for(i=0;i<produtos.size();i++){
		System.out.println(produtos.get(i));
	}}
	else System.out.printf("O ESTOQUE ESTÁ VAZIO");
	}
    
	
	@Override
	public String toString() {
		return "Estoque [produtos=" + produtos + "]";
	}
	
}
