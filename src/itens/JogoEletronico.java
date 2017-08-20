package itens;

import java.util.Locale;
/**
 * Instancia itens do tipo Jogo Eletronico
 * 
 * @author HugoAddobbati
 *
 */
public class JogoEletronico extends Item {
	private String plataforma;
	/**
	 * Construtor de um item JogoEletronico
	 * 
	 * @param nome
	 *            Nome do Jogo
	 * @param preco
	 *            Preco de venda do item
	 * @param plataforma
	 *            Plataforma de funcionamento do jogo
	 */
	public JogoEletronico(String nome, double preco, String plataforma, String nomeDono, String telefoneDono) {
		super(nome, preco, nomeDono, telefoneDono);
		this.plataforma = plataforma;
	}

	@Override
	public String toString() {
		return "JOGO ELETRONICO: " + this.nome + ", R$ " + this.preco
				+ ", " + super.toString() + ", " + this.plataforma;
	}
	
	public String toStringTop10() {
		return this.toString();
	}

}
