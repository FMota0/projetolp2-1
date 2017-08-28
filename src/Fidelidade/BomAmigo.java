package Fidelidade;

import java.io.Serializable;

/**
 * Classe responsavel por instanciar o tipo de reputacao Bom Amigo.
 * 
 * @author Hugo Addobbati
 *
 */
public class BomAmigo implements CartaoFidelidade, Serializable{
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
		return 14;
	}
	/**
	 * Representacao textual da reputacao Bom Amigo
	 * 
	 * @return string da reputacao Bom Amigo.
	 */
	public String toString() {
		return "BomAmigo";
	}

}
