package projeto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

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
	private UserController usuariosController;
	private LoanController emprestimoController;
	private ItemController itensController;

	public Controller() {
		this.usuariosController = new UserController();
		this.emprestimoController = new LoanController();
		this.itensController = new ItemController();
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
		this.usuariosController.cadastrarUsuario(nome, telefone, email);
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
		this.usuariosController.removerUsuario(nome, telefone);
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
		this.usuariosController.atualizarUsuario(nome, telefone, atributo, valor);
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
		return this.usuariosController.existeUsuario(nome, telefone);
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
		return this.usuariosController.listarUsuario(nome, telefone);
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
		return this.usuariosController.getInfoUsuario(nome, telefone, atributo);
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

		this.usuariosController.verificaUsuarioInvalido(nomeUsuario, telefoneUsuario);
		this.itensController.cadastrarEletronico(nomeUsuario, telefoneUsuario, nomeItem, preco, plataforma);
		Usuario paraMudar = this.usuariosController.getUsuario(nomeUsuario, telefoneUsuario);
		paraMudar.addReputacao((preco / 20), usuarioTemItens(nomeUsuario, telefoneUsuario));
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

		this.usuariosController.verificaUsuarioInvalido(nomeUsuario, telefoneUsuario);
		this.itensController.cadastrarTabuleiro(nomeUsuario, telefoneUsuario, nomeItem, preco);
		Usuario paraMudar = this.usuariosController.getUsuario(nomeUsuario, telefoneUsuario);
		paraMudar.addReputacao((preco / 20), usuarioTemItens(nomeUsuario, telefoneUsuario));
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

		this.usuariosController.verificaUsuarioInvalido(nomeUsuario, telefoneUsuario);
		this.itensController.cadastrarBluRaySerie(nomeUsuario, telefoneUsuario, nomeItem, preco, duracao, classificacao, genero, temporada);
		Usuario paraMudar = this.usuariosController.getUsuario(nomeUsuario, telefoneUsuario);
		paraMudar.addReputacao((preco / 20), usuarioTemItens(nomeUsuario, telefoneUsuario));
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

		this.usuariosController.verificaUsuarioInvalido(nomeUsuario, telefoneUsuario);
		this.itensController.cadastrarBluRayShow(nomeUsuario, telefoneUsuario, nomeItem, preco, duracao, classificacao, numeroFaixas, artista);
		Usuario paraMudar = this.usuariosController.getUsuario(nomeUsuario, telefoneUsuario);
		paraMudar.addReputacao((preco / 20), usuarioTemItens(nomeUsuario, telefoneUsuario));
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

		this.usuariosController.verificaUsuarioInvalido(nomeUsuario, telefoneUsuario);
		this.itensController.cadastrarBluRayFilme(nomeUsuario, telefoneUsuario, nomeItem, preco, duracao, classificacao, genero, anoLancamento);
		Usuario paraMudar = this.usuariosController.getUsuario(nomeUsuario, telefoneUsuario);
		paraMudar.addReputacao((preco / 20), usuarioTemItens(nomeUsuario, telefoneUsuario));
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

		this.usuariosController.verificaUsuarioInvalido(nome, telefone);
		this.itensController.existeItem(nomeItem, nome, telefone);
		return this.itensController.getInfoItem(nome, telefone, nomeItem, atributo);
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

		this.usuariosController.verificaUsuarioInvalido(nome, telefone);
		this.itensController.existeItem(nomeItem, nome, telefone);
		this.itensController.adicionarPerdida(nome, telefone, nomeItem, peca);
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
		this.usuariosController.verificaUsuarioInvalido(nome, telefone);
		this.itensController.existeItem(nomeItem, nome, telefone);
		this.itensController.removerItem(nome, telefone, nomeItem);
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

		this.usuariosController.verificaUsuarioInvalido(nome, telefone);
		this.itensController.existeItem(nomeItem, nome, telefone);
		this.itensController.atualizarItem(nome, telefone, nomeItem, atributo, valor);
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

		this.usuariosController.verificaUsuarioInvalido(nomeDono, telefoneDono);
		this.usuariosController.verificaUsuarioInvalido(nomeRequerente, telefoneRequerente);
		this.itensController.existeItem(nomeItem, nomeDono, telefoneDono);
		this.itensController.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, periodo);
		Item item = this.itensController.getItem(nomeItem, nomeDono, telefoneDono);
		
		if (item.getIsEmprestado()) {
			throw new IllegalStateException("Item emprestado no momento");
		}
		Usuario requerente = this.usuariosController.getUsuario(nomeRequerente, telefoneRequerente);
		if(!requerente.podeEmprestar()) {
			throw new IllegalStateException("Usuario nao pode pegar nenhum item emprestado");
		}
		if(periodo > requerente.periodoMaximo()) {
			throw new IllegalStateException("Usuario impossiblitado de pegar emprestado por esse periodo");
		}
		this.emprestimoController.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, periodo);
		item.addEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem,
				dataEmprestimo);
		item.contaEmprestimo();
		Usuario dono = this.usuariosController.getUsuario(nomeDono, telefoneDono);
		dono.addReputacao(item.getPreco() / 10,  usuarioTemItens(nomeDono, telefoneDono));
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

		this.usuariosController.verificaUsuarioInvalido(nomeDono, telefoneDono);
		this.usuariosController.verificaUsuarioInvalido(nomeRequerente, telefoneRequerente);
		this.itensController.existeItem(nomeItem, nomeDono, telefoneDono);
		if (!this.emprestimoController.existeEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo))
			throw new IllegalStateException("Emprestimo nao encontrado");
		Item item = this.itensController.getItem(nomeItem, nomeDono, telefoneDono);
		if (item.getIsEmprestado()) {
			Emprestimo paraMudar = this.emprestimoController.getEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente,
					nomeItem, dataEmprestimo);
			paraMudar.setDataDevolucao(dataDevolucao);
			item.mudaEstadoItem();
			int diasmulta = paraMudar.getDiasMulta();
			Usuario requerente = this.usuariosController.getUsuario(nomeRequerente, telefoneRequerente);
			if(diasmulta > 0) {
					requerente.addReputacao(-(item.getPreco()/100)*diasmulta,usuarioTemItens(nomeRequerente, telefoneRequerente));
			}
			else {
				requerente.addReputacao(item.getPreco()/20,usuarioTemItens(nomeRequerente, telefoneRequerente));
			}

		} else {
			throw new IllegalStateException("Item nao emprestado no momento");
		}
	}

	/**
	 * Retorna uma lista de todos os itens registrados em ordem lexicográfica
	 * 
	 * @return lista de todos os itens registrados
	 */
	public String listarItensOrdenadosPorNome() {
		return this.itensController.listarItensOrdenadosPorNome();
	}

	/**
	 * Retorna uma lista de todos os itens registrados em ordem por seus respectivos
	 * precos
	 * 
	 * @return lista de todos os itens registrados
	 */
	public String listarItensOrdenadosPorValor() {
		return this.itensController.listarItensOrdenadosPorValor();
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
		this.usuariosController.verificaUsuarioInvalido(nome, telefone);
		this.itensController.existeItem(nomeItem, nome, telefone);
		return this.itensController.pesquisarDetalhesItem(nome, telefone, nomeItem);
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
		this.usuariosController.verificaUsuarioInvalido(nomeDono, telefoneDono);
		return this.emprestimoController.listarEmprestimosUsuarioEmprestando(nomeDono, telefoneDono);
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
		this.usuariosController.verificaUsuarioInvalido(nomeDono, telefoneDono);
		this.usuariosController.verificaUsuarioInvalido(nomeDono, telefoneDono);
		return this.emprestimoController.listarEmprestimosUsuarioPegandoEmprestado(nomeDono, telefoneDono);
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
		List<EmprestimoId> emprestimoId = this.itensController.getListaEmprestimos(nomeItem);
		for(EmprestimoId emprestimoid : emprestimoId) {
			mensagem += this.emprestimoController.getEmprestimo(emprestimoid).toString() + "|";
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
		return this.itensController.listarItensNaoEmprestados();
	}

	public String listarItensEmprestados() {
		return this.itensController.listarItensEmprestados();
	}
	
	public String listarTop10Itens() {
		return this.itensController.listarTop10Itens();
	}

	private boolean usuarioTemItens(String nomeDono, String telefoneDono) {
		return this.itensController.usuarioTemItens(nomeDono, telefoneDono);
	}
	
	
	public String listarCaloteiros() {
		return this.usuariosController.listarCaloteiros();
	}

	public String listarTop10MelhoresUsuarios() {
		return this.usuariosController.listarTop10MelhoresUsuarios();
	}
	
	public String listarTop10PioresUsuarios() {
		return this.usuariosController.listarTop10PioresUsuarios();
	}

	public void fecharSistema() {
		try {
			ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("UserController.txt"));
			oos1.writeObject(this.usuariosController);
			oos1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("ItemController.txt"));
			oos2.writeObject(this.itensController);
			oos2.close();
		}
		catch(IOException e) {
			e.printStackTrace();
			
		}
		try {
			ObjectOutputStream oos3 = new ObjectOutputStream(new FileOutputStream("EmprestimoController.txt"));
			oos3.writeObject(this.emprestimoController);
			oos3.close();
		}
		catch(IOException e) {
			e.printStackTrace();
			
		}
		
	}
	
	public void iniciarSistema() {
		UserController uc = null;
		ItemController ic = null;
		LoanController lc = null;
		try {
			ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("UserController.txt"));
			try {
				uc = (UserController) ois1.readObject();
				ois1.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("ItemController.txt"));
			try {
				ic = (ItemController) ois1.readObject();
				ois1.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("EmprestimoController.txt"));
			try {
				lc = (LoanController) ois1.readObject();
				ois1.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		this.usuariosController = uc;
		this.itensController = ic;
		this.emprestimoController = lc;
	}
	
}