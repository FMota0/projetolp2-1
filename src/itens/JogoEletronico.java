package itens;

import java.util.Locale;

public class JogoEletronico extends Item {
	private String plataforma;

	public JogoEletronico(String nome, double preco, String plataforma) {
		super(nome, preco);
		this.plataforma = plataforma;
	}

	@Override
	public String toString() {
		String emprestado;
		if (this.isEmprestado)
			emprestado = "Emprestado";
		else
			emprestado = "Nao emprestado";
		return "JOGO ELETRONICO: " + this.nome + ", R$ " + this.preco
				+ ", " + emprestado + ", " + this.plataforma;
	}

}
