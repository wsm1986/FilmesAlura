package domain;

import java.util.ArrayList;
import java.util.List;

import response.FilmeResponse;

public class Filme {

    private String nome;

    private String url_foto;

    public String getNome() {
        return nome;
    }


    public Filme(String nome, String url_foto) {
        this.nome = nome;
        this.url_foto = url_foto;
    }

    public static List<Filme> toDomain(List<FilmeResponse> list) {
        List<Filme> domain = new ArrayList<>();
        for (FilmeResponse response : list) {
            domain.add(new Filme(response.getTituloOriginal(), response.getCaminhoPoster()));
        }
        return domain;
    }

    public String getUrl_foto() {
        return url_foto;
    }
}
