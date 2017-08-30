package Fidelidade;

import java.io.Serializable;

/**
 * Classe responsavel por instanciar o tipo de reputacao Noob.
 * 
 * @author Hugo Addobbati
 *
 */

public class Noob implements CartaoFidelidade, Serializable{

	/**
	 * Retorna a condicao do usuario de fazer emprestimos.
	 * 
	 * @return boolean representando a condicao do usuario.
	 */
	
	public boolean podeEmprestar() {
		return true;
	}
	
	/**
	 * Retorna o periodo maximo de dias de duracao de um emprestimo.
	 * 
	 * @return numero de dias
	 */
	
	public int periodoMaximo() {
		return 7;
	}
	
	/**
	 * Representacao textual da reputacao Noob
	 * 
	 * @return string da reputacao Noob.
	 */
	
	public String toString() {
		return "Noob";
	}
	
}
