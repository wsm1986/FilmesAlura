package com.estudos.filmesactivity.ui.lista;

import android.content.Intent;
import android.os.Bundle;

import com.estudos.filmesactivity.R;
import com.estudos.filmesactivity.ui.detalhe.DetalheActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import domain.Filme;

import interactor.FilmesInteractorImpl;
import presenter.ListaFilmesPresenter;
import presenter.ListaFilmesPresenterImpl;
import presenter.ListaFilmesView;
import repository.FilmesRepositoryImpl;
import response.FilmeResponse;


public class MainActivity extends AppCompatActivity implements ListaFilmesView , ListaFilmesAdapter.ItemClickListenerFilme{

    private RecyclerView recyclerView;

    private ListaFilmesAdapter listaFilmesAdapter;

    private ListaFilmesPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Melhores Filmes");
        createToolbar();
        configurarAdapter();

        presenter = new ListaFilmesPresenterImpl(new FilmesInteractorImpl(new FilmesRepositoryImpl()));
        presenter.setView(this);
        presenter.mostraFilme();


    }


    @Override
    public void mostraFilme(List<Filme> filmes) {

        listaFilmesAdapter.initAdapter(filmes);
    }

    public void mostraErro() {
        Toast.makeText(this, "Erro Generico", Toast.LENGTH_LONG).show();
    }

    private void createToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private List<FilmeResponse> createList() {
        List<FilmeResponse> filmes = Arrays.asList(new FilmeResponse("Filme 1", "Well"));
        return filmes;
    }

    public void configurarAdapter() {
        recyclerView = findViewById(R.id.recyclerView_lista_filme);
        listaFilmesAdapter = new ListaFilmesAdapter(this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(listaFilmesAdapter);
    }


    @Override
    public void onClickDetalheFilme(Filme filme) {
        Intent intent = new Intent(MainActivity.this, DetalheActivity.class);
        startActivity(intent);

    }
}
