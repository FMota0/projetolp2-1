package ComparadoresItens;

import java.util.Comparator;

import itens.Item;

public class OrdemAlfabetica implements Comparator<Item>{

	@Override
	public int compare(Item o1, Item o2) {
		return o1.getNome().compareTo(o2.getNome());
	}

}
