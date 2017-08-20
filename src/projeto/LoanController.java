package projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ComparadoresEmprestimo.OrdemAlfabeticaItem;

public class LoanController {
	
	private Map<EmprestimoId, Emprestimo> emprestimos;
	
	public LoanController(){
		this.emprestimos = new HashMap<EmprestimoId, Emprestimo>();
	}

	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {
		emprestimos.put(
				new EmprestimoId(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem,
						dataEmprestimo),
				new Emprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem,
						dataEmprestimo, periodo));
		
	}
	
	public boolean existeEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo) {
		return emprestimos.containsKey(
				new EmprestimoId(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo));
	}

	public Emprestimo getEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo) {
		return emprestimos.get(new EmprestimoId(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo));
	}
	
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

	public Emprestimo getEmprestimo(EmprestimoId emprestimoid) {
		return this.emprestimos.get(emprestimoid);
	}
	
	
}
