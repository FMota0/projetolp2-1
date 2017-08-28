package projeto;

import java.io.Serializable;

import Fidelidade.BomAmigo;
import Fidelidade.Caloteiro;
import Fidelidade.CartaoFidelidade;
import Fidelidade.FreeRyder;
import Fidelidade.Noob;
/**
 * Classe controladora das atividades relacionadas a reputacao dos usuarios
 * 
 * @author Hugo
 *
 */
public class ReputacaoUtil implements Serializable{
	private double reputacao;
	private CartaoFidelidade cartaofidelidade;
	/**
	 * Inicia o Controller com todos os cartoes fidelidades com o tipo "FreeRyder" e
	 * a nota da repotucao como 0.
	 */
	public ReputacaoUtil(){
		this.reputacao = 0.0;
		this.cartaofidelidade = new FreeRyder();
	}
	
	public void addReputacao(double reputacao, boolean temItens){
		this.reputacao += reputacao;
		if(this.reputacao >= 0 && this.reputacao <= 100 && temItens) {
			this.cartaofidelidade = new Noob();
		}
		else if(this.reputacao > 100 && temItens) {
			this.cartaofidelidade = new BomAmigo();
		}
		else if(this.reputacao < 0) {
			this.cartaofidelidade = new Caloteiro();
		}
		else if(this.reputacao >= 0 && !temItens) {
			this.cartaofidelidade = new FreeRyder();
		}
	}
	
	public double getReputacao(){
		return this.reputacao;
	}
	
	public boolean podeEmprestar(){
		return cartaofidelidade.podeEmprestar();
	}
	
	public int periodoMaximo() {
		return this.cartaofidelidade.periodoMaximo();
	}
	
	public String toString() {
		return this.cartaofidelidade.toString();
	}
}
