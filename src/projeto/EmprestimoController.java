package projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ComparadoresEmprestimo.OrdemAlfabeticaItem;

/**
 * Classe responsavel pela implementacao dos metodos relacionados as atividades
 * de emprestimo
 * 
 * @author ...
 *
 */
public class EmprestimoController {

	private Map<EmprestimoId, Emprestimo> emprestimos;

	/**
	 * Construtor do EmprestimoController
	 */
	public EmprestimoController() {
		emprestimos = new HashMap<EmprestimoId, Emprestimo>();
	}

	/**
	 * Registrar um novo emprestimo
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
	 *            Data inicial do emprestimo
	 * @param periodo
	 *            Numero de dias de duracao do emprestimo
	 */
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {

		emprestimos.put(
				new EmprestimoId(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo),
				new Emprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo,
						periodo));

	}

	/**
	 * Registra devolucao de item emprestado
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
	 *            Data inicial do emprestimo
	 * @param dataDevolucao
	 *            Data do dia da devoluvao do item
	 */
	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {

		if (!emprestimos.containsKey(
				new EmprestimoId(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo)))
			throw new IllegalStateException("Emprestimo nao encontrado");

		emprestimos.get(
				new EmprestimoId(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo))
				.setDataDevolucao(dataDevolucao);

	}

	/**
	 * Gera lista de emprestimos onde o usuario emprestou seus itens.
	 * 
	 * @param nomeDono
	 *            Nome do usuario dono do item
	 * @param telefoneDono
	 *            Telefone do usuario dono do item
	 * @return lista com todos os emprestimos que o usuario emprestou seus itens
	 */
	public String listarEmprestimosUsuarioEmprestando(String nomeDono, String telefoneDono) {
		ArrayList<Emprestimo> emprestimo = new ArrayList<>();
		for (EmprestimoId emprestimoId : this.emprestimos.keySet())
			if (emprestimoId.isDono(nomeDono, telefoneDono))
				emprestimo.add(this.emprestimos.get(emprestimoId));
		if (emprestimo.size() == 0)
			return "Nenhum item emprestado";
		Collections.sort(emprestimo, new OrdemAlfabeticaItem());
		String lista = "Emprestimos: ";
		for (Emprestimo emp : emprestimo)
			lista += emp.toString() + "|";
		return lista;
	}

	/**
	 * /** Gera lista de emprestimos onde o usuario pego itens emprestado.
	 * 
	 * @param nomeDono
	 *            Nome do usuario dono do item
	 * @param telefoneDono
	 *            Telefone do usuario dono do item
	 * @return lista com todos os emprestimos que o usuario pegou itens
	 */
	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) {
		ArrayList<Emprestimo> emprestimo = new ArrayList<>();
		for (EmprestimoId emprestimoId : this.emprestimos.keySet())
			if (emprestimoId.isRequerente(nome, telefone))
				emprestimo.add(this.emprestimos.get(emprestimoId));
		if (emprestimo.size() == 0)
			return "Nenhum item pego emprestado";
		Collections.sort(emprestimo, new OrdemAlfabeticaItem());
		String lista = "Emprestimos pegos: ";
		for (Emprestimo emp : emprestimo)
			lista += emp.toString() + "|";
		return lista;
	}

	/**
	 * Gera representacao textual de todos os emprestimos do sistema
	 * 
	 * @param emprestimosid
	 *            Colecao de emprestimos
	 * @return representacao textual de todos os emprestimos
	 */
	public String toStringEmprestimo(ArrayList<EmprestimoId> emprestimosid) {
		String mensagem = "";
		for (EmprestimoId emprestimoid : emprestimosid) {
			mensagem += emprestimos.get(emprestimoid).toString() + "|";
		}
		return mensagem;

	}
}
