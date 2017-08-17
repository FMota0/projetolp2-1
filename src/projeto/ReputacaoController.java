package projeto;

public class ReputacaoController {
	private double reputacao;
	
	public ReputacaoController(){
		this.reputacao = 0.0;
	}
	
	public void addReputacao(double reputacao){
		this.reputacao += reputacao;
	}
	
	public double getReputacao(){
		return this.reputacao;
	}
	
	public boolean podeEmprestar(){
		if(reputacao >= 0){
			return true;
		}
		return false;
	}
}
