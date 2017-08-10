package itens;

import java.util.Locale;

public class BluRayFilme extends BluRay {
	private String genero;
	private int anoLancamento;

	public BluRayFilme(String nomeItem, double preco, int duracao, String classificacao, String genero,
			int anoLancamento) {
		super(nomeItem, preco, duracao, classificacao);
		this.genero = genero;
		this.anoLancamento = anoLancamento;
	}

	@Override
	public String toString() {
		return "FILME: " + this.nome + ", R$ " + this.preco + ", "
				+ super.toString() + ", " + this.duracao + " min, " + this.classificacao + ", " + this.genero + ", "
				+ this.anoLancamento;
	}

}
