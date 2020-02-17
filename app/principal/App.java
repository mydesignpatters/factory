package app.principal;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import app.dao.Produto;
import app.servico.ServicoProduto;
import app.util.GeradorXML;

public class App {
    public static void main(String[] args) {
        System.out.println("Teste do Design Pattern Factory");
        System.out.println("Usando o Factory para construir um servico de produtos");

        final GeradorXML meuGeradorXML = new GeradorXML();
        final Map<String, Object> propriedades = new HashMap<String, Object>();

        propriedades.put("porta", "8080");
        propriedades.put("banco", "mysql");
        propriedades.put("servidor", "tomcat");
        
        try {
            String nomeArquivo = "meuArquivoDePropriedadesNormal.xml";
            meuGeradorXML.gerarArquivo(nomeArquivo, propriedades);
            System.out.println("Arquivo " + nomeArquivo + "gerado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        ServicoProduto meuGerenciadorDeProdutos = new ServicoProduto(meuGeradorXML);

        //Cria o Gerenciandor de Produdos
        meuGerenciadorDeProdutos.getDao();

        //Cria os produtos de exemplo
        Produto entidade1 = new Produto();
        entidade1.setId("Cod1");
        entidade1.setName("Produto 1 de Teste do Armando");
        Produto entidade2 = new Produto();
        entidade2.setId("Cod2");
        entidade2.setName("Produto 2 de Teste do Armando");

        //Salva os produtos de exemplo
        meuGerenciadorDeProdutos.saveProduto(entidade1);
        meuGerenciadorDeProdutos.saveProduto(entidade2);

        //Recupera os dados do produto 2
        System.out.println("Dados do produto 2: ");
        Produto pTeste = meuGerenciadorDeProdutos.getProduto("Cod2");
        System.out.println("Produto 2: " + pTeste.getId() + " - " + pTeste.getName());
        System.out.println("");

        meuGerenciadorDeProdutos.showProdutos();
    }
}