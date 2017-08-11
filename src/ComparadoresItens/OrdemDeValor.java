package ComparadoresItens;

import java.util.Comparator;

import itens.Item;

/**
 * Classe responsavel pela implementacao dos metodos de comparacao para
 * ordenacao de itens por valor
 * 
 * @author Felipe Mota
 *
 */
public class OrdemDeValor implements Comparator<Item> {

	@Override
	/**
	 * Compara o preco de dois itens.
	 *
	 */
	public int compare(Item o1, Item o2) {
		double valor1 = o1.getPreco();
		double valor2 = o2.getPreco();
		if (valor1 < valor2)
			return -1;
		else if (valor1 > valor2)
			return 1;
		else
			return 0;
	}

}
