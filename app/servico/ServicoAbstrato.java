package app.servico;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import app.dao.DAO;
import app.util.GeradorArquivo;

public abstract class ServicoAbstrato<E> {
    public GeradorArquivo gerador;

    /**
     * Passa o gerador de arquivos para gerar o arquivo do serviço
     * @param gerador GeradorArquivo que pode processar o conteudo do arquivo que será gerado
     */
    public ServicoAbstrato(GeradorArquivo gerador) {
        this.gerador = gerador;
    }

    /**
     * Retornar o DAO do Servico
     * @return DAO do Servico
     */
    public abstract DAO<E> getDao();

    /**
     * Grava uma entidade no Arquivo
     * @param id id da Entidade que será recuperada
     * @param nomeArquivo nome do Arquivo que será gerado
     * @throws IOException levanta Exception do tipo I/O
     */
    public void GravarEntidadeEmArquivo(Object id, String nomeArquivo) throws IOException {
        E entidade = getDao().recuperarPorId(id);

        Map<String, Object> propriedades = new HashMap<String, Object>();
        // gerador.gerarArquivo(nomeArquivo, ((Entidade) entidade).getMapa());
        gerador.gerarArquivo(nomeArquivo, propriedades);
    }

}