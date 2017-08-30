package itens;

import java.io.Serializable;

/**
 * Instacia itens do tipo BluRay
 * 
 * @author Hugo Addobbati
 *
 */

public abstract class BluRay extends Item implements Serializable{
	protected int duracao;
	protected String classificacao;

	/**
	 * Construtor do item BluRay
	 * 
	 * @param nomeItem
	 *            Nome do item
	 * @param preco
	 *            Predo de venda do item
	 * @param duracao
	 *            Duracao do conteudo do BluRay
	 * @param classificacao
	 *            Classificacao indicativa do conteudo do BluRay
	 */
	
	public BluRay(String nomeItem, double preco, int duracao, String classificacao, String nomeDono, String telefoneDono) {
		super(nomeItem, preco, nomeDono, telefoneDono);
		this.duracao = duracao;
		this.classificacao = classificacao;
	}
	
	public String toStringTop10() {
		return this.toString();
	}


}