package projeto;

public class BomAmigo implements CartaoFidelidade{
	public boolean podeEmprestar() {
		return true;
	}
	
	public int periodoMaximo() {
		return 14;
	}
	
	public String toString() {
		return "BomAmigo";
	}

}
