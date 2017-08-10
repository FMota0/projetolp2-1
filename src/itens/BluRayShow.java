package itens;

import java.util.Locale;

public class BluRayShow extends BluRay{
	private int numeroFaixas;
	private String artista;
	public BluRayShow(String nomeItem, double preco, int duracao,String classificacao, int numeroFaixas, String artista){
		super(nomeItem, preco, duracao, classificacao);
		this.numeroFaixas = numeroFaixas;
		this.artista = artista;
		
	}
	
	@Override
	public String toString() {
		return "SHOW: " + this.nome + ", R$ " + this.preco + ", "
				+ super.toString() + ", " + this.duracao + " min, " + this.classificacao + ", " + this.artista
				+ ", " + this.numeroFaixas + " faixas";
	}

}
