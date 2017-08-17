package projeto;

public class FreeRyder implements CartaoFidelidade{
	public boolean podeEmprestar() {
		return true;
	}
	
	public int periodoMaximo() {
		return 5;
	}
	public String toString() {
		return "FreeRyder";
	}
	
}
