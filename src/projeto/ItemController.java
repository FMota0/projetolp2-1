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

	public void cadastrarEletronico(String nomeUsuario, String telefoneUsuario, String nomeItem, double preco,
			String plataforma) {
		this.itens.add(new JogoEletronico(nomeItem, preco, plataforma, nomeUsuario, telefoneUsuario));
	}

	public void cadastrarTabuleiro(String nomeUsuario, String telefoneUsuario, String nomeItem, double preco) {
		this.itens.add(new JogoTabuleiro(nomeItem, preco, nomeUsuario, telefoneUsuario));
	}

	public void cadastrarBluRaySerie(String nomeUsuario, String telefoneUsuario, String nomeItem, double preco,
			int duracao, String classificacao, String genero, int temporada) {
		this.itens.add(new BluRaySerie(nomeItem, preco, duracao, classificacao, genero, temporada, nomeUsuario,
				telefoneUsuario));
	}

	public void cadastrarBluRayShow(String nomeUsuario, String telefoneUsuario, String nomeItem, double preco,
			int duracao, String classificacao, int numeroFaixas, String artista) {
		this.itens.add(new BluRayShow(nomeItem, preco, duracao, classificacao, numeroFaixas, artista, nomeUsuario,
				telefoneUsuario));

	}

	public void cadastrarBluRayFilme(String nomeUsuario, String telefoneUsuario, String nomeItem, double preco,
			int duracao, String classificacao, String genero, int anoLancamento) {
		this.itens.add(new BluRayFilme(nomeItem, preco, duracao, classificacao, genero, anoLancamento, nomeUsuario,
				telefoneUsuario));

	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		for (Item item : itens) {
			if (item.getNome().equalsIgnoreCase(nomeItem) && item.getNomeDono().equalsIgnoreCase(nome)
					&& item.getTelefoneDono().equalsIgnoreCase(telefone))
				return item.getAtributo(atributo);
		}
		throw new IllegalArgumentException("LOL");
	}

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

	public void removerItem(String nome, String telefone, String nomeItem) {
		for (Item item : itens) {
			if (item.getNome().equalsIgnoreCase(nomeItem) && item.getNomeDono().equalsIgnoreCase(nome)
					&& item.getTelefoneDono().equalsIgnoreCase(telefone))
				itens.remove(item);
			break;
		}
	}

	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		for (Item item : itens) {
			if (item.getNome().equalsIgnoreCase(nomeItem) && item.getNomeDono().equalsIgnoreCase(nome)
					&& item.getTelefoneDono().equalsIgnoreCase(telefone))
				item.mudaAtributo(atributo, valor);
		}
	}

	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {

	}

	public Item getItem(String nomeItem, String nomeDono, String telefoneDono) {
		for (Item item : itens) {
			if (item.getNome().equalsIgnoreCase(nomeItem) && item.getNomeDono().equalsIgnoreCase(nomeDono)
					&& item.getTelefoneDono().equalsIgnoreCase(telefoneDono)) {
				return item;
			}
		}
		throw new IllegalArgumentException("Item nao encontrado");
	}

	public String listarItensOrdenadosPorNome() {
		String lista = "";
		Collections.sort(itens, new OrdemAlfabetica());
		for (Item item : itens)
			lista += item.toString() + "|";
		return lista;
	}

	public String listarItensOrdenadosPorValor() {
		String lista = "";
		Collections.sort(itens, new OrdemDeValor());
		for (Item item : itens)
			lista += item.toString() + "|";
		return lista;
	}

	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
		for (Item item : itens) {
			if (item.getNome().equalsIgnoreCase(nomeItem) && item.getNomeDono().equalsIgnoreCase(nome)
					&& item.getTelefoneDono().equalsIgnoreCase(telefone))
				return item.toString();
		}
		throw new IllegalArgumentException("Item nao encontrado");
	}

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
	
	public boolean usuarioTemItens(String nomeDono, String telefoneDono) {
		for (Item item : itens) {
			if(item.getNomeDono().equalsIgnoreCase(nomeDono) && item.getTelefoneDono().equalsIgnoreCase(telefoneDono)) {
				return true;
			}
		}
		return false;
	}

}
