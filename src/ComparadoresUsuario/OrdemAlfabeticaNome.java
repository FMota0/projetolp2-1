package ComparadoresUsuario;

import java.util.Comparator;

import projeto.Usuario;

public class OrdemAlfabeticaNome implements Comparator<Usuario> {

	@Override
	/**
	 * Compara o nome de dois itens e retorna o menor
	 */
	public int compare(Usuario o1, Usuario o2) {
		return o1.getNome().compareTo(o2.getNome());
	}

}
