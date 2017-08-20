package projeto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/**
 * Instancia emprestimo de um item.
 * 
 * @author Hugo Addobbati, Yago Gusmao
 *
 */
public class Emprestimo {

	private EmprestimoId emprestimoid;
	private LocalDate dataInicialEmprestimo;
	private int numeroDiasParaEmprestimo;
	private LocalDate dataDeDevolucao;
	private String dataInicialEmprestimoStr;
	private String dataDevolucaoStr;
	
	/**
	 * Gera representacao comparavel de data
	 * 
	 * @param format
	 * @return LocalDate
	 */
	private LocalDate parse(String format) {
		String lista[] = format.split("/"); // DD - MM - YYYY
		int dia = Integer.parseInt(lista[0]);
		int mes = Integer.parseInt(lista[1]);
		int ano = Integer.parseInt(lista[2]);
		LocalDate date = LocalDate.of(ano, mes, dia);
		return date;
	}
	/**
	 * Construtor de um emprestimo.
	 * 
	 * @param nomeDonoItem
	 *            Nome do usuario dono do item
	 * @param telefoneDonoItem
	 *            Telefone do usuario dono do item
	 * @param nomeRequerenteItem
	 *            Nome do usuario requerente do item
	 * @param telefoneRequerente
	 *            Telefone do usuario requerente do item
	 * @param nomeItem
	 *            Nome do item
	 * @param dataInicialEmprestimo
	 *            Data inicial do emprestimo
	 * @param numeroDiasParaEmprestimo
	 *            Numero de dias de duracao do emprestimo
	 */
	public Emprestimo(String nomeDonoItem, String telefoneDonoItem, String nomeRequerenteItem,
			String telefoneRequerente, String nomeItem, String dataInicialEmprestimo, int numeroDiasParaEmprestimo) {

		this.emprestimoid = new EmprestimoId(nomeDonoItem, telefoneDonoItem, nomeRequerenteItem, telefoneRequerente,
				nomeItem, dataInicialEmprestimo);
		this.dataInicialEmprestimo = this.parse(dataInicialEmprestimo);
		this.numeroDiasParaEmprestimo = numeroDiasParaEmprestimo;
		this.dataDeDevolucao = null;
		this.dataInicialEmprestimoStr = dataInicialEmprestimo;
		this.dataDevolucaoStr = null;
	}
	/**
	 * Recupera nome do usuario dono do item.
	 * 
	 * @return nome do usuario
	 */
	public String getNomeDonoItem() {
		return this.emprestimoid.getNomeDonoItem();
	}
	/**
	 * Recupera telefone do usuario dono do item.
	 * 
	 * @return telefone do usuario
	 */
	public String getTelefoneDonoItem() {
		return this.emprestimoid.getTelefoneDonoItem();
	}
	/**
	 * Recupera nome do usuario requerente do item.
	 * 
	 * @return nome do usuario
	 */
	public String getNomeRequerenteItem() {
		return this.emprestimoid.getNomeRequerenteItem();
	}
	/**
	 * Recupera telefone do usuario requerente do item.
	 * 
	 * @return telefone do usuario
	 */
	public String getTelefoneRequerenteItem() {
		return this.emprestimoid.getTelefoneRequerenteItem();
	}
	/**
	 * Recupera nome do item.
	 * 
	 * @return nome do item
	 */
	public String getNomeItem() {
		return this.emprestimoid.getNomeItem();
	}
	/**
	 * Modifica data de devolucao do item emprestado.
	 * 
	 * @param dataDevolucao
	 *            Data de devolução do item
	 */
	public void setDataDevolucao(String dataDevolucao) {
		this.dataDeDevolucao = this.parse(dataDevolucao);
		this.dataDevolucaoStr = dataDevolucao;
	}

	/**
	 * Retorna representacao textual de um emprestimo.
	 */
	@Override
	public String toString() {
		String entregado;
		if (this.dataDeDevolucao == null)
			entregado = "Emprestimo em andamento";
		else
			entregado = this.dataDevolucaoStr;
		return "EMPRESTIMO - De: " + this.emprestimoid.getNomeDonoItem() + ", Para: "
				+ this.emprestimoid.getNomeRequerenteItem() + ", " + this.emprestimoid.getNomeItem() + ", "
				+ this.dataInicialEmprestimoStr + ", " + this.numeroDiasParaEmprestimo + " dias, ENTREGA: " + entregado;
	}
	/**
	 * Personaliza hashCode do objeto emprestimo.
	 */
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
	/**
	 * Personaliza o equals do objeto emprestimo.
	 */
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

	private int getElapsedDate() {
		if (!(dataDeDevolucao == null)) {
			return ((int) dataInicialEmprestimo.until(dataDeDevolucao, ChronoUnit.DAYS));
		}
		throw new IllegalArgumentException("Emprestimo ainda em andamento");
	}

	public int getDiasMulta() {
		if (this.getElapsedDate() > this.numeroDiasParaEmprestimo) {
			return this.getElapsedDate() - numeroDiasParaEmprestimo;
		} else {
			return 0;
		}
	}

}
