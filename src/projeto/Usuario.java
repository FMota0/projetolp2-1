
package projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ComparadoresEmprestimo.OrdemAlfabeticaItem;
import itens.BluRayFilme;
import itens.BluRaySerie;
import itens.BluRayShow;
import itens.Item;
import itens.JogoEletronico;
import itens.JogoTabuleiro;

/**
 * Usuario representado por : Nome Telefone Email Conjunto de itens;
 * 
 * @author Hugo, Yago
 * 
 */
public class Usuario {

	private UsuarioId usuarioid;
	private String email;
	private ReputacaoController reputacaoController;

	public Usuario(String nome, String telefone, String email) {

		this.valideNome(nome);
		this.valideTelefone(telefone);
		this.valideEmail(email);

		this.email = email;
		this.usuarioid = new UsuarioId(nome, telefone);
		this.reputacaoController = new ReputacaoController();
	}
	/**
	 * Validando o nome do usuario
	 * 
	 * @param nome
	 *            Nome do usuario
	 */
	private void valideNome(String nome) {

		if (nome == null || nome.trim().equals(""))
			throw new IllegalArgumentException("Nome de usuario invalido");

	}

	/**
	 * Validando telefone do usuario
	 * 
	 * @param telefone
	 *            Telefone do usuario
	 */
	private void valideTelefone(String telefone) {

		if (telefone == null || telefone.trim().equals(""))
			throw new IllegalArgumentException("Telefone de usuario invalido");

	}

	/**
	 * Validando email do usuario
	 * 
	 * @param email
	 *            Email do usuario
	 */
	private void valideEmail(String email) {

		if (email == null || email.trim().equals(""))
			throw new IllegalArgumentException("Email de usuario invalido");

	}

	public String getNome() {
		return usuarioid.getNome();
	}

	public void setNome(String nome) {
		this.valideNome(nome);
		this.usuarioid.setNome(nome);
	}

	public String getTelefone() {
		return usuarioid.getTelefone();
	}

	public void setTelefone(String telefone) {
		this.valideTelefone(telefone);
		this.usuarioid.setTelefone(telefone);
		;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.valideEmail(email);
		this.email = email;
	}
	
	public void addReputacao(double reputacao, boolean temItens){
		this.reputacaoController.addReputacao(reputacao, temItens);
	}
	
	public double getReputacao(){
		return this.reputacaoController.getReputacao();
	}
	/**
	 * Representacao textual de um usuario
	 */
	@Override
	public String toString() {
		return usuarioid.getNome() + ", " + this.email + ", " + this.usuarioid.getTelefone();
	}
	
	/**
	 * Retorna atributo do usuario
	 * 
	 * @param atributo
	 *            Atributo desejado
	 * @return conteudo do atributo
	 */
	public String getAtributo(String atributo) {
		if (atributo.toLowerCase().equals("nome"))
			return this.getNome();
		else if (atributo.toLowerCase().equals("telefone"))
			return this.getTelefone();
		else if (atributo.toLowerCase().equals("email"))
			return this.getEmail();
		else if (atributo.toLowerCase().equals("reputacao"))
			return "" + this.getReputacao();
		else if (atributo.toLowerCase().equals("cartao"))
			return "" + this.reputacaoController.toString();
		else
			throw new IllegalArgumentException("Atributo de usuario invalido");
	}
	/**
	 * Modifica conteudo do atributo do usuario
	 * 
	 * @param atributo
	 *            Nome do atributo
	 * @param valor
	 *            Novo conteudo do atributo
	 */
	public void mudaAtributo(String atributo, String valor) {
		if (atributo.toLowerCase().equals("nome"))
			this.setNome(valor);
		else if (atributo.toLowerCase().equals("telefone"))
			this.setTelefone(valor);
		else if (atributo.toLowerCase().equals("email"))
			this.setEmail(valor);
		else
			throw new IllegalArgumentException("Atributo de usuario invalido");
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((usuarioid == null) ? 0 : usuarioid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (usuarioid == null) {
			if (other.usuarioid != null)
				return false;
		} else if (!usuarioid.equals(other.usuarioid))
			return false;
		return true;
	}
	public int periodoMaximo() {
		return this.reputacaoController.periodoMaximo();
	}
	
	public boolean podeEmprestar() {
		return this.reputacaoController.podeEmprestar();
	}


}