package br.com.cidandrade.album.modelo.dao.interfaces;

import br.com.cidandrade.album.modelo.bd.AlbumBD;
import br.com.cidandrade.album.modelo.entidade.Figurinha;
import java.util.List;

public interface FigurinhaService {
    

    public abstract void inserir(Figurinha figurinha);
    public abstract void alterar(Figurinha figurinha);
    public abstract void remover(Figurinha figurinha);
    public abstract List<Figurinha> selecionar(String sql);
    public abstract int qtdPaginas();
    public abstract List<Figurinha> selecionarTodos();
    public abstract List<Figurinha> selecionarPorPagina(int pagina);
    
}
