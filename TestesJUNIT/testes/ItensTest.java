package testes;

import static org.junit.Assert.*;
import org.junit.Test;
import projeto.Controller;
import projeto.Usuario;

public class ItensTest {

	@Test
	public void listarItensOrdenadosPorNomeTest() {
		Controller controle = new Controller();
		controle.cadastrarUsuario("yago", "654", "yago@...");
		controle.cadastrarTabuleiro("yago", "654", "War", 70.0);
		controle.adicionarPecaPerdida("yago", "654", "War", "dado");
		controle.cadastrarUsuario("hugo", "321", "hugo@...");
		controle.cadastrarBluRayFilme("hugo", "321", "Crepusculo", 1.99, 120, "QUATORZE_ANOS", "ROMANCE", 2008);
		controle.cadastrarUsuario("felipe", "456", "mota@...");
		controle.cadastrarBluRaySerie("felipe", "456", "The Walking Dead", 79.99, 120, "DEZESSEIS_ANOS", "SUSPENSE", 1);
		controle.cadastrarUsuario("anne", "123", "anne@...");
		controle.cadastrarBluRayShow("anne", "123", "RBD Ao Vivo", 19.99, 60, "DOZE_ANOS", 20, "REBELDES");
		controle.cadastrarEletronico("anne", "123", "Pokemon Omega Ruby", 20, "OUTRO");
		
		String retornoAtual = controle.listarItensOrdenadosPorNome();
		String retornoEsperado = "FILME: Crepusculo, R$ 1.99, Nao emprestado, 120 min, QUATORZE_ANOS, ROMANCE, 2008|JOGO ELETRONICO: Pokemon Omega Ruby, R$ 20.0, Nao emprestado, OUTRO|SHOW: RBD Ao Vivo, R$ 19.99, Nao emprestado, 60 min, DOZE_ANOS, REBELDES, 20 faixas|SERIE: The Walking Dead, R$ 79.99, Nao emprestado, 120 min, DEZESSEIS_ANOS, SUSPENSE, Temporada 1|JOGO DE TABULEIRO: War, R$ 70.0, Nao emprestado, COM PECAS PERDIDAS|";
		assertEquals(retornoAtual, retornoEsperado);

	}
	
	@Test
	public void listarItensOrdenadosPorValorTest() {
		Controller controle = new Controller();
		controle.cadastrarUsuario("yago", "654", "yago@...");
		controle.cadastrarTabuleiro("yago", "654", "War", 70.0);
		controle.adicionarPecaPerdida("yago", "654", "War", "dado");
		controle.cadastrarTabuleiro("yago", "654", "Xadrez de Bruxo", 1000.0);
		controle.cadastrarUsuario("hugo", "321", "hugo@...");
		controle.cadastrarBluRayFilme("hugo", "321", "Crepusculo", 1.99, 120, "QUATORZE_ANOS", "ROMANCE", 2008);
		controle.cadastrarUsuario("felipe", "456", "mota@...");
		controle.cadastrarBluRaySerie("felipe", "456", "The Walking Dead", 79.99, 120, "DEZESSEIS_ANOS", "SUSPENSE", 1);
		controle.cadastrarUsuario("anne", "123", "anne@...");
		controle.cadastrarBluRayShow("anne", "123", "RBD Ao Vivo", 19.99, 60, "DOZE_ANOS", 20, "REBELDES");
		controle.cadastrarEletronico("anne", "123", "Pokemon Omega Ruby", 20, "OUTRO");
		
		
		String retornoAtual = controle.listarItensOrdenadosPorValor();
		String retornoEsperado = "FILME: Crepusculo, R$ 1.99, Nao emprestado, 120 min, QUATORZE_ANOS, ROMANCE, 2008|SHOW: RBD Ao Vivo, R$ 19.99, Nao emprestado, 60 min, DOZE_ANOS, REBELDES, 20 faixas|JOGO ELETRONICO: Pokemon Omega Ruby, R$ 20.0, Nao emprestado, OUTRO|JOGO DE TABULEIRO: War, R$ 70.0, Nao emprestado, COM PECAS PERDIDAS|SERIE: The Walking Dead, R$ 79.99, Nao emprestado, 120 min, DEZESSEIS_ANOS, SUSPENSE, Temporada 1|JOGO DE TABULEIRO: Xadrez de Bruxo, R$ 1000.0, Nao emprestado, COMPLETO|";
		assertEquals(retornoAtual, retornoEsperado);

	}
	
	@Test
	public void pesquisarDetalhesItemTest() {
		Controller controle = new Controller();
		controle.cadastrarUsuario("Maria", "96666-6666", "sem email");
		controle.cadastrarBluRayFilme("Maria", "96666-6666", "Crepusculo", 1.99, 120, "QUATORZE_ANOS", "ROMANCE", 2008);
		
		String retornoAtual1 = controle.pesquisarDetalhesItem("Maria", "96666-6666", "Crepusculo");
		String retornoEsperado1 = "FILME: Crepusculo, R$ 1.99, Nao emprestado, 120 min, QUATORZE_ANOS, ROMANCE, 2008";
		assertEquals(retornoAtual1, retornoEsperado1);
		

		controle.cadastrarUsuario("Joao", "98888-8888", "joao@...");
		controle.cadastrarTabuleiro("Joao", "98888-8888", "War", 70.0);
		controle.adicionarPecaPerdida("Joao", "98888-8888", "War", "dado");
		
		String retornoAtual2 = controle.pesquisarDetalhesItem("Joao", "98888-8888", "War");
		String retornoEsperado2 = "JOGO DE TABULEIRO: War, R$ 70.0, Nao emprestado, COM PECAS PERDIDAS";
		assertEquals(retornoAtual2, retornoEsperado2);
	
	}
	
	@Test( expected = IllegalArgumentException.class)
	public void pesquisaDetalheItemInvalidoTest(){
		Controller controle = new Controller();
		controle.cadastrarUsuario("Maria", "96666-6666", "sem email");
		//Item invalido
		controle.pesquisarDetalhesItem("Maria", "96666-6666", "The Walking Dead");
		
		//Usuario invalido
		controle.pesquisarDetalhesItem("Derci", "50135-6969", "The Walking Dead");
			
	}

}
