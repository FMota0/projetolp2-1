package itens;

import java.util.ArrayList;
import java.util.Locale;

public class JogoTabuleiro extends Item{

	private ArrayList<String> pecasPerdidas;

	public JogoTabuleiro(String nome, double preco){
		super(nome, preco);
		this.pecasPerdidas = new ArrayList<String>();
	}
	
	public boolean adicionarPecaPerdida(String peca){
		return pecasPerdidas.add(peca);
	}

	@Override
	public String toString() {
		String emprestado;
		if (this.isEmprestado)
			emprestado = "Emprestado";
		else
			emprestado = "Nao emprestado";
		String hasPecasPerdidas;
		if(this.pecasPerdidas.size() > 0)
			hasPecasPerdidas = "COM PECAS PERDIDAS";
		else
			hasPecasPerdidas = "COMPLETO";
		return "JOGO DE TABULEIRO: " + this.nome + ", R$ " + this.preco + ", "
				+ emprestado + ", " + hasPecasPerdidas;
	}
	
}