package presenter;

import com.estudos.filmesactivity.ui.lista.MainActivity;

import java.util.List;

import domain.Filme;

public interface ListaFilmesPresenter {

    void mostraFilme();

    void setView(ListaFilmesView view);
}
