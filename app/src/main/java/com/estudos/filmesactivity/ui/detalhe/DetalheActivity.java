package com.estudos.filmesactivity.ui.detalhe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.estudos.filmesactivity.R;

public class DetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);
        TextView nomeFilme = findViewById(R.id.text_detalhe_filme);
        nomeFilme.setText("WELLLL");
    }
}
