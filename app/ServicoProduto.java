package app;

public class ServicoProduto extends ServicoAbstrato<Produto>{
    public ServicoProduto(GeradorArquivo gerador) {
        super(gerador);
    }

    private DAO<Produto> dao;

    @Override
    public DAO<Produto> getDao() {
        if (dao == null){
            dao = new ProdutoDAO();
        }
        return dao;
    }

    /**
     * Dado um produtoId recupera seu nome
     * @param produtoId id do produto
     * @return nome do referido produto
     */
    public String getNameProduto(Object produtoId){
        Produto p = this.getDao().recuperarPorId(produtoId);        
        return p.getName();
    }

    /**
     * Dado o id do produto recupera o produto
     * @param produtoId id do produto
     * @return produto
     */
    public Produto getProduto(Object produtoId){
        Produto p = this.getDao().recuperarPorId(produtoId);
        return p;
    }

    /**
     * Salva um produto no DAO
     * @param entidade
     */
    public void saveProduto(Produto entidade){
        this.dao.salvar(entidade);
    }

	public void showProdutos() {
        this.dao.showAll();
	}

}