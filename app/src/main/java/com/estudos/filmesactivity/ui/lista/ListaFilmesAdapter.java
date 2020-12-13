package com.estudos.filmesactivity.ui.lista;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.estudos.filmesactivity.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import domain.Filme;

public class ListaFilmesAdapter extends RecyclerView.Adapter<ListaFilmesAdapter.ListaFilmesViewHolder> {


    private List<Filme> listaFilmes;

    private static ItemClickListenerFilme onClickFilme;

    public ListaFilmesAdapter(ItemClickListenerFilme onClickFilme)
    {
        this.onClickFilme = onClickFilme;
        this.listaFilmes = new ArrayList<>();
    }

    @NonNull
    @Override
    public ListaFilmesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filme, parent, false);
        return new ListaFilmesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaFilmesViewHolder holder, int position) {
        holder.bind(listaFilmes.get(position));

    }

    @Override
    public int getItemCount() {
        return listaFilmes != null && listaFilmes.size() > 0 ? listaFilmes.size() : 0;
    }

    public static class ListaFilmesViewHolder extends RecyclerView.ViewHolder {

        TextView tituloFilme;
        ImageView img_filme;
        Filme filme;
        public ListaFilmesViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloFilme = itemView.findViewById(R.id.textTituloFilme);
            img_filme = itemView.findViewById(R.id.img_poster_filme);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onClickFilme != null){
                        onClickFilme.onClickDetalheFilme(filme);
                    }
                }
            });
        }
        public void bind(Filme filme){
            this.filme = filme;
            tituloFilme.setText(filme.getNome());
            Picasso.get().load("https://image.tmdb.org/t/p/w500/"+filme.getUrl_foto()).into(img_filme);
        }
    }

    public void initAdapter(List<Filme> listaFilmes) {
        this.listaFilmes = listaFilmes;
        notifyDataSetChanged();
    }

    public interface  ItemClickListenerFilme{
        void onClickDetalheFilme(Filme filme);
    }
}
