package projeto;

public class EmprestimoId {

	private String nomeDonoItem;
	private String telefoneDonoItem;
	private String nomeRequerenteItem;
	private String telefoneRequerenteItem;
	private String nomeItem;
	private String dataEmprestimo;

	/**
	 * Construtor do EmprestimoId
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
	 * @param dataEmprestimo
	 *            Data da realizacao do emprestimo
	 */
	public EmprestimoId(String nomeDonoItem, String telefoneDonoItem, String nomeRequerenteItem,
			String telefoneRequerente, String nomeItem, String dataEmprestimo) {

		this.nomeDonoItem = nomeDonoItem;
		this.telefoneDonoItem = telefoneDonoItem;
		this.nomeRequerenteItem = nomeRequerenteItem;
		this.telefoneRequerenteItem = telefoneRequerente;
		this.nomeItem = nomeItem;
		this.dataEmprestimo = dataEmprestimo;

	}

	public String getNomeDonoItem() {
		return nomeDonoItem;
	}

	public void setNomeDonoItem(String nomeDonoItem) {
		this.nomeDonoItem = nomeDonoItem;
	}

	public String getTelefoneDonoItem() {
		return telefoneDonoItem;
	}

	public void setTelefoneDonoItem(String telefoneDonoItem) {
		this.telefoneDonoItem = telefoneDonoItem;
	}

	@Override
	/**
	 * Retorna representacao textual de um EmprestimoId
	 */
	public String toString() {
		return "EmprestimoId [nomeDonoItem=" + nomeDonoItem + ", telefoneDonoItem=" + telefoneDonoItem
				+ ", nomeRequerenteItem=" + nomeRequerenteItem + ", telefoneRequerenteItem=" + telefoneRequerenteItem
				+ ", nomeItem=" + nomeItem + ", dataEmprestimo=" + dataEmprestimo + "]";
	}

	public String getNomeRequerenteItem() {
		return nomeRequerenteItem;
	}

	public void setNomeRequerenteItem(String nomeRequerenteItem) {
		this.nomeRequerenteItem = nomeRequerenteItem;
	}

	public String getTelefoneRequerenteItem() {
		return telefoneRequerenteItem;
	}

	public void setTelefoneRequerenteItem(String telefoneRequerenteItem) {
		this.telefoneRequerenteItem = telefoneRequerenteItem;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public String getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	/**
	 * Valida se o usuario eh dono do item
	 * 
	 * @param nomeDono
	 *            Nome do usuario
	 * @param telefoneDono
	 *            Telefone do usuario
	 * @return
	 */
	public boolean isDono(String nomeDono, String telefoneDono) {
		return this.nomeDonoItem.equals(nomeDono) && this.telefoneDonoItem.equals(telefoneDono);
	}

	@Override
	/**
	 * Personaliza hashCode do objeto EmprestimoId
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEmprestimo == null) ? 0 : dataEmprestimo.hashCode());
		result = prime * result + ((nomeDonoItem == null) ? 0 : nomeDonoItem.hashCode());
		result = prime * result + ((nomeItem == null) ? 0 : nomeItem.hashCode());
		result = prime * result + ((nomeRequerenteItem == null) ? 0 : nomeRequerenteItem.hashCode());
		result = prime * result + ((telefoneDonoItem == null) ? 0 : telefoneDonoItem.hashCode());
		result = prime * result + ((telefoneRequerenteItem == null) ? 0 : telefoneRequerenteItem.hashCode());
		return result;
	}

	@Override
	/**
	 * Personaliza equals do objeto EmprestimoId
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmprestimoId other = (EmprestimoId) obj;
		if (dataEmprestimo == null) {
			if (other.dataEmprestimo != null)
				return false;
		} else if (!dataEmprestimo.equals(other.dataEmprestimo))
			return false;
		if (nomeDonoItem == null) {
			if (other.nomeDonoItem != null)
				return false;
		} else if (!nomeDonoItem.equals(other.nomeDonoItem))
			return false;
		if (nomeItem == null) {
			if (other.nomeItem != null)
				return false;
		} else if (!nomeItem.equals(other.nomeItem))
			return false;
		if (nomeRequerenteItem == null) {
			if (other.nomeRequerenteItem != null)
				return false;
		} else if (!nomeRequerenteItem.equals(other.nomeRequerenteItem))
			return false;
		if (telefoneDonoItem == null) {
			if (other.telefoneDonoItem != null)
				return false;
		} else if (!telefoneDonoItem.equals(other.telefoneDonoItem))
			return false;
		if (telefoneRequerenteItem == null) {
			if (other.telefoneRequerenteItem != null)
				return false;
		} else if (!telefoneRequerenteItem.equals(other.telefoneRequerenteItem))
			return false;
		return true;
	}

	/**
	 * Verifica a validade do usuario requerente do item
	 * 
	 * @param nome
	 *            Nome do usuario requerente do item
	 * @param telefone
	 *            Telefone do usuario requerente do item
	 * @return boolean
	 */
	public boolean isRequerente(String nome, String telefone) {
		return this.nomeRequerenteItem.equals(nome) && this.telefoneRequerenteItem.equals(telefone);
	}

}
