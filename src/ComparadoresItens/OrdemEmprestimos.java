package ComparadoresItens;

import java.util.Comparator;

import itens.Item;

public class OrdemEmprestimos implements Comparator<Item>{

	@Override
	public int compare(Item o1, Item o2) {
		return o2.getNumEmprestimos() - o1.getNumEmprestimos();
	}
	
}
