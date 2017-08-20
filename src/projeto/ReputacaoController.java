package projeto;

import Fidelidade.BomAmigo;
import Fidelidade.Caloteiro;
import Fidelidade.CartaoFidelidade;
import Fidelidade.FreeRyder;
import Fidelidade.Noob;

public class ReputacaoController {
	private double reputacao;
	private CartaoFidelidade cartaofidelidade;
	
	public ReputacaoController(){
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
