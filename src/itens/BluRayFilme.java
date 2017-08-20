package itens;


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
			int anoLancamento, String nomeDono, String telefoneDono) {
		super(nomeItem, preco, duracao, classificacao,nomeDono, telefoneDono);
		this.genero = genero;
		this.anoLancamento = anoLancamento;
	}

	@Override
	public String toString() {
		return "FILME: " + this.nome + ", R$ " + this.preco + ", "
				+ super.toString() + ", " + this.duracao + " min, " + this.classificacao + ", " + this.genero + ", "
				+ this.anoLancamento;
	}
	public String toStringTop10() {
		return this.toString();
	}


}
