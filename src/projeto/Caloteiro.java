package projeto;

/**
 * Classe responsavel por instanciar o tipo de reputacao Caloteiro.
 * @author Hugo Addobbati
 *
 */
public class Caloteiro implements CartaoFidelidade{
	/**
	 * Retorna se o usuario pode pegar itens emprestados.
	 * @return boolean
	 */
	public boolean podeEmprestar() {
		return false;
	}
	
	/**
	 * Retorna o periodo maximo de dias de duracao de um emprestimo.
	 * @return numero de dias
	 */
	public int periodoMaximo() {
		return 0;
	}
	
	public String toString() {
		return "Caloteiro";
	}
	
}
