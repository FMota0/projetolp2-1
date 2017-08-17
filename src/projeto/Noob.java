package projeto;

public class Noob implements CartaoFidelidade{
	public Noob() {
		
	}
	public boolean podeEmprestar() {
		return true;
	}
	
	public int periodoMaximo() {
		return 7;
	}
	
	public String toString() {
		return "Noob";
	}
	
}
