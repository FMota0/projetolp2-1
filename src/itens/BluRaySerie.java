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
	public BluRaySerie(String nomeItem, double preco, int duracao, String classificacao, String genero, int temporada) {
		super(nomeItem, preco, duracao, classificacao);
		this.genero = genero;
		this.temporada = temporada;
	}

	@Override
	public String toString() {
		String emprestado;
		if (this.isEmprestado)
			emprestado = "Emprestado";
		else
			emprestado = "Nao emprestado";
		return "SERIE: " + this.nome + ", R$ " + this.preco + ", " + emprestado + ", " + this.duracao + " min, "
				+ this.classificacao + ", " + this.genero + ", Temporada " + this.temporada;
	}

}
