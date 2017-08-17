package itens;

import java.util.Locale;
/**
 * Instacia itens do tipo BluRay de Series
 * 
 * @author Hugo Addobbati
 *
 */
public class BluRaySerie extends BluRay {
	private String genero;
	private int temporada;
	/**
	 * Construtor de um item BluRay de Serie
	 * 
	 * @param nomeItem
	 *            Nome da Serie
	 * @param preco
	 *            Preco de venda do item
	 * @param duracao
	 *            Duracao do conteudo do BluRay
	 * @param classificacao
	 *            Classificao indicativa do conteudo da serie
	 * @param genero
	 *            Genero do conteudo da serie
	 * @param temporada
	 *            Temporada do BluRay da serie
	 */
	public BluRaySerie(String nomeItem, double preco, int duracao, String classificacao, String genero, int temporada, String nomeDono, String telefoneDono) {
		super(nomeItem, preco, duracao, classificacao, nomeDono, telefoneDono);
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
