package itens;

import java.util.Locale;

public class BluRaySerie extends BluRay {
	private String genero;
	private int temporada;

	public BluRaySerie(String nomeItem, double preco, int duracao, String classificacao, String genero, int temporada) {
		super(nomeItem, preco, duracao, classificacao);
		this.genero = genero;
		this.temporada = temporada;
	}

	@Override
	public String toString() {
		return "SERIE: " + this.nome + ", R$ " + this.preco + ", "
				+ super.toString() + ", " + this.duracao + " min, " + this.classificacao + ", " + this.genero
				+ ", Temporada " + this.temporada;
	}
	
	public String toStringTop10(){
		return super.emprestimos + " emprestimos - SERIE: " + super.nome + ", R$ " + super.preco + ", " + super.toString() + ", " + super.duracao + " min, " + super.classificacao + ", " + this.genero + ", Temporada " + this.temporada;  
		
	}
	
	
}
