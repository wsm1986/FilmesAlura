package interactor;

import domain.Filme;
import httpClient.HttpClient;
import presenter.ListaFilmesPresenter;
import repository.FilmesRepository;
import response.ListaFilmesResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmesInteractorImpl implements  FilmesInteractor {

    private FilmesRepository repository;

    public FilmesInteractorImpl(FilmesRepository repository) {
        this.repository = repository;
    }

    @Override
    public void buscarFilmes(Callback<ListaFilmesResponse> callback) {
        repository.buscaFilmes(callback);
    }
}
