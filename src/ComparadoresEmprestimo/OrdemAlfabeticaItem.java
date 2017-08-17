package ComparadoresEmprestimo;

import java.util.Comparator;
import projeto.Emprestimo;

/**
 * Classe responsavel pela implementacao dos metodos de comparacao para
 * ordenacao de emprestimos
 * 
 * @author Felipe Mota
 *
 */
public class OrdemAlfabeticaItem implements Comparator<Emprestimo> {

	@Override
	/**
	 * Compara dois itens de emprestimos e retorna o menor
	 */
	public int compare(Emprestimo o1, Emprestimo o2) {
		return o1.getNomeDonoItem().compareTo(o2.getNomeDonoItem());
	}

}
