package itens;

import java.util.Locale;
/**
 * Instacia itens do tipo BluRay de Shows
 * 
 * @author Hugo Addobbati
 *
 */
public class BluRayShow extends BluRay{
	private int numeroFaixas;
	private String artista;
	/**
	 * Construtor de um item BluRay de Show
	 * 
	 * @param nomeItem
	 *            Nome do show
	 * @param preco
	 *            Preco de venda do item
	 * @param duracao
	 *            Duracao do show
	 * @param classificacao
	 *            Classificacao indicativa do show
	 * @param numeroFaixas
	 *            Numero de faixas do show
	 * @param artista
	 *            Nome do artista do show
	 */
	public BluRayShow(String nomeItem, double preco, int duracao,String classificacao, int numeroFaixas, String artista,String nomeDono, String telefoneDono){
		super(nomeItem, preco, duracao, classificacao, nomeDono, telefoneDono);
		this.numeroFaixas = numeroFaixas;
		this.artista = artista;
		
	}
	
	@Override
	public String toString() {
		return "SHOW: " + this.nome + ", R$ " + this.preco + ", "
				+ super.toString() + ", " + this.duracao + " min, " + this.classificacao + ", " + this.artista
				+ ", " + this.numeroFaixas + " faixas";
	}
	public String toStringTop10() {
		return this.toString();
	}


}
