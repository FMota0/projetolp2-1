
package projeto;

public class Facade {
	private Controller controlador;

	public Facade() {
		this.controlador = new Controller();
	}

	public void iniciarSistema() {
		
	}
	/**
	 * Cadastrar usuario no sistema
	 * 
	 * @param nome
	 *            Nome
	 * @param telefone
	 *            Telefone
	 * @param email
	 *            email
	 */
	public void cadastrarUsuario(String nome, String telefone, String email) {
		this.controlador.cadastrarUsuario(nome, telefone, email);
	}
	/**
	 * Retorna informacao de um atributo especifico do usuario
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 * @param atributo
	 *            Atributo requerido
	 * @return informacoes do atributo requerido
	 */
	public String getInfoUsuario(String nome, String telefone, String atributo) {
		return this.controlador.getInfoUsuario(nome, telefone, atributo);
	}
	/**
	 * Remover usuario do sistema
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 */
	public void removerUsuario(String nome, String telefone) {
		this.controlador.removerUsuario(nome, telefone);
	}
	/**
	 * Atualizar atributo especifico de um usuario
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 * @param atributo
	 *            Atributo desejado para mudanca
	 * @param valor
	 *            Nova informacao para substituicao do atributo
	 */
	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		this.controlador.atualizarUsuario(nome, telefone, atributo, valor);
	}
	/**
	 * Cadastrar jogo eletronico como item de um usuario
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 * @param nomeItem
	 *            Nome do item
	 * @param preco
	 *            Preco de venda do item
	 * @param plataforma
	 *            Plataforma de leitura do item
	 */
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		this.controlador.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
	}
	/**
	 * Retorna informacao de atributo especifico do item de um usuario
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 * @param nomeItem
	 *            Nome do item
	 * @param atributo
	 *            Atributo
	 * @return informacoes do atributo
	 */
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		return this.controlador.getInfoItem(nome, telefone, nomeItem, atributo);

	}
	/**
	 * Cadastrar jogo de tabuleiro como item de um usuario
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 * @param nomeItem
	 *            Nome do item
	 * @param preco
	 *            Preco de venda do item
	 * 
	 **/
	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		this.controlador.cadastrarTabuleiro(nome, telefone, nomeItem, preco);
	}
	/**
	 * Adiciona peca perdida na lista de pecas perdidas do jogo de tabuleiro
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 * @param nomeItem
	 *            Nome do item
	 * @param nomePeca
	 *            Nome da peca perdida
	 */
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		this.controlador.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
	}
	/**
	 * Cadatrar BluRay de Filme como item de um usuario
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 * @param nomeItem
	 *            Nome do item
	 * @param preco
	 *            Preco de venda do item
	 * @param duracao
	 *            Duracao em minutos do filme
	 * @param genero
	 *            Genero do filme
	 * @param classificacao
	 *            Classificacao indicativa do filme
	 * @param anoLancamento
	 *            Ano de lancamento do filme
	 */
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		this.controlador.cadastrarBluRayFilme(nome, telefone, nomeItem, preco, duracao, classificacao, genero,
				anoLancamento);
	}
	/**
	 * Cadatrar BluRay de Show como item de um usuario
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 * @param nomeItem
	 *            Nome do item
	 * @param preco
	 *            Preco de venda do item
	 * @param duracao
	 *            Duracao em minutos do show
	 * @param numeroFaixas
	 *            Numero de faixas do show
	 * @param artista
	 *            Artista do show
	 * @param classificacao
	 *            Classificacao indicativa do show
	 */
	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) {
		this.controlador.cadastrarBluRayShow(nome, telefone, nomeItem, preco, duracao, classificacao,
				numeroFaixas, artista);
	}
	/**
	 * Cadatrar BluRay de Serie como item de um usuario
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 * @param nomeItem
	 *            Nome do item
	 * @param preco
	 *            Preco de venda do item
	 * @param descricao
	 *            Descricao da serie
	 * @param duracao
	 *            Duracao em minutos do serie
	 * @param classificacao
	 *            Classificacao indicativa da serie
	 * @param genero
	 *            Genero da serie
	 * @param temporada
	 *            Temporada do bluray da serie
	 */
	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		this.controlador.cadastrarBluRaySerie(nome, telefone, nomeItem, preco, duracao, classificacao, genero,
				temporada);
	}
	/**
	 * Adiciona um BluRay de uma temporada em uma serie
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 * @param nomeBlurayTemporada
	 *            Nome do BluRay
	 * @param duracao
	 *            Duracao em minutos do BluRay
	 */
	public void adicionarBluRay(String nome, String telefone, String nomeBlurayTemporada, int duracao){
		
	}
	/**
	 * Remove item de um usuario
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 * @param nomeItem
	 *            Nome do item
	 */
	public void removerItem(String nome, String telefone, String nomeItem) {
		this.controlador.removerItem(nome, telefone, nomeItem);
	}
	/**
	 * Atualiza atributo de um item
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 * @param nomeItem
	 *            Nome do item
	 * @param atributo
	 *            Atributo que sera modificado
	 * @param valor
	 *            Nova informacao para o atributo
	 */
	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		this.controlador.atualizarItem(nome, telefone, nomeItem, atributo, valor);
	}
	/**
	 * Retorna lista de todos os itens cadastrados em ordem lexicografica
	 * 
	 * @return lista ordenada de todos os itens
	 */
	public String listarItensOrdenadosPorNome(){
		return this.controlador.listarItensOrdenadosPorNome();
	}
	/**
	 * Retorna lista de todos os itens cadastrados em ordem, por preco
	 * 
	 * @return lista ordenada de todos os itens
	 */
	public String listarItensOrdenadosPorValor() {
		return this.controlador.listarItensOrdenadosPorValor();
	}
	/**
	 * Registra emprestimo de item no sistema
	 * 
	 * @param nomeDono
	 *            Nome do usuario dono do item
	 * @param telefoneDono
	 *            Telefone do usuario dono do item
	 * @param nomeRequerente
	 *            Nome do usuario requerente do item
	 * @param telefoneRequerente
	 *            Telefone do usuario requerente do item
	 * @param nomeItem
	 *            Nome do item
	 * @param dataEmprestimo
	 *            Data da realizacao do emprestimo
	 * @param periodo
	 *            Duracao em dias do emprestimo
	 */
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, String nomeItem, 
			String dataEmprestimo, int periodo){
		this.controlador.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, periodo);
	}
	/**
	 * Retorna informacoes de um item
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 * @param nomeItem
	 *            Nome do item
	 * @return representacao textual das informacoes do item desejado
	 */
	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem){
		return this.controlador.pesquisarDetalhesItem(nome, telefone, nomeItem);
	}
	/**
	 * Registra devolucao de item
	 * 
	 * @param nomeDono
	 *            Nome do usuario dono do item
	 * @param telefoneDono
	 *            Telefone do usuario dono do item
	 * @param nomeRequerente
	 *            Nome do usuario requerente do item
	 * @param telefoneRequerente
	 *            Telefone do usuario requerente do item
	 * @param nomeItem
	 *            Nome do item
	 * @param dataEmprestimo
	 *            Data da realizacao do emprestimo
	 * @param dataDevolucao
	 *            Data da devolucao do item
	 */
	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, String nomeItem, 
			String dataEmprestimo, String dataDevolucao){
		this.controlador.devolverItem(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem, dataEmprestimo, dataDevolucao);
	}
	/**
	 * Retorna historico de emprestimos de itens do usario que foram emprestados
	 * 
	 * @param nomeDono
	 *            Nome do usuario
	 * @param telefoneDono
	 *            Telefone do usuario
	 * @return lista do historico de emprestimos do usuario
	 */
	public String listarEmprestimosUsuarioEmprestando(String nomeDono, String telefoneDono){
		
		return this.controlador.listarEmprestimosUsuarioEmprestando(nomeDono, telefoneDono);
	}
	/**
	 * Retorna historico de emprestimos de itens que o usuario pegou emprestado
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 * @return lista do historico de emprestimos do usuario
	 */
	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone){
		return this.controlador.listarEmprestimosUsuarioPegandoEmprestado(nome, telefone);
	}
	/**
	 * Retorna historico dos emprestimos de um item
	 * 
	 * @param nomeItem
	 *            Nome do item
	 * @return lista dos emprestimos do item
	 */
	public String listarEmprestimosItem(String nomeItem) {
		return this.controlador.listarEmprestimosItem(nomeItem);
	}
	/**
	 * Recupera a lista de todos os itens que nao estao emprestados no momento
	 * 
	 * @return lista de itens nao emprestados
	 */
	public String listarItensNaoEmprestados() {
		return this.controlador.listarItensNaoEmprestados();
	}
	
	public String listarItensEmprestados(){
		return this.controlador.listarItensEmprestados();
	}
	
	public String listarTop10Itens(){
		return this.controlador.listarTop10Itens();
	}
	/**
	 * Encerra o sistema
	 */
	public void fecharSistema() {

	}
	
	public String listarCaloteiros() {
		return this.controlador.listarCaloteiros();
	}
	
	public String listarTop10MelhoresUsuarios() {
		return this.controlador.listarTop10MelhoresUsuarios();
	}
	public String listarTop10PioresUsuarios() {
		return this.controlador.listarTop10PioresUsuarios();
	}
	
	
	
}