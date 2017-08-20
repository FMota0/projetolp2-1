package itens;

import java.util.ArrayList;
/**
 * Instancia itens do tipo Jodo de Tabuleiro
 * 
 * @author Hugo Addobbati
 *
 */
public class JogoTabuleiro extends Item{
	
	private ArrayList<String> pecasPerdidas;
	/**
	 * Construtor de um item Jogo de Tabuleiro
	 * 
	 * @param nome
	 *            Nome do Jogo
	 * @param preco
	 *            Preco de venda do item
	 */
	public JogoTabuleiro(String nome, double preco,String nomeDono, String telefoneDono){
		super(nome, preco, nomeDono, telefoneDono);
		this.pecasPerdidas = new ArrayList<String>();
	}
	/**
	 * Registra peca na lista de pecas perdidas do jogo
	 * 
	 * @param peca
	 * @return lista de pecas perdidas
	 */
	public boolean adicionarPecaPerdida(String peca){
		return pecasPerdidas.add(peca);
	}

	@Override
	public String toString() {
		String hasPecasPerdidas;
		if(this.pecasPerdidas.size() > 0)
			hasPecasPerdidas = "COM PECAS PERDIDAS";
		else
			hasPecasPerdidas = "COMPLETO";
		return "JOGO DE TABULEIRO: " + this.nome + ", R$ " + this.preco + ", "
				+ super.toString() + ", " + hasPecasPerdidas;
	}
	
	public String toStringTop10(){
		String hasPecasPerdidas;
		if(this.pecasPerdidas.size() > 0)
			hasPecasPerdidas = "COM PECAS PERDIDAS";
		else
			hasPecasPerdidas = "COMPLETO";
		return super.emprestimos + " emprestimos - JOGO DE TABULEIRO: " + super.nome + ", R$ " + this.preco + ", " + super.toString() + ", " + hasPecasPerdidas;
	}
	
}