package testes;

import org.junit.Test;

import projeto.Emprestimo;
import projeto.UserController;

public class EmprestimoTest {

	@Test(expected = IllegalArgumentException.class)
	public void registrarEmprestimoInvalidoTest() {
		UserController controle = new UserController();
		controle.cadastrarUsuario("Joao", "98888-8888", "sem email");
		controle.cadastrarTabuleiro("Joao", "98888-8888", "War", 70.0);
		controle.adicionarPecaPerdida("Joao", "98888-8888", "War", "dado");
		controle.cadastrarUsuario("Carlos", "89999-9999", "sem email");
		controle.registrarEmprestimo("Joao", "98888-8888", "Carlos", "89999-9999", "War", "01/01/2018", 7);

		// Item emprestado no momento
		controle.registrarEmprestimo("Joao", "98888-8888", "Josefina", "77777-7777", "War", "02/01/2018", 2);

	}

	@Test(expected = IllegalArgumentException.class)
	public void devolverItemInvalidoTest() {
		UserController controle = new UserController();
		controle.cadastrarUsuario("Joao", "98888-8888", "sem email");
		controle.cadastrarTabuleiro("Joao", "98888-8888", "War", 70.0);
		controle.adicionarPecaPerdida("Joao", "98888-8888", "War", "dado");
		controle.cadastrarUsuario("Carlos", "89999-9999", "sem email");

		// Emprestimo nao encontrado
		controle.devolverItem("Joao", "98888-8888", "Vilmar", "55555-9999", "War", "01/01/2018", "06/01/2018");

	}

	@Test(expected = IllegalArgumentException.class)
	public void registrarEmprestimoRequerenteInvalidoTest() {
		UserController controle = new UserController();
		controle.cadastrarUsuario("Carlos", "89999-9999", "sem email");

		// Usuario Invalido (requerente)
		controle.registrarEmprestimo("Carlos", "89999-9999", "Lucineia", "99988-7766", "The Walking Dead", "04/01/2018",
				7);

	}

	@Test(expected = IllegalArgumentException.class)
	public void registrarEmprestimoUsuarioInvalidoTest() {
		UserController controle = new UserController();
		controle.cadastrarUsuario("Carlos", "89999-9999", "sem email");
		// Usuario Invalido (dono)
		controle.registrarEmprestimo("Lucineia", "99988-7766", "Carlos", "89999-9999", "Game of Thrones", "08/01/2018",
				7);
	}

}
