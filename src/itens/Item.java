package itens;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import projeto.EmprestimoId;

public abstract class Item {

	protected double preco;
	protected String nome;
	protected boolean isEmprestado;
	protected ArrayList<EmprestimoId> emprestimoIds;

	private void validePreco(double preco) {
		if (preco < 0)
			throw new IllegalArgumentException("Preco invalido");
	}

	private void valideNome(String nome) {
		if (nome == null || nome.trim().equals(""))
			throw new IllegalArgumentException("Nome de usuario invalido");
	}

	public Item(String nome, double preco) {

		this.valideNome(nome);
		this.validePreco(preco);

		this.preco = preco;
		this.nome = nome;
		this.isEmprestado = false;
		this.emprestimoIds = new ArrayList<EmprestimoId>();
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

	public void addEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo) {
		emprestimoIds.add(
				new EmprestimoId(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo));

	}

	public ArrayList<EmprestimoId> getEmprestimosId() {
		return (ArrayList<EmprestimoId>) emprestimoIds;
	}

	public void mudaAtributo(String atributo, String valor) {

		if (atributo.toLowerCase().equals("preco"))
			this.setPreco(Double.parseDouble(valor));
		else if (atributo.toLowerCase().equals("nome"))
			this.setNome(valor);
		else
			throw new IllegalArgumentException("Argumento invalido");

	}

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

}