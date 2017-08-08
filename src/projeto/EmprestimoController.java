package projeto;

import java.util.HashMap;
import java.util.Map;

public class EmprestimoController {

	private Map<EmprestimoId,Emprestimo> emprestimos;
	
	public EmprestimoController(){
		emprestimos = new HashMap<EmprestimoId,Emprestimo>();
	}

	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {
		
		emprestimos.put(new EmprestimoId(nomeDono, telefoneDono,
				nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo), new Emprestimo(nomeDono, telefoneDono,
				nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, periodo));
		
	}

	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {
		
		if(!emprestimos.containsKey(new EmprestimoId(nomeDono, telefoneDono,
				nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo)))
			throw new IllegalStateException("Emprestimo nao encontrado");
		
		emprestimos.get(new EmprestimoId(nomeDono, telefoneDono,
				nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo)).setDataDevolucao(dataDevolucao);
		
		
	}
	
}
