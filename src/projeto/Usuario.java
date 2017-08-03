package projeto;

import java.util.HashMap;

public class Usuario {
	private String nome;
	private String telefone;
	private String email;
	private ItemController itemcontroller;
	
	private void valideNome(String nome){
		
		if(nome == null || nome.trim().equals(""))
			throw new IllegalArgumentException("Nome de usuario invalido");
		
	}

	private void valideTelefone(String telefone){
		
		if(telefone == null || telefone.trim().equals(""))
			throw new IllegalArgumentException("Telefone de usuario invalido");
	
	}
	
	private void valideEmail(String email){
	
		if(email == null || email.trim().equals(""))
			throw new IllegalArgumentException("Email de usuario invalido");
	
	}
	
	public Usuario(String nome, String telefone, String email) {
	
		this.valideNome(nome);
		this.valideTelefone(telefone);
		this.valideEmail(email);
		
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.itemcontroller = new ItemController();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.valideNome(nome);
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.valideTelefone(telefone);
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.valideEmail(email);
		this.email = email;
	}

	@Override
	public String toString() {
		return nome + ", " + email + ", " + telefone;
	}

}
