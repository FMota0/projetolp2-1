package Fidelidade;
/**
 * Classe responsavel por instanciar o tipo de reputacao Caloteiro.
 * 
 * @author Hugo Addobbati
 *
 */
public class Caloteiro implements CartaoFidelidade{
	/**
	 * Retornara a condicao do usuario de fazer emprestimos.
	 * 
	 * @return boolean representando a condicao do usuario.
	 */
	public boolean podeEmprestar() {
		return false;
	}
	/**
	 * Retorna o periodo maximo de dias de duracao de um emprestimo.
	 * 
	 * @return numero de dias
	 */
	public int periodoMaximo() {
		return 0;
	}
	/**
	 * Representacao textual da reputacao Caloteiro
	 * 
	 * @return string da reputacao Caloteiro.
	 */
	public String toString() {
		return "Caloteiro";
	}
	
}
