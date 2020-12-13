package presenter;

import java.util.List;

import domain.Filme;

public interface ListaFilmesView {
    void mostraFilme(List<Filme> filmes);
    void mostraErro();
}
