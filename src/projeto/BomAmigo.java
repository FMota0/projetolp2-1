package projeto;

/**
 * Classe responsavel por instanciar o tipo de reputacao Bom Amigo.
 * @author Hugo Addobbati
 *
 */
public class BomAmigo implements CartaoFidelidade{
	/**
	 * Retorna se o usuario pode pegar itens emprestados.
	 * @return boolean
	 */
	public boolean podeEmprestar() {
		return true;
	}
	
	/**
	 * Retorna o periodo maximo de dias de duracao de um emprestimo.
	 * @return numero de dias
	 */
	public int periodoMaximo() {
		return 14;
	}
	
	public String toString() {
		return "BomAmigo";
	}

}
