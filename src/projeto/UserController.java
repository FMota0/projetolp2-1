package projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ComparadoresReputacao.OrdenaMelhorPiorReputacao;
import ComparadoresReputacao.OrdenaPiorMelhorReputacao;
import ComparadoresUsuario.OrdemAlfabeticaNome;
import Utilidade.Round;

public class UserController {

	private Map<UsuarioId, Usuario> usuarios;

	public UserController() {
		this.usuarios = new HashMap<UsuarioId, Usuario>();
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
	 * Verifica a validade dos dados do usuario
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 */
	public void verificaUsuarioInvalido(String nome, String telefone) {
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
	public void verificaUsuarioJaCadastrado(String nome, String telefone) {
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

	public Usuario getUsuario(String nomeUsuario, String telefoneUsuario) {
		this.verificaUsuarioInvalido(nomeUsuario, telefoneUsuario);
		return this.usuarios.get(new UsuarioId(nomeUsuario, telefoneUsuario));
	}

	public String listarTop10MelhoresUsuarios() {
		String mensagem = "";
		int i = 1;
		ArrayList<Usuario> superlist = new ArrayList<Usuario>();
		for (UsuarioId usuarioid : usuarios.keySet()) {
			superlist.add(usuarios.get(usuarioid));

		}
		Collections.sort(superlist, new OrdenaPiorMelhorReputacao());
		for (Usuario usuario : superlist) {
			if (i > 10) {
				break;
			}
			mensagem += i + ": " + usuario.getNome() + " - Reputacao: "
					+ String.format("%.2f", Round.round(usuario.getReputacao(), 2)) + "|";
			i += 1;
		}
		return mensagem;
	}

	public String listarTop10PioresUsuarios() {
		String mensagem = "";
		int i = 1;
		ArrayList<Usuario> superlist = new ArrayList<Usuario>();
		for (UsuarioId usuarioid : usuarios.keySet()) {
			superlist.add(usuarios.get(usuarioid));

		}
		Collections.sort(superlist, new OrdenaMelhorPiorReputacao());
		for (Usuario usuario : superlist) {
			if (i > 10) {
				break;
			}

			mensagem += i + ": " + usuario.getNome() + " - Reputacao: "
					+ String.format("%.2f", Round.round(usuario.getReputacao(), 2)) + "|";
			i += 1;
		}

		return mensagem;

	}

	public String listarCaloteiros() {
		String mensagem = "Lista de usuarios com reputacao negativa: ";
		ArrayList<Usuario> superlist = new ArrayList<Usuario>();
		for (UsuarioId usuarioid : usuarios.keySet()) {
			if (!usuarios.get(usuarioid).podeEmprestar()) {
				superlist.add(usuarios.get(usuarioid));
			}
		}
		Collections.sort(superlist, new OrdemAlfabeticaNome());
		for (Usuario usuario : superlist) {
			mensagem += usuario.toString() + "|";
		}
		if (mensagem.equals("Lista de usuarios com reputacao negativa: ")) {
			return "Nenhum usuario possui reputacao negativa";
		}
		return mensagem;
	}
}
