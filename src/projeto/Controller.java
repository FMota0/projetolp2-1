package projeto;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.Collections;

import ComparadoresItens.OrdemAlfabetica;
import ComparadoresItens.OrdemDeValor;
import itens.Item;

/**
 * 
 * Controlador de usuario
 * 
 * @author Hugo, Felipe Mota, Yago Gusmao
 *
 */
public class Controller {

	/**
	 * 
	 */
	private Map<UsuarioId, Usuario> usuarios;

	public Controller() {
		this.usuarios = new HashMap<UsuarioId, Usuario>();
	}

	private void verificaUsuarioInvalido(String nome, String telefone) {
		if (!this.existeUsuario(nome, telefone))
			throw new IllegalArgumentException("Usuario invalido");
	}

	private void verificaUsuarioJaCadastrado(String nome, String telefone) {
		if (this.existeUsuario(nome, telefone))
			throw new IllegalArgumentException("Usuario ja cadastrado");
	}

	/**
	 * Cadastrar usuario
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 * @param email
	 *            Email do usuario
	 */
	public void cadastrarUsuario(String nome, String telefone, String email) {

		this.verificaUsuarioJaCadastrado(nome, telefone);
		this.usuarios.put(new UsuarioId(nome, telefone), new Usuario(nome, telefone, email));
	}

	/**
	 * Remover usuario
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 */
	public void removerUsuario(String nome, String telefone) {

		this.verificaUsuarioInvalido(nome, telefone);

		this.usuarios.remove(new UsuarioId(nome, telefone));
	}

	/**
	 * Atualizar atributo de usuario
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 * @param atributo
	 *            Atributo do usuario que deve ser modificado
	 * @param valor
	 *            Novo valor que o atributo deve receber
	 */
	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {

		this.verificaUsuarioInvalido(nome, telefone);

		Usuario usuario = usuarios.get(new UsuarioId(nome, telefone)); // pegando
																		// o
																		// usuario
		usuarios.remove(new UsuarioId(nome, telefone)); // removendo o usuario
														// do Map
		usuario.mudaAtributo(atributo, valor); // alterando o atributo do
												// usuario
		nome = usuario.getNome(); // atualizando o valor do nome do usuario
		telefone = usuario.getTelefone(); // atualizando o valor do telefone do
											// usuario
		usuarios.put(new UsuarioId(nome, telefone), usuario); // inserindo o
																// usuario

	}

	public boolean existeUsuario(String nome, String telefone) {
		return usuarios.containsKey(new UsuarioId(nome, telefone));
	}

	public String listarUsuario(String nome, String telefone) {

		this.verificaUsuarioInvalido(nome, telefone);

		return this.usuarios.get(new UsuarioId(nome, telefone)).toString();
	}

	@Override
	public String toString() {
		String str = "";
		for (UsuarioId usuarioid : usuarios.keySet()) {
			str += usuarios.get(usuarioid).toString() + System.lineSeparator();
		}
		return str;
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {

		this.verificaUsuarioInvalido(nome, telefone);

		return this.usuarios.get(new UsuarioId(nome, telefone)).getAtributo(atributo);
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

		this.verificaUsuarioInvalido(nomeUsuario, telefoneUsuario);

		this.usuarios.get(new UsuarioId(nomeUsuario, telefoneUsuario)).cadastrarEletronico(nomeItem, preco, plataforma);
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

		this.verificaUsuarioInvalido(nomeUsuario, telefoneUsuario);

		this.usuarios.get(new UsuarioId(nomeUsuario, telefoneUsuario)).cadastrarTabuleiro(nomeItem, preco);
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

		this.verificaUsuarioInvalido(nomeUsuario, telefoneUsuario);

		this.usuarios.get(new UsuarioId(nomeUsuario, telefoneUsuario)).cadastrarBluRaySerie(nomeItem, preco, duracao,
				classificacao, genero, temporada);
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

		this.verificaUsuarioInvalido(nomeUsuario, telefoneUsuario);

		this.usuarios.get(new UsuarioId(nomeUsuario, telefoneUsuario)).cadastrarBluRayShow(nomeItem, preco, duracao,
				classificacao, numeroFaixas, artista);
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

		this.verificaUsuarioInvalido(nomeUsuario, telefoneUsuario);

		this.usuarios.get(new UsuarioId(nomeUsuario, telefoneUsuario)).cadastrarBluRayFilme(nomeItem, preco, duracao,
				classificacao, genero, anoLancamento);

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

		this.verificaUsuarioInvalido(nome, telefone);

		return usuarios.get(new UsuarioId(nome, telefone)).getInfoItem(nomeItem, atributo);
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
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String peca) {

		this.verificaUsuarioInvalido(nome, telefone);

		usuarios.get(new UsuarioId(nome, telefone)).adicionarPecaPerdida(nomeItem, peca);
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

		this.verificaUsuarioInvalido(nome, telefone);

		usuarios.get(new UsuarioId(nome, telefone)).removerItem(nomeItem);
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

		this.verificaUsuarioInvalido(nome, telefone);

		usuarios.get(new UsuarioId(nome, telefone)).atualizarItem(nomeItem, atributo, valor);
	}

	/**
	 * Registrar emprestimo de um item
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
	 *            Data para emprestimo do item
	 * @param periodo
	 *            Periodo de emprestimo do item
	 */
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {

		this.verificaUsuarioInvalido(nomeDono, telefoneDono);
		this.verificaUsuarioInvalido(nomeRequerente, telefoneRequerente);

		usuarios.get(new UsuarioId(nomeDono, telefoneDono)).registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente,
				telefoneRequerente, nomeItem, dataEmprestimo, periodo);
		usuarios.get(new UsuarioId(nomeRequerente, telefoneRequerente)).registrarEmprestimo(nomeDono, telefoneDono,
				nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, periodo);

		usuarios.get(new UsuarioId(nomeDono, telefoneDono)).mudaEstadoItem(nomeItem);

	}

	/**
	 * Registrar devolucao de item emprestado
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
	 *            Data de emprestimo do item
	 * @param dataDevolucao
	 *            Data que foi realizada a devolucao do item
	 */
	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {

		this.verificaUsuarioInvalido(nomeDono, telefoneDono);
		this.verificaUsuarioInvalido(nomeRequerente, telefoneRequerente);

		usuarios.get(new UsuarioId(nomeDono, telefoneDono)).devolverItem(nomeDono, telefoneDono, nomeRequerente,
				telefoneRequerente, nomeItem, dataEmprestimo, dataDevolucao);
		usuarios.get(new UsuarioId(nomeRequerente, telefoneRequerente)).devolverItem(nomeDono, telefoneDono,
				nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, dataDevolucao);

		usuarios.get(new UsuarioId(nomeDono, telefoneDono)).mudaEstadoItem(nomeItem);

	}

	/**
	 * Retorna uma lista de todos os itens registrados em ordem lexicográfica
	 * 
	 * @return lista de todos os itens registrados
	 */
	public String listarItensOrdenadosPorNome() {
		String lista = "";
		ArrayList<Item> superList = new ArrayList<>();
		for (UsuarioId usuarioId : usuarios.keySet()) {
			for (Item item : this.usuarios.get(usuarioId).getListItem())
				superList.add(item);
		}
		Collections.sort(superList, new OrdemAlfabetica());
		for (Item item : superList)
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
		ArrayList<Item> superList = new ArrayList<>();
		for (UsuarioId usuarioId : usuarios.keySet()) {
			for (Item item : this.usuarios.get(usuarioId).getListItem())
				superList.add(item);
		}
		Collections.sort(superList, new OrdemDeValor());
		for (Item item : superList)
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
		this.verificaUsuarioInvalido(nome, telefone);
		return this.usuarios.get(new UsuarioId(nome, telefone)).pesquisarDetalhesItem(nomeItem);
	}

	public String listarEmprestimosUsuarioEmprestando(String nomeDono, String telefoneDono) {
		this.verificaUsuarioInvalido(nomeDono, telefoneDono);
		return this.usuarios.get(new UsuarioId(nomeDono, telefoneDono)).listarEmprestimosUsuarioEmprestando(nomeDono,
				telefoneDono);
	}

	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) {
		this.verificaUsuarioInvalido(nome, telefone);
		return this.usuarios.get(new UsuarioId(nome, telefone)).listarEmprestimosUsuarioPegandoEmprestado(nome,
				telefone);
	}

	public String listarEmprestimosItem(String nomeItem) {
		String mensagem = "Emprestimos associados ao item: ";
		for (UsuarioId usuarioId : usuarios.keySet()) {
			mensagem += usuarios.get(usuarioId).listarEmprestimosItem(nomeItem);
		}
		if (mensagem.equals("Emprestimos associados ao item: "))
			return "Nenhum emprestimos associados ao item";
		return mensagem;
	}

	public String listarItensNaoEmprestados() {
		String mensagem = "";
		ArrayList<Item> superlist = new ArrayList<Item>();
		for(UsuarioId usuarioId : usuarios.keySet()) {
			for	(Item item : usuarios.get(usuarioId).listarItensNaoEmprestados())
				superlist.add(item);
		}
		Collections.sort(superlist, new OrdemAlfabetica());
		for(Item item : superlist) {
			mensagem += item.toString() + "|";
		}
		return mensagem;
	}
	
}