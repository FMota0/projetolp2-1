package itens;

import java.util.Locale;

/**
 * Instancia itens do tipo BluRay de Filmes
 * 
 * @author Hugo Addobbati
 *
 */
public class BluRayFilme extends BluRay {
	private String genero;
	private int anoLancamento;

	/**
	 * Construtor de um item BluRay de Filme
	 * 
	 * @param nomeItem
	 *            Nome do Filme
	 * @param preco
	 *            Preco de venda do item
	 * @param duracao
	 *            Duracao do filme
	 * @param classificacao
	 *            Classificacao indicativa do filme
	 * @param genero
	 *            Genero do conteudo do filme
	 * @param anoLancamento
	 *            Ano de lancamento do filme
	 */
	public BluRayFilme(String nomeItem, double preco, int duracao, String classificacao, String genero,
			int anoLancamento) {
		super(nomeItem, preco, duracao, classificacao);
		this.genero = genero;
		this.anoLancamento = anoLancamento;
	}

	@Override
	public String toString() {
		String emprestado;
		if (this.isEmprestado)
			emprestado = "Emprestado";
		else
			emprestado = "Nao emprestado";
		return "FILME: " + this.nome + ", R$ " + this.preco + ", " + emprestado + ", " + this.duracao + " min, "
				+ this.classificacao + ", " + this.genero + ", " + this.anoLancamento;
	}

}
