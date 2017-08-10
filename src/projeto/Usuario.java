
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
	private ItemController itemController;
	private EmprestimoController emprestimoController;
	private ReputacaoController reputacaoController;

	public Usuario(String nome, String telefone, String email) {

		this.valideNome(nome);
		this.valideTelefone(telefone);
		this.valideEmail(email);

		this.email = email;
		this.usuarioid = new UsuarioId(nome, telefone);
		this.itemController = new ItemController();
		this.emprestimoController = new EmprestimoController();
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
	
	public void addReputacao(double reputacao){
		this.reputacaoController.addReputacao(reputacao);
	}
	
	public double getReputacao(){
		return this.reputacaoController.getReputacao();
	}

	@Override
	public String toString() {
		return usuarioid.getNome() + ", " + email + ", " + this.email;
	}

	public boolean existeItem(String nomeItem) {
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

		if (nomeDono.equals(this.usuarioid.getNome()) && telefoneDono.equals(this.usuarioid.getTelefone()))
			if (!existeItem(nomeItem))
				throw new NullPointerException("Item nao encontrado");

		if (nomeDono.equals(this.usuarioid.getNome()) && telefoneDono.equals(this.usuarioid.getTelefone()))
			if (!itemController.estaEmprestado(nomeItem)) {
				emprestimoController.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente,
						nomeItem, dataEmprestimo, periodo);
				itemController.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem,
						dataEmprestimo);
				itemController.contaEmprestimo(nomeItem);
				reputacaoController.addReputacao(itemController.getPrecoItem(nomeItem)/10);
			} else
				throw new IllegalStateException("Item emprestado no momento");
		else
			emprestimoController.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente,
					nomeItem, dataEmprestimo, periodo);

	}

	public void mudaEstadoItem(String nomeItem) {
		itemController.mudaEstadoItem(nomeItem);
	}

	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {

		if (nomeDono.equals(this.usuarioid.getNome()) && telefoneDono.equals(this.usuarioid.getTelefone())) {
			if (itemController.estaEmprestado(nomeItem))
				emprestimoController.devolverItem(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem,
						dataEmprestimo, dataDevolucao);
			else 
				throw new IllegalStateException("Item nao emprestado no momento");
		} else if (nomeRequerente.equals(this.usuarioid.getNome())
				&& telefoneRequerente.equals(this.usuarioid.getTelefone()))
			emprestimoController.devolverItem(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem,
					dataEmprestimo, dataDevolucao);

	}

	public ArrayList<Item> getListItem() {
		return itemController.getListItem();
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

	public String pesquisarDetalhesItem(String nomeItem) {
		return itemController.pesquisarDetalhesItem(nomeItem);
	}

	public String listarEmprestimosUsuarioEmprestando(String nomeDono, String telefoneDono) {
		return this.emprestimoController.listarEmprestimosUsuarioEmprestando(nomeDono, telefoneDono);
	}

	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) {
		return this.emprestimoController.listarEmprestimosUsuarioPegandoEmprestado(nome, telefone);
	}

	public String listarEmprestimosItem(String nomeItem) {
		String mensagem = "";
		if (itemController.existeItem(nomeItem)) {
			{
				mensagem += emprestimoController.toStringEmprestimo(itemController.getEmprestimos(nomeItem));

			}
		}
		return mensagem;
		

	}
	public ArrayList<Item> listarItensNaoEmprestados(){
		return this.itemController.getListItemNaoEmprestado();
	}

	public ArrayList<Item> listarItensEmprestados() {
		return this.itemController.getListItemEmprestado();
	}

	public ArrayList<Item> listarTop10Itens() {
		return this.itemController.listarTop10Itens();
	}
	
	public double getPrecoItem(String nomeItem){
		return this.itemController.getPrecoItem(nomeItem);
	}
	public void addReputacaoDevolve(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, String nomeItem, String dataEmprestimo, double preco) {
		int diasMulta = emprestimoController.getMulta(nomeDono, telefoneDono,
				nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo);
		if (diasMulta > 0){
			this.reputacaoController.addReputacao(-(preco/100) * diasMulta);
			
		}
		else{
			this.reputacaoController.addReputacao((preco/20));
		}
		
	}

}