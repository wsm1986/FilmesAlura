package repository;

import domain.Filme;
import httpClient.HttpClient;
import response.ListaFilmesResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmesRepositoryImpl implements FilmesRepository {
    @Override
    public void buscaFilmes( Callback callback) {
        HttpClient.getInstancia().buscarFilmesPopulares("e77e8c449d46e829c599b3d9c53e130a")
                .enqueue(callback);
    }
}
