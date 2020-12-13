package httpClient;

import response.ListaFilmesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmesService {

    @GET("movie/popular")
    Call<ListaFilmesResponse> buscarFilmesPopulares(@Query("api_key") String chaveapi);
}
