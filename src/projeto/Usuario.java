
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

/**
 * Usuario representado por : Nome Telefone Email Conjunto de itens;
 * 
 * @author Hugo
 * 
 */
public class Usuario {

	private String nome;
	private String telefone;
	private String email;
	private ItemController itemController;
	private EmprestimoController emprestimoController;

	private void verificaSeExisteItem(String nomeItem){
		itemController.verificaSeExisteItem(nomeItem);
	}
	
	public Usuario(String nome, String telefone, String email) {

		this.valideNome(nome);
		this.valideTelefone(telefone);
		this.valideEmail(email);

		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.itemController = new ItemController();
		this.emprestimoController = new EmprestimoController();
	}

	public void cadastraItem(Item item) {
		itemController.cadastraItem(item);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
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
		return nome;
	}

	public void setNome(String nome) {
		this.valideNome(nome);
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.valideTelefone(telefone);
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.valideEmail(email);
		this.email = email;
	}

	@Override
	public String toString() {
		return nome + ", " + email + ", " + telefone;
	}
	
	public boolean existeItem(String nomeItem){
		return itemController.existeItem(nomeItem);
	}

	public String getAtributo(String atributo) {
		if (atributo.toLowerCase().equals("nome"))
			return this.getNome();
		else if (atributo.toLowerCase().equals("telefone"))
			return this.getTelefone();
		else if (atributo.toLowerCase().equals("email"))
			return this.getEmail();
		else
			throw new IllegalArgumentException("Atributo de usuario invalido");
	}

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

	public String getInfoItem(String nomeItem, String atributo) {
		
		return itemController.getInfoItem(nomeItem, atributo);
	}

	public boolean adicionarPecaPerdida(String nomeItem, String peca) {

		return itemController.adicionarPecaPerdida(nomeItem, peca);
	}

	public void removerItem(String nomeItem) {
		itemController.removerItem(nomeItem);
	}

	public void atualizarItem(String nomeItem, String atributo, String valor) {
		itemController.atualizarItem(nomeItem, atributo, valor);
	}

	public void cadastrarEletronico(String nomeItem, double preco, String plataforma) {
		itemController.cadastrarEletronico(nomeItem, preco, plataforma);
		
	}

	public void cadastrarTabuleiro(String nomeItem, double preco) {
		itemController.cadastrarTabuleiro(nomeItem, preco);
	}

	public void cadastrarBluRaySerie(String nomeItem, double preco, int duracao, String classificacao, String genero,
			int temporada) {
		itemController.cadastrarBluRaySerie(nomeItem, preco, duracao, classificacao, genero, temporada);
		
	}

	public void cadastrarBluRayShow(String nomeItem, double preco, int duracao, String classificacao, int numeroFaixas,
			String artista) {
		itemController.cadastrarBluRayShow(nomeItem, preco, duracao, classificacao, numeroFaixas, artista);
		
	}

	public void cadastrarBluRayFilme(String nomeItem, double preco, int duracao, String classificacao, String genero,
			int anoLancamento) {
		itemController.cadastrarBluRayFilme(nomeItem, preco, duracao, classificacao, genero, anoLancamento);
		
	}

	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {
		
		if(nomeDono.equals(this.nome) && telefone.equals(this.telefone))
			if(!existeItem(nomeItem))
				throw new NullPointerException("Item nao encontrado");
		
		if(nomeDono.equals(this.nome) && telefone.equals(this.telefone))
			if(!itemController.estaEmprestado(nomeItem))
				emprestimoController.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, periodo);
			else
				throw new IllegalStateException("Item emprestado no momento");
		else
			emprestimoController.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, periodo);

	}
	
	public void mudaEstadoItem(String nomeItem){
		itemController.mudaEstadoItem(nomeItem);
	}

	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {
		
		if(nomeDono.equals(this.nome) && telefone.equals(this.telefone))
			if(itemController.estaEmprestado(nomeItem))
				emprestimoController.devolverItem(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, dataDevolucao);
			
	}

	public ArrayList<Item> getListItem() {
		return itemController.getListItem();
	}

	public String pesquisarDetalhesItem(String nomeItem) {
		return itemController.pesquisarDetalhesItem(nomeItem);
	}

}