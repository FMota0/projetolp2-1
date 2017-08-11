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

	public ItemController() {
		itens = new HashMap<String, Item>();
	}

	/**
	 * Valida o item no sistema
	 * 
	 * @param nomeItem
	 *            Nome do item
	 */
	public void verificaSeExisteItem(String nomeItem) {
		if (!this.existeItem(nomeItem))
			throw new IllegalArgumentException("Item nao encontrado");
	}

	/**
	 * Verifica se o item ja existe
	 * 
	 * @param nomeItem
	 *            Nome do item
	 * @return boolen
	 */
	public boolean existeItem(String nomeItem) {
		return this.itens.containsKey(nomeItem);
	}

	/**
	 * Cadastra novo item no mapa itens
	 * 
	 * @param item
	 *            Objeto item
	 * 
	 */
	public void cadastraItem(Item item) {
		itens.put(item.getNome(), item);
	}

	/**
	 * Verifica se item esta emprestado
	 * 
	 * @param nomeItem
	 *            Nome do item
	 * @return boolean
	 */
	public boolean estaEmprestado(String nomeItem) {
		return itens.get(nomeItem).getIsEmprestado();
	}

	/**
	 * Recupera informacao de item
	 * 
	 * @param nomeItem
	 *            Nome do item
	 * @param atributo
	 *            Atributo desejado
	 * @return informacao do atributo
	 */
	public String getInfoItem(String nomeItem, String atributo) {

		this.verificaSeExisteItem(nomeItem);
		return this.itens.get(nomeItem).getAtributo(atributo);
	}

	/**
	 * Adiciona peca perdida em jogo de tabuleiro
	 * 
	 * @param nomeItem
	 *            Nome do item
	 * @param peca
	 *            nome da peca
	 * @return boolean
	 */
	public boolean adicionarPecaPerdida(String nomeItem, String peca) {

		this.verificaSeExisteItem(nomeItem);

		if (!(itens.get(nomeItem) instanceof JogoTabuleiro)) { // WTF hugo ???
			throw new IllegalArgumentException("Item selecionado nao e jogo de tabuleiro");
		}
		JogoTabuleiro item = (JogoTabuleiro) itens.get(nomeItem);
		return item.adicionarPecaPerdida(peca);
	}

	/**
	 * Remove item da colecao de itens
	 * 
	 * @param nomeItem
	 *            Nome do item
	 */
	public void removerItem(String nomeItem) {
		this.verificaSeExisteItem(nomeItem);
		itens.remove(nomeItem);
	}

	/**
	 * Atualiza atributo de um item
	 * 
	 * @param nomeItem
	 *            Nome do item
	 * @param atributo
	 *            Atributo a ser atualizado
	 * @param valor
	 *            Novo conteudo do atributo
	 */
	public void atualizarItem(String nomeItem, String atributo, String valor) {
		this.verificaSeExisteItem(nomeItem);
		Item item = this.itens.get(nomeItem);
		this.itens.remove(nomeItem);
		item.mudaAtributo(atributo, valor);
		nomeItem = item.getNome();
		this.itens.put(nomeItem, item);
	}

	/**
	 * Cadastra jogo eletronico
	 * 
	 * @param nomeItem
	 *            Nome do item
	 * @param preco
	 *            Preco de venda
	 * @param plataforma
	 *            Plataforna de leitura do jogo
	 */
	public void cadastrarEletronico(String nomeItem, double preco, String plataforma) {
		this.itens.put(nomeItem, new JogoEletronico(nomeItem, preco, plataforma));

	}

	/**
	 * Cadastra jogo de tabuleiro
	 * 
	 * @param nomeItem
	 *            Nome do item
	 * @param preco
	 *            Preco de venda
	 */
	public void cadastrarTabuleiro(String nomeItem, double preco) {
		this.itens.put(nomeItem, new JogoTabuleiro(nomeItem, preco));
	}

	/**
	 * Cadastra Bluray de serie
	 * 
	 * @param nomeItem
	 *            Nome do item
	 * @param preco
	 *            Preco de venda
	 * @param duracao
	 *            Duracao em minutos da serie
	 * @param classificacao
	 *            Classificacao indicativa
	 * @param genero
	 *            Genero da serie
	 * @param temporada
	 *            Temporada da serie
	 */
	public void cadastrarBluRaySerie(String nomeItem, double preco, int duracao, String classificacao, String genero,
			int temporada) {
		this.itens.put(nomeItem, new BluRaySerie(nomeItem, preco, duracao, classificacao, genero, temporada));

	}

	/**
	 * Cadastra BluRay de Show
	 * 
	 * @param nomeItem
	 *            Nome do item
	 * @param preco
	 *            Preco de venda
	 * @param duracao
	 *            Duracao em minutos do show
	 * @param classificacao
	 *            Classificacao indicativa do show
	 * @param numeroFaixas
	 *            Numero de faixas
	 * @param artista
	 *            Artista do show
	 */
	public void cadastrarBluRayShow(String nomeItem, double preco, int duracao, String classificacao, int numeroFaixas,
			String artista) {
		this.itens.put(nomeItem, new BluRayShow(nomeItem, preco, duracao, classificacao, numeroFaixas, artista));

	}

	/**
	 * Cadastrar BluRay de Filme
	 * 
	 * @param nomeItem
	 *            Nome do Item
	 * @param preco
	 *            Preco de venda
	 * @param duracao
	 *            Duracao em minutos do filme
	 * @param classificacao
	 *            Classificacao indicativa do filme
	 * @param genero
	 *            Genero do filme
	 * @param anoLancamento
	 *            Ano de lancamento do filme
	 */
	public void cadastrarBluRayFilme(String nomeItem, double preco, int duracao, String classificacao, String genero,
			int anoLancamento) {
		this.itens.put(nomeItem, new BluRayFilme(nomeItem, preco, duracao, classificacao, genero, anoLancamento));

	}

	/**
	 * Modifica estado do item
	 * 
	 * @param nomeItem
	 *            Nome do item
	 */
	public void mudaEstadoItem(String nomeItem) {
		if (existeItem(nomeItem))
			this.itens.get(nomeItem).setIsEmprestado(!this.itens.get(nomeItem).getIsEmprestado());
	}

	/**
	 * Recupera todos os itens cadastrados
	 * 
	 * @return lista de todos os itens
	 */
	public ArrayList<Item> getListItem() {
		ArrayList<Item> listagem = new ArrayList<Item>();
		for (String nomeItem : itens.keySet())
			listagem.add(this.itens.get(nomeItem));
		return listagem;
	}

	/**
	 * Recupera todos os itens nao emprestados
	 * 
	 * @return lista de itens nao emprestados
	 */
	public ArrayList<Item> getListItemNaoEmprestado() {
		ArrayList<Item> listagem = new ArrayList<Item>();
		for (String nomeItem : itens.keySet())
			if (!this.itens.get(nomeItem).getIsEmprestado()) {
				listagem.add(this.itens.get(nomeItem));
			}
		return listagem;
	}

	/**
	 * Retorna informacoes de um item
	 * 
	 * @param nomeItem
	 *            Nome do item
	 * @return representacao textual das informacoes do item
	 */
	public String pesquisarDetalhesItem(String nomeItem) {
		this.verificaSeExisteItem(nomeItem);
		return itens.get(nomeItem).toString();
	}

	/**
	 * Registra emprestimo de um item
	 * 
	 * @param nomeDono
	 *            Nome do usuario dono do item
	 * @param telefoneDono
	 *            Telefone do usuario dono do item
	 * @param nomeRequerente
	 *            Nome do usuario requerente do item
	 * @param telefoneRequerente
	 *            Telefone do usuario requerente do item
	 * @param nomeItem
	 *            Nome do item
	 * @param dataEmprestimo
	 *            Data da realizacao do emprestimo
	 */
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo) {
		if (this.existeItem(nomeItem)) {
			this.itens.get(nomeItem).addEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem,
					dataEmprestimo);
		}
	}

	/**
	 * Recupera o historico dos emprestimos de um item
	 * 
	 * @param nomeItem
	 *            Nome do item
	 * @return lista com os emprestimos de um item
	 */
	public ArrayList<EmprestimoId> getEmprestimos(String nomeItem) {
		return (ArrayList<EmprestimoId>) this.itens.get(nomeItem).getEmprestimosId();
	}

}
