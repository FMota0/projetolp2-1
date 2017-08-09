package ComparadoresEmprestimo;

import java.util.Comparator;
import projeto.Emprestimo;

public class OrdemAlfabeticaItem implements Comparator<Emprestimo>{

	@Override
	public int compare(Emprestimo o1, Emprestimo o2) {
		return o1.getNomeDonoItem().compareTo(o2.getNomeDonoItem());
	}

}
