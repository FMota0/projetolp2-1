package ComparadoresItens;

import java.util.Comparator;

import itens.Item;

/**
 * Classe responsavel pela implementacao dos metodos de comparacao para
 * ordenacao de itens
 * 
 * @author Felipe Mota
 *
 */
public class OrdemAlfabetica implements Comparator<Item> {

	@Override
	/**
	 * Compara o nome de dois itens e retorna o menor
	 */
	public int compare(Item o1, Item o2) {
		return o1.getNome().compareTo(o2.getNome());
	}

}
