package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import projeto.ReputacaoUtil;

public class ReputacaoUtilTest {

	@Test
	public void TestReputacaoAdd1() {
		ReputacaoUtil reput = new ReputacaoUtil();
		assertEquals(reput.periodoMaximo(),5);
		assertEquals(reput.podeEmprestar(),true);
		reput.addReputacao(-20, false);
		assertEquals(reput.periodoMaximo(),0);
		assertEquals(reput.podeEmprestar(),false);
		reput.addReputacao(50, true);
		assertEquals(reput.periodoMaximo(),7);
		assertEquals(reput.podeEmprestar(),true);
		reput.addReputacao(100, true);
		assertEquals(reput.periodoMaximo(),14);
		assertEquals(reput.podeEmprestar(),true);
		reput.addReputacao(100, false);
		assertEquals(reput.periodoMaximo(),5);
		assertEquals(reput.podeEmprestar(),true);
	}
	
}
