package projeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ComparadoresEmprestimo.OrdemAlfabeticaItem;

public class LoanController implements Serializable{
		
	private Map<EmprestimoId, Emprestimo> emprestimos;
	
	public LoanController(){
		this.emprestimos = new HashMap<EmprestimoId, Emprestimo>();
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
		emprestimos.put(
				new EmprestimoId(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem,
						dataEmprestimo),
				new Emprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem,
						dataEmprestimo, periodo));
		
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
	
	public int devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {
		
		Emprestimo emprestimo = this.emprestimos.get(new EmprestimoId(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente,
				nomeItem, dataEmprestimo));
		emprestimo.setDataDevolucao(dataDevolucao);
		return emprestimo.getDiasMulta();
		
	}
	
	/**
	 * Verifica se existe um emprestimo a partir do seu dono
	 * @param nomeDono
	 * @param telefoneDono
	 * @param nomeRequerente
	 * @param telefoneRequerente
	 * @param nomeItem
	 * @param dataEmprestimo
	 * @return
	 */
	
	public boolean existeEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo) {
		return emprestimos.containsKey(
				new EmprestimoId(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo));
	}

	/**
	 * Retorna um emprestimo
	 * @param nomeDono
	 * @param telefoneDono
	 * @param nomeRequerente
	 * @param telefoneRequerente
	 * @param nomeItem
	 * @param dataEmprestimo
	 * @return
	 */
	
	public Emprestimo getEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo) {
		return emprestimos.get(new EmprestimoId(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo));
	}
	
	/**
	 * Retorna uma lista dos emprestimos que estão sendo feitos por um usuário
	 * @param nomeDono
	 * @param telefoneDono
	 * @return
	 */
	
	public String listarEmprestimosUsuarioEmprestando(String nomeDono, String telefoneDono) {
		String mensagem = "Emprestimos: ";
		ArrayList<Emprestimo> superlist = new ArrayList<Emprestimo>();
		for (EmprestimoId emprestimoid : emprestimos.keySet()) {
			if (emprestimos.get(emprestimoid).getNomeDonoItem().equalsIgnoreCase(nomeDono) && emprestimos.get(emprestimoid).getTelefoneDonoItem().equalsIgnoreCase(telefoneDono)) {
				superlist.add(emprestimos.get(emprestimoid));
			}		
		}
		Collections.sort(superlist, new OrdemAlfabeticaItem());
		for(Emprestimo emprestimo : superlist) {
			mensagem += emprestimo.toString() + "|";
		}
		if (mensagem.equals("Emprestimos: ")){
			return "Nenhum item emprestado";
		}
		return mensagem;
	}
	
	/**
	 * Retorna uma lista dos emprestimos que estão sendo feitos por um usuário
	 * @param nomeDono
	 * @param telefoneDono
	 * @return
	 */
	
	public String listarEmprestimosUsuarioPegandoEmprestado(String nomeDono, String telefoneDono) {
		String mensagem = "Emprestimos pegos: ";
		ArrayList<Emprestimo> superlist = new ArrayList<Emprestimo>();
		for (EmprestimoId emprestimoid : emprestimos.keySet()) {
			if (emprestimos.get(emprestimoid).getNomeRequerenteItem().equalsIgnoreCase(nomeDono) && emprestimos.get(emprestimoid).getTelefoneRequerenteItem().equalsIgnoreCase(telefoneDono)) {
				superlist.add(emprestimos.get(emprestimoid));
			}		
		}
		Collections.sort(superlist, new OrdemAlfabeticaItem());
		for(Emprestimo emprestimo : superlist) {
			mensagem += emprestimo.toString() + "|";
		}
		if (mensagem.equals("Emprestimos pegos: ")){
			return "Nenhum item pego emprestado";
		}
		return mensagem;
	}

	/**
	 * Retorna um emprestimo
	 * @param nomeDono
	 * @param telefoneDono
	 * @param nomeRequerente
	 * @param telefoneRequerente
	 * @param nomeItem
	 * @param dataEmprestimo
	 * @return
	 */
	
	public Emprestimo getEmprestimo(EmprestimoId emprestimoid) {
		return this.emprestimos.get(emprestimoid);
	}
	
	
}
