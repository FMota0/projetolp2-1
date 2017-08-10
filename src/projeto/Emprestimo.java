package projeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

import itens.Item;

public class Emprestimo {


	private EmprestimoId emprestimoid;
	private LocalDate dataInicialEmprestimo;
	private int numeroDiasParaEmprestimo;
	private LocalDate dataDeDevolucao;
	
	private LocalDate parse(String format){
		String lista[] = format.split("/"); // DD - MM - YYYY
		int dia = Integer.parseInt(lista[0]);
		int mes = Integer.parseInt(lista[1]);
		int ano = Integer.parseInt(lista[2]);
		LocalDate date = LocalDate.of(ano, mes, dia);
		return date;
	}
	
	public Emprestimo(String nomeDonoItem, String telefoneDonoItem, String nomeRequerenteItem, String telefoneRequerente, String nomeItem,
			String dataInicialEmprestimo, int numeroDiasParaEmprestimo){
		
		this.emprestimoid = new EmprestimoId(nomeDonoItem, telefoneDonoItem, nomeRequerenteItem, telefoneRequerente, nomeItem, dataInicialEmprestimo);
		this.dataInicialEmprestimo = this.parse(dataInicialEmprestimo);
		this.numeroDiasParaEmprestimo = numeroDiasParaEmprestimo;
		this.dataDeDevolucao = null;
	}

	public String getNomeDonoItem() {
		return this.emprestimoid.getNomeDonoItem();
	}

	public String getTelefoneDonoItem() {
		return this.emprestimoid.getTelefoneDonoItem();
	}

	public String getNomeRequerenteItem() {
		return this.emprestimoid.getNomeRequerenteItem();
	}

	public String getTelefoneRequerenteItem() {
		return this.emprestimoid.getTelefoneRequerenteItem();
	}

	public String getNomeItem() {
		return this.emprestimoid.getNomeItem();
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDeDevolucao = this.parse(dataDevolucao);
	}
	
	private String dataInicial(){ // eu nao sei mexer com LocalDate e nem pesquisar no google. Felipe
		return this.dataInicialEmprestimo.getDayOfMonth() + "/" + 
			   this.dataInicialEmprestimo.getMonthValue() + "/" + 
			   this.dataInicialEmprestimo.getYear();
	}
	
	private String dataDevolucao(){
		return this.dataDeDevolucao.getDayOfMonth() + "/" + 
			   this.dataDeDevolucao.getMonthValue() + "/" + 
			   this.dataDeDevolucao.getYear();
	}

	@Override
	public String toString() {
		String entregado;
		if(this.dataDeDevolucao == null)
			entregado = "Emprestimo em andamento";
		else
			entregado = this.dataDevolucao();
		return "EMPRESTIMO - De: " + this.emprestimoid.getNomeDonoItem() + 
				", Para: " + this.emprestimoid.getNomeRequerenteItem() + 
				", " + this.emprestimoid.getNomeItem() + ", " + 
				this.dataInicial() + 
				", " + this.numeroDiasParaEmprestimo + 
				" dias, ENTREGA: " + entregado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataDeDevolucao == null) ? 0 : dataDeDevolucao.hashCode());
		result = prime * result + ((dataInicialEmprestimo == null) ? 0 : dataInicialEmprestimo.hashCode());
		result = prime * result + ((emprestimoid == null) ? 0 : emprestimoid.hashCode());
		result = prime * result + numeroDiasParaEmprestimo;
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
		Emprestimo other = (Emprestimo) obj;
		if (dataDeDevolucao == null) {
			if (other.dataDeDevolucao != null)
				return false;
		} else if (!dataDeDevolucao.equals(other.dataDeDevolucao))
			return false;
		if (dataInicialEmprestimo == null) {
			if (other.dataInicialEmprestimo != null)
				return false;
		} else if (!dataInicialEmprestimo.equals(other.dataInicialEmprestimo))
			return false;
		if (emprestimoid == null) {
			if (other.emprestimoid != null)
				return false;
		} else if (!emprestimoid.equals(other.emprestimoid))
			return false;
		if (numeroDiasParaEmprestimo != other.numeroDiasParaEmprestimo)
			return false;
		return true;
	}
	
	
	

}
