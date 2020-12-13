package interactor;

import response.ListaFilmesResponse;
import retrofit2.Callback;

public interface FilmesInteractor {

    void buscarFilmes(Callback<ListaFilmesResponse> callback);
}
