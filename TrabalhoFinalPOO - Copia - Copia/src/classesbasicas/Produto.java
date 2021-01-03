package classesbasicas;

import java.io.IOException;
import java.util.Date;

public class Produto {
	private int id, qtde;
	private String nome, descricao; 
	private Date entrada, validade;
	private boolean perecivel;
	private float valor;
	public Produto(int id, int qtde, String nome, String descricao, Date entrada, Date validade, boolean perecivel,
			float valor) {
		super();
		this.id = id;
		this.qtde = qtde;
		this.nome = nome;
		this.descricao = descricao;
		this.entrada = entrada;
		this.validade = validade;
		this.perecivel = perecivel;
		this.valor = valor;
	}
	public Produto(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getEntrada() {
		return entrada;
	}
	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	public boolean isPerecivel() {
		return perecivel;
	}
	public void setPerecivel(boolean perecivel) {
		this.perecivel = perecivel;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((entrada == null) ? 0 : entrada.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + (perecivel ? 1231 : 1237);
		result = prime * result + qtde;
		result = prime * result + ((validade == null) ? 0 : validade.hashCode());
		result = prime * result + Float.floatToIntBits(valor);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (entrada == null) {
			if (other.entrada != null)
				return false;
		} else if (!entrada.equals(other.entrada))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (perecivel != other.perecivel)
			return false;
		if (qtde != other.qtde)
			return false;
		if (validade == null) {
			if (other.validade != null)
				return false;
		} else if (!validade.equals(other.validade))
			return false;
		if (Float.floatToIntBits(valor) != Float.floatToIntBits(other.valor))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Código do Produto: " + id + " ,Quantidade: " + qtde + ",Nome: " + nome + ",Descricao: " + descricao + ",Data de Entrada:"
				+ entrada + ",Preço: R$ " + valor  + ",Perecivel: " + perecivel + ",Data de Validade:" + validade;
	};
	//@Override
	//public String toString() {
		//return id+ " " + qtde+ " " + nome+ " " + descricao+ " " + entrada+ " " + valor+ " " + perecivel+ " " + validade;
	//};
	
	public boolean idigual(Produto p, int id) throws IOException{
		if(p.id==id) {
			System.out.printf("O Produto com o ID %d está cadastrado\n", id);
			System.out.println(p.toString());
			System.in.read();
			return true;
		}
		else return false;
	}
	public boolean idigual3(int id, Produto a) throws IOException{
		System.out.println(a.id);
		if(a.id==id) {
			System.out.printf("O Produto com o ID %d está cadastrado\n", id);
			System.in.read();
			return true;
		}
		else return false;
	}
	public boolean idigual2(Produto p, int id) throws IOException{
		if(p.id==id) return true;
		else return false;
	}
}
