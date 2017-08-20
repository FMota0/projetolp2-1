package ComparadoresReputacao;

import java.util.Comparator;

import projeto.Usuario;

public class OrdenaMelhorPiorReputacao implements Comparator<Usuario> {

	@Override
	/**
	 * Compara o nome de dois itens e retorna o menor
	 */
	public int compare(Usuario o1, Usuario o2) {
		if (o1.getReputacao() - o2.getReputacao() > 0) {
			return 1;
		}
		else if(o1.getReputacao() - o2.getReputacao() == 0) {
			return 0;
		}
		else {
			return -1;
		}
		
	}

}