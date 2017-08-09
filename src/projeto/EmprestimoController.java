package projeto;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ComparadoresEmprestimo.OrdemAlfabeticaItem;

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
	
	public String listarEmprestimosUsuarioEmprestando(String nomeDono, String telefoneDono){
		ArrayList<Emprestimo> emprestimo = new ArrayList<>();
		for(EmprestimoId emprestimoId : this.emprestimos.keySet())
			if(emprestimoId.isDono(nomeDono, telefoneDono))
				emprestimo.add(this.emprestimos.get(emprestimoId));
		if(emprestimo.size() == 0)
			return "Nenhum item emprestado";
		Collections.sort(emprestimo, new OrdemAlfabeticaItem());
		String lista = "Emprestimos: ";
		for(Emprestimo emp : emprestimo)
			lista += emp.toString() + "|";
		return lista;
	}
}
