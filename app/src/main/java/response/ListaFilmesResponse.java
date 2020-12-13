package response;

import com.squareup.moshi.Json;

import java.util.List;

public class ListaFilmesResponse {

    @Json(name = "results")
    private final List<FilmeResponse> results;

    public ListaFilmesResponse(List<FilmeResponse> results) {
        this.results = results;
    }
    public List<FilmeResponse> getResults() {
        return results;
    }

}
