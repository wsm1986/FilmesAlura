package repository;

import retrofit2.Callback;

public interface FilmesRepository {

    void buscaFilmes(Callback callback);
}
