package projeto;

/**
 * Iterface responsavel por conter os metodos semelhantes de todos os tipos de
 * cartaoes fidelidades.(Bom Amigo, FreeRyde, Noob e Caloteiro)
 * 
 * @author Hugo Addobbati
 *
 */
public interface CartaoFidelidade {

	/**
	 * Retornara a condicao do usuario de fazer emprestimos.
	 * 
	 * @return boolean representando a condicao do usuario.
	 */
	public boolean podeEmprestar();

	/**
	 * Retornara o periodo maximo de dias de duracao de um emprestimo.
	 * 
	 * @return numero de dias
	 */
	public int periodoMaximo();

}
