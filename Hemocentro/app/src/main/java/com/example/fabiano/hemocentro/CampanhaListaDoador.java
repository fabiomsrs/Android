package com.example.fabiano.hemocentro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fabiano.hemocentro.meuAdapter.CustomAdapterDoador;
import com.example.fabiano.hemocentro.model.Doador;

import java.util.ArrayList;
import java.util.List;

public class CampanhaListaDoador extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Doador> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campanha_lista_doador);
        lista = new ArrayList<>();
        Intent intent = getIntent();
        String pacote = intent.getStringExtra("tipo sanguineo");
        for(Doador d : Doador.listAll(Doador.class)){
            if(d.getTipoSanguineo().equals(pacote)){
                lista.add(d);
            }
        }

        recyclerView = (RecyclerView) findViewById(R.id.recyclerListaDoador);
        CustomAdapterDoador customAdapterDoador = new CustomAdapterDoador(this,lista);
        recyclerView.setAdapter(customAdapterDoador);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
