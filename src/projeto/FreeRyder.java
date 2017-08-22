package projeto;

/**
 * Classe responsavel por instanciar o tipo de reputacao FreeRyder.
 * 
 * @author Hugo Addobbati
 *
 */
public class FreeRyder implements CartaoFidelidade {

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
		return 5;
	}

	/**
	 * Representacao textual da reputacao FreeRyder.
	 * 
	 * @return string da reputacao FreeRyder.
	 */
	public String toString() {
		return "FreeRyder";
	}

}
