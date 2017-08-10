
package projeto;

public class Facade {
	private Controller controladorDeUsuarios;

	public Facade() {
		this.controladorDeUsuarios = new Controller();
	}

	public void iniciarSistema() {
		
	}

	public void cadastrarUsuario(String nome, String telefone, String email) {
		this.controladorDeUsuarios.cadastrarUsuario(nome, telefone, email);
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		return this.controladorDeUsuarios.getInfoUsuario(nome, telefone, atributo);
	}

	public void removerUsuario(String nome, String telefone) {
		this.controladorDeUsuarios.removerUsuario(nome, telefone);
	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		this.controladorDeUsuarios.atualizarUsuario(nome, telefone, atributo, valor);
	}

	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		this.controladorDeUsuarios.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		return this.controladorDeUsuarios.getInfoItem(nome, telefone, nomeItem, atributo);

	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		this.controladorDeUsuarios.cadastrarTabuleiro(nome, telefone, nomeItem, preco);
	}

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		this.controladorDeUsuarios.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
	}

	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		this.controladorDeUsuarios.cadastrarBluRayFilme(nome, telefone, nomeItem, preco, duracao, classificacao, genero,
				anoLancamento);
	}

	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) {
		this.controladorDeUsuarios.cadastrarBluRayShow(nome, telefone, nomeItem, preco, duracao, classificacao,
				numeroFaixas, artista);
	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		this.controladorDeUsuarios.cadastrarBluRaySerie(nome, telefone, nomeItem, preco, duracao, classificacao, genero,
				temporada);
	}
	
	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao){
		
	}

	public void removerItem(String nome, String telefone, String nomeItem) {
		this.controladorDeUsuarios.removerItem(nome, telefone, nomeItem);
	}

	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		this.controladorDeUsuarios.atualizarItem(nome, telefone, nomeItem, atributo, valor);
	}
	
	public String listarItensOrdenadosPorNome(){
		return this.controladorDeUsuarios.listarItensOrdenadosPorNome();
	}
	
	public String listarItensOrdenadosPorValor() {
		return this.controladorDeUsuarios.listarItensOrdenadosPorValor();
	}

	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, String nomeItem, 
			String dataEmprestimo, int periodo){
		this.controladorDeUsuarios.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, periodo);
	}
	
	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem){
		return this.controladorDeUsuarios.pesquisarDetalhesItem(nome, telefone, nomeItem);
	}
	
	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, String nomeItem, 
			String dataEmprestimo, String dataDevolucao){
		this.controladorDeUsuarios.devolverItem(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, dataDevolucao);
	}
	
	public String listarEmprestimosUsuarioEmprestando(String nomeDono, String telefoneDono){
		
		return this.controladorDeUsuarios.listarEmprestimosUsuarioEmprestando(nomeDono, telefoneDono);
	}

	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone){
		return this.controladorDeUsuarios.listarEmprestimosUsuarioPegandoEmprestado(nome, telefone);
	}
	
	public String listarEmprestimosItem(String nomeItem) {
		return this.controladorDeUsuarios.listarEmprestimosItem(nomeItem);
	}
	
	public String listarItensNaoEmprestados() {
		return this.controladorDeUsuarios.listarItensNaoEmprestados();
	}
	
	public String listarItensEmprestados(){
		return this.controladorDeUsuarios.listarItensEmprestados();
	}
	
	public String listarTop10Itens(){
		return this.controladorDeUsuarios.listarTop10Itens();
	}
	
	public void fecharSistema() {

	}
	
	
	
}