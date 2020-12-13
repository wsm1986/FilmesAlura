package presenter;

import android.util.Log;

import java.util.List;
import java.util.logging.Logger;

import domain.Filme;
import httpClient.HttpClient;
import interactor.FilmesInteractor;
import interactor.FilmesInteractorImpl;
import repository.FilmesRepositoryImpl;
import response.ListaFilmesResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesPresenterImpl implements ListaFilmesPresenter {

    private ListaFilmesView view;

    private FilmesInteractor interactor;


    @Override
    public void setView(ListaFilmesView view) {
        this.view = view;
    }

    public ListaFilmesPresenterImpl(FilmesInteractor interactor) {
        this.interactor = interactor;
    }


    @Override
    public void mostraFilme() {
        this.interactor.buscarFilmes(new Callback<ListaFilmesResponse>() {
            @Override
            public void onResponse(Call<ListaFilmesResponse> call, Response<ListaFilmesResponse> response) {
                view.mostraFilme(Filme.toDomain(response.body().getResults()));
            }

            @Override
            public void onFailure(Call<ListaFilmesResponse> call, Throwable t) {
                view.mostraErro();
            }
        });
    }
}
