package app.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Implemantação do DAO<Produto>
 */
public class ProdutoDAO implements DAO<Produto> {
    Map<String, Object> mapaProdutos = new HashMap<String, Object>();

    @Override
    public Produto recuperarPorId(Object id) {
        return (Produto) mapaProdutos.get(id);
    }

    @Override
    public void salvar(Produto entidade) {
        mapaProdutos.put(entidade.getId(), entidade);
    }

    @Override
    public void excluir(Object id) {
        mapaProdutos.remove(id);

    }

    @Override
    public List<Produto> listarTodos() {
        List<Produto> listaProdutos = new LinkedList<Produto>();
        
        for (Object object : mapaProdutos.values()){
            listaProdutos.add((Produto)object);
        }

        return listaProdutos;
    }
    
    public void showAll(){
        Collection<Object> meusProdutos = mapaProdutos.values();
    
        for (Object object : meusProdutos) {
            String id = ((Produto)object).getId(); 
            String nome = ((Produto)object).getName();
          System.out.println("Id: " + id +  " Nome: " + nome);
        }         
    }
}