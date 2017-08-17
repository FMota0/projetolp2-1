package projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ComparadoresEmprestimo.OrdemAlfabeticaItem;
import ComparadoresItens.OrdemAlfabetica;
import ComparadoresItens.OrdemDeValor;
import ComparadoresItens.OrdemEmprestimos;
import itens.BluRayFilme;
import itens.BluRaySerie;
import itens.BluRayShow;
import itens.Item;
import itens.JogoEletronico;
import itens.JogoTabuleiro;

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
	private Map<EmprestimoId, Emprestimo> emprestimos;
	private List<Item> itens;

	public Controller() {
		this.usuarios = new HashMap<UsuarioId, Usuario>();
		this.emprestimos = new HashMap<EmprestimoId, Emprestimo>();
		this.itens = new ArrayList<Item>();
	}

	/**
	 * Verifica a validade dos dados do usuario
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 */
	private void verificaUsuarioInvalido(String nome, String telefone) {
		if (!this.existeUsuario(nome, telefone))
			throw new IllegalArgumentException("Usuario invalido");
	}

	/**
	 * Verifica se o usuario ja esta cadastrado
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 */
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

	/**
	 * Verifica se usuario ja existe no sistema.
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 * @return Usuario cadastrado com os paramentros dados
	 */
	public boolean existeUsuario(String nome, String telefone) {
		return usuarios.containsKey(new UsuarioId(nome, telefone));
	}

	/**
	 * Recupera informacoes do usuario requerido (toString)
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @return Padrao textual das informacoes do usuario requerido
	 */
	public String listarUsuario(String nome, String telefone) {

		this.verificaUsuarioInvalido(nome, telefone);

		return this.usuarios.get(new UsuarioId(nome, telefone)).toString();
	}

	/**
	 * Retorna representacao textual de todos os usuarios.
	 */
	@Override
	public String toString() {
		String str = "";
		for (UsuarioId usuarioid : usuarios.keySet()) {
			str += usuarios.get(usuarioid).toString() + System.lineSeparator();
		}
		return str;
	}

	/**
	 * Recupera informacao de um atributo especifico do usuario requerido
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 * @param atributo
	 *            Atributo desejado para informacoes
	 * @return informacoes do atributo do usuario
	 */
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
		this.usuarios.get(new UsuarioId(nomeUsuario, telefoneUsuario)).addReputacao((preco / 20));
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

		this.verificaUsuarioInvalido(nomeUsuario, telefoneUsuario);
		this.usuarios.get(new UsuarioId(nomeUsuario, telefoneUsuario)).addReputacao((preco / 20));
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

		this.verificaUsuarioInvalido(nomeUsuario, telefoneUsuario);
		this.usuarios.get(new UsuarioId(nomeUsuario, telefoneUsuario)).addReputacao((preco / 20));
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

		this.verificaUsuarioInvalido(nomeUsuario, telefoneUsuario);
		this.usuarios.get(new UsuarioId(nomeUsuario, telefoneUsuario)).addReputacao((preco / 20));
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

		this.verificaUsuarioInvalido(nomeUsuario, telefoneUsuario);
		this.usuarios.get(new UsuarioId(nomeUsuario, telefoneUsuario)).addReputacao((preco / 20));
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

		this.verificaUsuarioInvalido(nome, telefone);
		existeItem(nomeItem, nome, telefone);
		for (Item item : itens) {
			if (item.getNome().equalsIgnoreCase(nomeItem) && item.getNomeDono().equalsIgnoreCase(nome)
					&& item.getTelefoneDono().equalsIgnoreCase(telefone))
				return item.getAtributo(atributo);
		}
		return "";
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
		existeItem(nomeItem, nome, telefone);
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
		existeItem(nomeItem, nome, telefone);
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

		this.verificaUsuarioInvalido(nome, telefone);
		this.verificaUsuarioInvalido(nome, telefone);
		existeItem(nomeItem, nome, telefone);
		for (Item item : itens) {
			if (item.getNome().equalsIgnoreCase(nomeItem) && item.getNomeDono().equalsIgnoreCase(nome)
					&& item.getTelefoneDono().equalsIgnoreCase(telefone))
				item.mudaAtributo(atributo, valor);
		}

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
		existeItem(nomeItem, nomeDono, telefoneDono);
		for (Item item : itens) {
			if (item.getNome().equalsIgnoreCase(nomeItem) && item.getNomeDono().equalsIgnoreCase(nomeDono)
					&& item.getTelefoneDono().equalsIgnoreCase(telefoneDono)) {
				if (item.getIsEmprestado()) {
					throw new IllegalStateException("Item emprestado no momento");
				}
				emprestimos.put(
						new EmprestimoId(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem,
								dataEmprestimo),
						new Emprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem,
								dataEmprestimo, periodo));
				item.addEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem,
						dataEmprestimo);
				item.contaEmprestimo();
				usuarios.get(new UsuarioId(nomeDono, telefoneDono)).addReputacao(item.getPreco() / 10);
			}
		}
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
		existeItem(nomeItem, nomeDono, telefoneDono);
		if (!emprestimos.containsKey(
				new EmprestimoId(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo)))
			throw new IllegalStateException("Emprestimo nao encontrado");
		for (Item item : itens) {
			if (item.getNome().equalsIgnoreCase(nomeItem) && item.getNomeDono().equalsIgnoreCase(nomeDono)
					&& item.getTelefoneDono().equalsIgnoreCase(telefoneDono)) {
				if (item.getIsEmprestado()) {
					emprestimos.get(new EmprestimoId(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente,
							nomeItem, dataEmprestimo)).setDataDevolucao(dataDevolucao);
					item.mudaEstadoItem();
					int diasmulta = emprestimos.get(new EmprestimoId(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente,
							nomeItem, dataEmprestimo)).getDiasMulta();
					if(diasmulta > 0) {
							usuarios.get(new UsuarioId(nomeRequerente, telefoneRequerente)).addReputacao(-(item.getPreco()/100)*diasmulta);
					}
					else {
						usuarios.get(new UsuarioId(nomeRequerente, telefoneRequerente)).addReputacao(item.getPreco()/20);
					}

				} else {
					throw new IllegalStateException("Item nao emprestado no momento");
				}
			}
		}

	}

	private void existeItem(String nomeItem, String nome, String telefone) {
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
	 * Retorna uma lista de todos os itens registrados em ordem lexicográfica
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
		this.verificaUsuarioInvalido(nome, telefone);
		existeItem(nomeItem, nome, telefone);
		for (Item item : itens) {
			if (item.getNome().equalsIgnoreCase(nomeItem) && item.getNomeDono().equalsIgnoreCase(nome)
					&& item.getTelefoneDono().equalsIgnoreCase(telefone))
				return item.toString();
		}
		return "";
	}

	/**
	 * Recura historio de emprestimos onde o usuario emprestou seus itens para
	 * outros usuarios.
	 * 
	 * @param nomeDono
	 *            Nome do usuario dono do item
	 * @param telefoneDono
	 *            Telefone do usuario dono do item
	 * @return lista com todos os emprestimos que o usuario emprestou itens.
	 */
	public String listarEmprestimosUsuarioEmprestando(String nomeDono, String telefoneDono) {
		this.verificaUsuarioInvalido(nomeDono, telefoneDono);
		String mensagem = "Emprestimos: ";
		ArrayList<Emprestimo> superlist = new ArrayList<Emprestimo>();
		for (EmprestimoId emprestimoid : emprestimos.keySet()) {
			if (emprestimos.get(emprestimoid).getNomeDonoItem().equalsIgnoreCase(nomeDono) && emprestimos.get(emprestimoid).getTelefoneDonoItem().equalsIgnoreCase(telefoneDono)) {
				superlist.add(emprestimos.get(emprestimoid));
			}		
		}
		Collections.sort(superlist, new OrdemAlfabeticaItem());
		for(Emprestimo emprestimo : superlist) {
			mensagem += emprestimo.toString() + "|";
		}
		if (mensagem.equals("Emprestimos: ")){
			return "Nenhum item emprestado";
		}
		return mensagem;
	}

	/**
	 * Recupera historio de emprestimos onde o usuario pegou emprestado itens de
	 * outros usuario.
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 * @return lista com todos os emprestimos que o usuario pegou itens emprestados.
	 */
	public String listarEmprestimosUsuarioPegandoEmprestado(String nomeDono, String telefoneDono) {
		this.verificaUsuarioInvalido(nomeDono, telefoneDono);
		this.verificaUsuarioInvalido(nomeDono, telefoneDono);
		String mensagem = "Emprestimos pegos: ";
		ArrayList<Emprestimo> superlist = new ArrayList<Emprestimo>();
		for (EmprestimoId emprestimoid : emprestimos.keySet()) {
			if (emprestimos.get(emprestimoid).getNomeRequerenteItem().equalsIgnoreCase(nomeDono) && emprestimos.get(emprestimoid).getTelefoneRequerenteItem().equalsIgnoreCase(telefoneDono)) {
				superlist.add(emprestimos.get(emprestimoid));
			}		
		}
		Collections.sort(superlist, new OrdemAlfabeticaItem());
		for(Emprestimo emprestimo : superlist) {
			mensagem += emprestimo.toString() + "|";
		}
		if (mensagem.equals("Emprestimos pegos: ")){
			return "Nenhum item pego emprestado";
		}
		return mensagem;
	}
	

	/**
	 * Recupera historico de emprestimos do item.
	 * 
	 * @param nomeItem
	 *            Nome do item
	 * @return lista com todos os emprestimos do item.
	 */
	public String listarEmprestimosItem(String nomeItem) {
		String mensagem = "Emprestimos associados ao item: ";
		for(Item item : itens) {
			if(item.getNome().equals(nomeItem)) {
				for(EmprestimoId emprestimoid : item.getEmprestimosId()) {
					mensagem += emprestimos.get(emprestimoid).toString() + "|";
				}
			}
		}
		if (mensagem.equals("Emprestimos associados ao item: ")){
			return "Nenhum emprestimos associados ao item";
		}
		return mensagem;
	}

	/**
	 * Recupera lista de todos os itens que estam disponiveis para emprestimos.
	 * 
	 * @return lista de itens nao emprestados
	 */
	public String listarItensNaoEmprestados() {
		String mensagem = "";
		ArrayList<Item> superlist = new ArrayList<Item>();
		for(Item item : itens) {
			if(!item.getIsEmprestado()) {
				superlist.add(item);
			}
		}
		Collections.sort(superlist, new OrdemAlfabetica());
		for(Item item : superlist) {
			mensagem += item.toString() + "|";
		}
		return mensagem;
	}

	public String listarItensEmprestados() {
		String mensagem = "";
		ArrayList<Item> superlist = new ArrayList<Item>();
		for(Item item : itens) {
			if(item.getIsEmprestado()) {
				superlist.add(item);
			}
		}
		Collections.sort(superlist, new OrdemAlfabetica());
		for(Item item : superlist) {
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

}