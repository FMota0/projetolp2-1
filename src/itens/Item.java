package itens;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import projeto.EmprestimoId;

/**
 * Instacia itens
 * 
 * @author Hugo, Felipe Mota, Yago Gusmao
 *
 */

public abstract class Item implements Serializable{

	protected double preco;
	protected String nome;
	protected boolean isEmprestado;
	protected List<EmprestimoId> emprestimoIds;
	protected int emprestimos;
	protected String nomeDono;
	protected String telefoneDono;
	
	/**
	 * Verifica a validez da entrada do preco do item
	 * 
	 * @param preco
	 *            Preco de venda do item
	 */
	
	private void validePreco(double preco) {
		if (preco < 0)
			throw new IllegalArgumentException("Preco invalido");
	}
	
	/**
	 * Verifica a validez da entrada do nome do usuario.
	 * 
	 * @param nome
	 *            Nome do usuario
	 */
	
	private void valideNome(String nome) {
		if (nome == null || nome.trim().equals(""))
			throw new IllegalArgumentException("Nome de usuario invalido");
	}
	
	/**
	 * Construtor de um item
	 * 
	 * @param nome
	 *            Nome do item
	 * @param preco
	 *            Preco de venda do item
	 */
	
	public Item(String nome, double preco, String nomeDono, String telefoneDono) {

		this.valideNome(nome);
		this.validePreco(preco);

		this.preco = preco;
		this.nome = nome;
		this.isEmprestado = false;
		this.emprestimoIds = new ArrayList<EmprestimoId>();
		this.nomeDono = nomeDono;
		this.telefoneDono = telefoneDono;
	}

	public String getNomeDono() {
		return nomeDono;
	}

	public void setNomeDono(String nomeDono) {
		this.nomeDono = nomeDono;
	}

	public String getTelefoneDono() {
		return telefoneDono;
	}

	public void setTelefoneDono(String telefoneDono) {
		this.telefoneDono = telefoneDono;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.validePreco(preco);
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.validePreco(preco);
		this.nome = nome;
	}
	
	public void contaEmprestimo(){
		this.emprestimos += 1;
	}
	
	public int getNumEmprestimos(){
		return this.emprestimos;
	}
	
	/**
	 * Adiciona novo emprestimo no registro de emprestimos
	 * 
	 * @param nomeDono
	 * @param telefoneDono
	 * @param nomeRequerente
	 * @param telefoneRequerente
	 * @param nomeItem
	 * @param dataEmprestimo
	 */
	
	public void addEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo) {
		emprestimoIds.add(
				new EmprestimoId(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo));
			this.mudaEstadoItem();

	}
	
	/**
	 * Recupera historico de emprestimos
	 * 
	 * @return lista de todos os emprestimos
	 */
	
	public void mudaEstadoItem() {
		this.isEmprestado = !this.isEmprestado;
	}
	
	public ArrayList<EmprestimoId> getEmprestimosId() {
		return (ArrayList<EmprestimoId>) emprestimoIds;
	}
	
	/**
	 * Modifica atributo (nome ou preco) de item
	 * 
	 * @param atributo
	 *            Atributo para modificacao
	 * @param valor
	 *            Informacao atual para substituicao
	 */
	
	public void mudaAtributo(String atributo, String valor) {

		if (atributo.toLowerCase().equals("preco"))
			this.setPreco(Double.parseDouble(valor));
		else if (atributo.toLowerCase().equals("nome"))
			this.setNome(valor);
		else
			throw new IllegalArgumentException("Argumento invalido");

	}
	
	/**
	 * Retorna informacao de um atributo do item (nome ou preco)
	 * 
	 * @param atributo
	 *            Atributo desejado para informacao
	 * @return detalhes do atributo
	 */

	public String getAtributo(String atributo) {

		if (atributo.toLowerCase().equals("preco"))
			return "" + this.getPreco();
		else if (atributo.toLowerCase().equals("nome"))
			return this.getNome();
		else
			throw new IllegalArgumentException("Argumento invalido");
	}

	public boolean getIsEmprestado() {
		return isEmprestado;
	}

	public void setIsEmprestado(boolean emprestimo) {
		this.isEmprestado = emprestimo;
	}
	
	public String toStringEmprestado(){
		return "Dono do item: " + emprestimoIds.get(emprestimoIds.size()-1).getNomeDonoItem() + ", Nome do item emprestado: " + this.nome;
	}
	
	public String toString(){
		if (this.isEmprestado)
			return  "Emprestado";
		else
			return  "Nao emprestado";
	}
	
	public String toStringTop10() {
		return null;
	}
	

}