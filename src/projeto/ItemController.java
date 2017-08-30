package projeto;

import java.util.List;

import ComparadoresItens.OrdemAlfabetica;
import ComparadoresItens.OrdemDeValor;
import ComparadoresItens.OrdemEmprestimos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import itens.BluRayFilme;
import itens.BluRaySerie;
import itens.BluRayShow;
import itens.Item;
import itens.JogoEletronico;
import itens.JogoTabuleiro;

public class ItemController implements Serializable{
	
	private List<Item> itens;

	public ItemController() {
		this.itens = new ArrayList<Item>();
	}

	/**
	 * Cadastrar Item - Jogo Eletronico
	 * 
	 * @param nomeUsuario
	 *            Nome do usuario
	 * @param telefoneUsuaruio
	 *            Telefone do usuario
	 * @param nomeItem
	 *            Nome de item
	 * @param preco
	 *            Preco de venda do item
	 * @param plataforma
	 *            Plataforma de funcionamento do item
	 */
	
	public void cadastrarEletronico(String nomeUsuario, String telefoneUsuario, String nomeItem, double preco,
			String plataforma) {
		this.itens.add(new JogoEletronico(nomeItem, preco, plataforma, nomeUsuario, telefoneUsuario));
	}

	/**
	 * Cadastrar Item - Jogo de Tabuleiro
	 * 
	 * @param nomeUsuario
	 *            Nome do usuario
	 * @param telefoneUsuaruio
	 *            Telefone do usuario
	 * @param nomeItem
	 *            Nome de item
	 * @param preco
	 *            Preco de venda do item
	 */
	
	public void cadastrarTabuleiro(String nomeUsuario, String telefoneUsuario, String nomeItem, double preco) {
		this.itens.add(new JogoTabuleiro(nomeItem, preco, nomeUsuario, telefoneUsuario));
	}

	/**
	 * Cadastrar Item: BluRay de Serie
	 * 
	 * @param nomeUsuario
	 *            Nome do usuario
	 * @param telefoneUsuario
	 *            Telefone do usuario
	 * @param nomeItem
	 *            Nome do item
	 * @param preco
	 *            Preco de venda do item
	 * @param duracao
	 *            Duracao em minutos do conteudo
	 * @param classificacao
	 *            Classificacao indicativa do conteudo
	 * @param genero
	 *            Genero do conteudo
	 * @param temporada
	 *            Numero da temporada
	 */
	
	public void cadastrarBluRaySerie(String nomeUsuario, String telefoneUsuario, String nomeItem, double preco,
			int duracao, String classificacao, String genero, int temporada) {
		this.itens.add(new BluRaySerie(nomeItem, preco, duracao, classificacao, genero, temporada, nomeUsuario,
				telefoneUsuario));
	}

	/**
	 * Cadastrar Item: BluRay de Show
	 * 
	 * @param nomeUsuario
	 *            Nome do usuario
	 * @param telefoneUsuario
	 *            Telefone do usuario
	 * @param nomeItem
	 *            Nome do item
	 * @param preco
	 *            Preco de venda do item
	 * @param duracao
	 *            Duracao em minutos do conteudo
	 * @param classificacao
	 *            Classificacao indicativa do conteudo
	 * @param numeroFaixas
	 *            Numero de faixas do show
	 * @param artista
	 *            Nome do artista do show
	 */
	
	public void cadastrarBluRayShow(String nomeUsuario, String telefoneUsuario, String nomeItem, double preco,
			int duracao, String classificacao, int numeroFaixas, String artista) {
		this.itens.add(new BluRayShow(nomeItem, preco, duracao, classificacao, numeroFaixas, artista, nomeUsuario,
				telefoneUsuario));

	}

	/**
	 * Cadastrar Item: BluRay de Filme
	 * 
	 * @param nomeUsuario
	 *            Nome do usuario
	 * @param telefoneUsuario
	 *            Telefone do usuario
	 * @param nomeItem
	 *            Nome do item
	 * @param preco
	 *            Preco de venda do item
	 * @param duracao
	 *            Duracao em minutos do conteudo
	 * @param classificacao
	 *            Classificacao indicativa do conteudo
	 * @param genero
	 *            Genero do conteudo do BluRay
	 * @param anoLancamento
	 *            Ano de lancamento do filme
	 */
	
	public void cadastrarBluRayFilme(String nomeUsuario, String telefoneUsuario, String nomeItem, double preco,
			int duracao, String classificacao, String genero, int anoLancamento) {
		this.itens.add(new BluRayFilme(nomeItem, preco, duracao, classificacao, genero, anoLancamento, nomeUsuario,
				telefoneUsuario));

	}

	/**
	 * Retornar informacao de atributo de um item :
	 * 
	 * @param nome
	 *            Nome do usuario dono do item
	 * @param telefone
	 *            Telefone do usuario dono do item
	 * @param nomeItem
	 *            Nome de item
	 * @param atributo
	 *            Atributos desejado para saber a informacao
	 * @return Informacao do atributo
	 */
	
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		for (Item item : itens) {
			if (item.getNome().equalsIgnoreCase(nomeItem) && item.getNomeDono().equalsIgnoreCase(nome)
					&& item.getTelefoneDono().equalsIgnoreCase(telefone))
				return item.getAtributo(atributo);
		}
		throw new IllegalArgumentException("LOL");
	}
	
	/**
	 * Registrar peca perdida em um jogo de tabuleiro
	 * 
	 * @param nome
	 *            Nome do usuario dono do item
	 * @param telefone
	 *            Telefone do usuario dono do item
	 * @param nomeItem
	 *            Nome de item
	 * @param peca
	 *            Nome da peca perdida
	 */

	public void adicionarPerdida(String nome, String telefone, String nomeItem, String peca) {
		for (Item item : itens) {
			if (item.getNome().equalsIgnoreCase(nomeItem) && item.getNomeDono().equalsIgnoreCase(nome)
					&& item.getTelefoneDono().equalsIgnoreCase(telefone)) {
				if (!(item instanceof JogoTabuleiro)) {
					throw new IllegalArgumentException("Item selecionado nao e jogo de tabuleiro");
				}
				JogoTabuleiro item2 = (JogoTabuleiro) item;
				item2.adicionarPecaPerdida(peca);
			}
		}
	}

	/**
	 * Verifica se um item existe a partir de seu nome, e do nome do dono e telefone
	 * 
	 * @param nomeItem
	 * 			Nome do Item
	 * @param nome
	 * 			Nome do dono do item
	 * @param telefone
	 * 			Telefone do dono do item
	 */
	
	public void existeItem(String nomeItem, String nome, String telefone) {
		boolean achou = false;
		for (Item item : itens) {
			if (item.getNome().equalsIgnoreCase(nomeItem) && item.getNomeDono().equalsIgnoreCase(nome)
					&& item.getTelefoneDono().equalsIgnoreCase(telefone))
				achou = true;
		}
		if (!achou)
			throw new IllegalArgumentException("Item nao encontrado");
	}

	/**
	 * Remover item de um usuario
	 * 
	 * @param nome
	 *            Nome do usuario dono do item
	 * @param telefone
	 *            Telefone do usuario dono do item
	 * @param nomeItem
	 *            Nome de item
	 */
	
	public void removerItem(String nome, String telefone, String nomeItem) {
		for (Item item : itens) {
			if (item.getNome().equalsIgnoreCase(nomeItem) && item.getNomeDono().equalsIgnoreCase(nome)
					&& item.getTelefoneDono().equalsIgnoreCase(telefone))
				itens.remove(item);
			break;
		}
	}
	
	/**
	 * Atualizar as informacoes de um item do usuario
	 * 
	 * @param nome
	 *            Nome do usuario dono do item
	 * @param telefone
	 *            Telefone do usuario dono do item
	 * @param nomeItem
	 *            Nome de item
	 * @param atributo
	 *            Atributo que sera atualizado
	 * @param valor
	 */

	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		for (Item item : itens) {
			if (item.getNome().equalsIgnoreCase(nomeItem) && item.getNomeDono().equalsIgnoreCase(nome)
					&& item.getTelefoneDono().equalsIgnoreCase(telefone))
				item.mudaAtributo(atributo, valor);
		}
	}

	/**
	 * Recupera um item a partir do seu nome, nome do dono e telefone do dono
	 * @param nomeItem
	 * @param nomeDono
	 * @param telefoneDono
	 * @return
	 */
	
	public Item getItem(String nomeItem, String nomeDono, String telefoneDono) {
		for (Item item : itens) {
			if (item.getNome().equalsIgnoreCase(nomeItem) && item.getNomeDono().equalsIgnoreCase(nomeDono)
					&& item.getTelefoneDono().equalsIgnoreCase(telefoneDono)) {
				return item;
			}
		}
		throw new IllegalArgumentException("Item nao encontrado");
	}

	/**
	 * Retorna uma lista de todos os itens registrados em ordem lexicogr√°fica
	 * 
	 * @return lista de todos os itens registrados
	 */
	
	public String listarItensOrdenadosPorNome() {
		String lista = "";
		Collections.sort(itens, new OrdemAlfabetica());
		for (Item item : itens)
			lista += item.toString() + "|";
		return lista;
	}

	/**
	 * Retorna uma lista de todos os itens registrados em ordem por seus respectivos
	 * precos
	 * 
	 * @return lista de todos os itens registrados
	 */
	
	public String listarItensOrdenadosPorValor() {
		String lista = "";
		Collections.sort(itens, new OrdemDeValor());
		for (Item item : itens)
			lista += item.toString() + "|";
		return lista;
	}

	/**
	 * Informar detalhes de um item pesquisado
	 * 
	 * @param nome
	 *            Nome do usuario dono do item
	 * @param telefone
	 *            Telefone do usuario dono do item
	 * @param nomeItem
	 *            Nome de item
	 * @return informacoes gerais do item pesquisado
	 */
	
	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
		for (Item item : itens) {
			if (item.getNome().equalsIgnoreCase(nomeItem) && item.getNomeDono().equalsIgnoreCase(nome)
					&& item.getTelefoneDono().equalsIgnoreCase(telefone))
				return item.toString();
		}
		throw new IllegalArgumentException("Item nao encontrado");
	}

	/**
	 * Retorna uma lista dos emprestimos feitos em um item 
	 * @param nomeItem
	 * @return
	 */
	
	public List<EmprestimoId> getListaEmprestimos(String nomeItem) {
		List<EmprestimoId> emprestimoId = new ArrayList<>();
		for (Item item : itens) {
			if (item.getNome().equals(nomeItem)) {
				for (EmprestimoId emprestimoid : item.getEmprestimosId()) {
					emprestimoId.add(emprestimoid);
				}
			}
		}
		return emprestimoId;
	}

	/**
	 * Recupera lista de todos os itens que estam disponiveis para emprestimos.
	 * 
	 * @return lista de itens nao emprestados
	 */
	
	public String listarItensNaoEmprestados() {
		String mensagem = "";
		ArrayList<Item> superlist = new ArrayList<Item>();
		for (Item item : itens) {
			if (!item.getIsEmprestado()) {
				superlist.add(item);
			}
		}
		Collections.sort(superlist, new OrdemAlfabetica());
		for (Item item : superlist) {
			mensagem += item.toString() + "|";
		}
		return mensagem;
	}

	/**
	 * Lista os itens emprestados
	 * 
	 * @return lista de itens emprestados
	 */
	
	public String listarItensEmprestados() {
		String mensagem = "";
		ArrayList<Item> superlist = new ArrayList<Item>();
		for (Item item : itens) {
			if (item.getIsEmprestado()) {
				superlist.add(item);
			}
		}
		Collections.sort(superlist, new OrdemAlfabetica());
		for (Item item : superlist) {
			mensagem += item.toStringEmprestado() + "|";
		}
		return mensagem;
	}

	/**
	 * Retorna a lista dos 10 itens mais emprestados
	 * 
	 * @return lista dos 10 itens mais empretados
	 */
	
	public String listarTop10Itens() {
		String mensagem = "";
		int i = 1;
		Collections.sort(itens, new OrdemEmprestimos());
		for (Item item : itens) {
			if (i > 10)
				break;
			if (item.getNumEmprestimos() > 0) {
				mensagem += i + ") " + item.toStringTop10() + "|";
				i += 1;
			}
		}
		return mensagem;
	}
	
	/**
	 * Verifica se um usu·rio tem itens
	 * @param nomeDono
	 * @param telefoneDono
	 * @return boolean
	 */
	
	
	public boolean usuarioTemItens(String nomeDono, String telefoneDono) {
		for (Item item : itens) {
			if(item.getNomeDono().equalsIgnoreCase(nomeDono) && item.getTelefoneDono().equalsIgnoreCase(telefoneDono)) {
				return true;
			}
		}
		return false;
	}

}
