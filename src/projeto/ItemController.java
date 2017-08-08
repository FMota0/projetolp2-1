package projeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import itens.BluRayFilme;
import itens.BluRaySerie;
import itens.BluRayShow;
import itens.Item;
import itens.JogoEletronico;
import itens.JogoTabuleiro;

public class ItemController {

	private Map<String, Item> itens;
	
	public ItemController(){
		itens = new HashMap<String, Item>();
	}
	
	public void verificaSeExisteItem(String nomeItem){
		if(!this.existeItem(nomeItem))
			throw new IllegalArgumentException("Item nao encontrado");
	}

	public boolean existeItem(String nomeItem){
		return this.itens.containsKey(nomeItem);
	}

	public void cadastraItem(Item item) {
		itens.put(item.getNome(), item);
	}
	
	public boolean estaEmprestado(String nomeItem){
		return itens.get(nomeItem).getIsEmprestado();
	}
	
	public String getInfoItem(String nomeItem, String atributo) {
		
		this.verificaSeExisteItem(nomeItem);
		return this.itens.get(nomeItem).getAtributo(atributo);
	}
	
	public boolean adicionarPecaPerdida(String nomeItem, String peca) {
		
		this.verificaSeExisteItem(nomeItem);
		
		if (!(itens.get(nomeItem) instanceof JogoTabuleiro)) { // WTF hugo ???
			throw new IllegalArgumentException("Item selecionado nao e jogo de tabuleiro");
		}
		JogoTabuleiro item = (JogoTabuleiro) itens.get(nomeItem);
		return item.adicionarPecaPerdida(peca);
	}

	public void removerItem(String nomeItem) {
		this.verificaSeExisteItem(nomeItem);
		itens.remove(nomeItem);
	}

	public void atualizarItem(String nomeItem, String atributo, String valor) {
		this.verificaSeExisteItem(nomeItem);
		Item item = this.itens.get(nomeItem);
		this.itens.remove(nomeItem);
		item.mudaAtributo(atributo, valor);
		nomeItem = item.getNome();
		this.itens.put(nomeItem, item);
	}

	public void cadastrarEletronico(String nomeItem, double preco, String plataforma) {
		this.itens.put(nomeItem, new JogoEletronico(nomeItem, preco, plataforma));
		
	}

	public void cadastrarTabuleiro(String nomeItem, double preco) {
		this.itens.put(nomeItem, new JogoTabuleiro(nomeItem, preco));
	}

	public void cadastrarBluRaySerie(String nomeItem, double preco, int duracao, String classificacao, String genero,
			int temporada) {
		this.itens.put(nomeItem, new BluRaySerie(nomeItem, preco, duracao, classificacao, genero, temporada));
		
	}

	public void cadastrarBluRayShow(String nomeItem, double preco, int duracao, String classificacao, int numeroFaixas,
			String artista) {
		this.itens.put(nomeItem, new BluRayShow(nomeItem, preco, duracao, classificacao, numeroFaixas, artista));
		
	}

	public void cadastrarBluRayFilme(String nomeItem, double preco, int duracao, String classificacao, String genero,
			int anoLancamento) {
		this.itens.put(nomeItem, new BluRayFilme(nomeItem, preco, duracao, classificacao, genero, anoLancamento));
		
	}
	
	public void mudaEstadoItem(String nomeItem){
		if(existeItem(nomeItem))
			this.itens.get(nomeItem).setIsEmprestado(!this.itens.get(nomeItem).getIsEmprestado());
	}
	
	public ArrayList<Item> getListItem() {
		ArrayList<Item> listagem = new ArrayList<Item>();
		for(String nomeItem : itens.keySet())
			listagem.add(this.itens.get(nomeItem));
		return listagem;
	}

	public String pesquisarDetalhesItem(String nomeItem) {
		this.verificaSeExisteItem(nomeItem);
		return itens.get(nomeItem).toString();
	}

	
}
