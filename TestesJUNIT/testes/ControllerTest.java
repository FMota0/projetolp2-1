package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import projeto.Controller;

public class ControllerTest {

	/// Testes envolvendo cadastro e teste de existencia de usuario

	@Test
	public void cadastrarUsuarioTest() {
		Controller controle = new Controller();
		controle.cadastrarUsuario("felipe", "99", "sem email");
		assertTrue(controle.existeUsuario("felipe", "99"));
	}

	@Test
	public void cadastrarUsuario2Test() {
		Controller controle = new Controller();
		controle.cadastrarUsuario("felipe", "99", "sem email");
		assertFalse(controle.existeUsuario("tom", "99"));
	}

	@Test
	public void cadastrarUsuario3Test() {
		Controller controle = new Controller();
		controle.cadastrarUsuario("felipe", "99", "sem email");
		controle.cadastrarUsuario("luiza", "11", "email ?");
		assertTrue(controle.existeUsuario("luiza", "11"));
	}

	@Test
	public void cadastrarUsuario4Test() {
		Controller controle = new Controller();
		controle.cadastrarUsuario("felipe", "99", "sem email");
		controle.cadastrarUsuario("luiza", "11", "email ?");
		controle.cadastrarUsuario("luiza", "22", "bla bla");
		assertTrue(controle.existeUsuario("luiza", "22"));
	}

	@Test
	public void cadastrarUsuario5Test() {
		Controller controle = new Controller();
		controle.cadastrarUsuario("felipe", "99", "sem email");
		controle.cadastrarUsuario("luiza", "11", "email ?");
		controle.cadastrarUsuario("luiza", "22", "bla bla");
		assertFalse(controle.existeUsuario("luiza", "33"));
	}

	/// Testes envolvendo cadastro e atualizacao

	@Test
	public void cadastroAtualizaTest() {
		Controller controle = new Controller();
		controle.cadastrarUsuario("felipe", "11", "fmota@...");
		assertTrue(controle.existeUsuario("felipe", "11"));
		controle.atualizarUsuario("felipe", "11", "nome", "mota");
		assertTrue(controle.existeUsuario("mota", "11"));
		assertFalse(controle.existeUsuario("felipe", "11"));
	}

	@Test
	public void cadastroAtualiza2Test() {
		Controller controle = new Controller();
		controle.cadastrarUsuario("felipe", "11", "fmota@...");
		assertTrue(controle.existeUsuario("felipe", "11"));
		controle.atualizarUsuario("felipe", "11", "telefone", "22");
		assertTrue(controle.existeUsuario("felipe", "22"));
		assertFalse(controle.existeUsuario("felipe", "11"));
	}

	@Test
	public void cadastroAtualiza3Test() {
		Controller controle = new Controller();
		controle.cadastrarUsuario("felipe", "11", "fmota@...");
		assertTrue(controle.existeUsuario("felipe", "11"));
		controle.atualizarUsuario("felipe", "11", "email", "felipe.santos");
		assertTrue(controle.existeUsuario("felipe", "11"));
	}

	// Testes envolvendo listagem

	@Test
	public void listarUsuarioTest() {
		Controller controle = new Controller();
		controle.cadastrarUsuario("felipe", "11", "fmota@...");
		assertEquals("felipe, fmota@..., 11", controle.listarUsuario("felipe", "11"));
	}

	// Testes envolvendo reputacoes
	@Test
	public void reputacaoUsuarioTest() {
		Controller controle = new Controller();
		controle.cadastrarUsuario("hugo", "123", "hugo@");
		controle.cadastrarEletronico("hugo", "123", "csgo", 100, "pc");
		assertEquals("1: hugo - Reputacao: 5,00|", controle.listarTop10MelhoresUsuarios());
		assertEquals("1: hugo - Reputacao: 5,00|", controle.listarTop10PioresUsuarios());
		assertEquals("Nenhum usuario possui reputacao negativa", controle.listarCaloteiros());
		controle.cadastrarUsuario("felipe", "123", "felipe@");
		controle.cadastrarEletronico("felipe", "123", "dota2", 500, "pc");
		assertEquals("1: felipe - Reputacao: 25,00|2: hugo - Reputacao: 5,00|", controle.listarTop10MelhoresUsuarios());
		assertEquals("1: hugo - Reputacao: 5,00|2: felipe - Reputacao: 25,00|", controle.listarTop10PioresUsuarios());
		controle.cadastrarUsuario("yago", "123", "yago@");
		controle.registrarEmprestimo("hugo", "123", "yago", "123", "csgo", "21/10/1998", 5);
		controle.devolverItem("hugo", "123", "yago", "123", "csgo", "21/10/1998", "25/10/1998");
		assertEquals("1: felipe - Reputacao: 25,00|2: hugo - Reputacao: 15,00|3: yago - Reputacao: 5,00|",
				controle.listarTop10MelhoresUsuarios());
		assertEquals("1: yago - Reputacao: 5,00|2: hugo - Reputacao: 15,00|3: felipe - Reputacao: 25,00|",
				controle.listarTop10PioresUsuarios());
		controle.registrarEmprestimo("hugo", "123", "yago", "123", "csgo", "22/10/1998", 5);
		controle.devolverItem("hugo", "123", "yago", "123", "csgo", "22/10/1998", "25/11/1998");
		assertEquals("1: felipe - Reputacao: 25,00|2: hugo - Reputacao: 25,00|3: yago - Reputacao: -24,00|",
				controle.listarTop10MelhoresUsuarios());
		assertEquals("1: yago - Reputacao: -24,00|2: felipe - Reputacao: 25,00|3: hugo - Reputacao: 25,00|",
				controle.listarTop10PioresUsuarios());
		assertEquals("Lista de usuarios com reputacao negativa: yago, yago@, 123|", controle.listarCaloteiros());
	}

	@Test(expected = IllegalStateException.class)

	public void reputacaoUsuarioTextExcept1() {
		Controller controle = new Controller();
		controle.cadastrarUsuario("hugo", "123", "hugo@");
		controle.cadastrarEletronico("hugo", "123", "csgo", 100, "pc");
		assertEquals("1: hugo - Reputacao: 5,00|", controle.listarTop10MelhoresUsuarios());
		assertEquals("1: hugo - Reputacao: 5,00|", controle.listarTop10PioresUsuarios());
		assertEquals("Nenhum usuario possui reputacao negativa", controle.listarCaloteiros());
		controle.cadastrarUsuario("felipe", "123", "felipe@");
		controle.cadastrarEletronico("felipe", "123", "dota2", 500, "pc");
		assertEquals("1: felipe - Reputacao: 25,00|2: hugo - Reputacao: 5,00|", controle.listarTop10MelhoresUsuarios());
		assertEquals("1: hugo - Reputacao: 5,00|2: felipe - Reputacao: 25,00|", controle.listarTop10PioresUsuarios());
		controle.cadastrarUsuario("yago", "123", "yago@");
		controle.registrarEmprestimo("hugo", "123", "yago", "123", "csgo", "21/10/1998", 7);

	}

	@Test(expected = IllegalStateException.class)

	public void reputacaoUsuarioTextExcept2() {
		Controller controle = new Controller();
		controle.cadastrarUsuario("hugo", "123", "hugo@");
		controle.cadastrarEletronico("hugo", "123", "csgo", 100, "pc");
		assertEquals("1: hugo - Reputacao: 5,00|", controle.listarTop10MelhoresUsuarios());
		assertEquals("1: hugo - Reputacao: 5,00|", controle.listarTop10PioresUsuarios());
		assertEquals("Nenhum usuario possui reputacao negativa", controle.listarCaloteiros());
		controle.cadastrarUsuario("felipe", "123", "felipe@");
		controle.cadastrarEletronico("felipe", "123", "dota2", 500, "pc");
		assertEquals("1: felipe - Reputacao: 25,00|2: hugo - Reputacao: 5,00|", controle.listarTop10MelhoresUsuarios());
		assertEquals("1: hugo - Reputacao: 5,00|2: felipe - Reputacao: 25,00|", controle.listarTop10PioresUsuarios());
		controle.registrarEmprestimo("hugo", "123", "felipe", "123", "csgo", "21/10/1998", 8);

	}
}