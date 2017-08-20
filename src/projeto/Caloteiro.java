package projeto;

public class Caloteiro implements CartaoFidelidade{
	public boolean podeEmprestar() {
		return false;
	}
	
	public int periodoMaximo() {
		return 0;
	}
	
	public String toString() {
		return "Caloteiro";
	}
	
}
