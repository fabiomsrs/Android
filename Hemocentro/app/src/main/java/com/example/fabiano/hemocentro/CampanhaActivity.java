package com.example.fabiano.hemocentro;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.fabiano.hemocentro.meuAdapter.CustomAdapterCampanha;
import com.example.fabiano.hemocentro.model.Campanha;

import java.util.List;

public class CampanhaActivity extends AppCompatActivity {
    private List<Campanha> lista;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campanha);

        lista = Campanha.listAll(Campanha.class);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerCampanha);
        CustomAdapterCampanha customAdapterCampanha = new CustomAdapterCampanha(this,lista);
        recyclerView.setAdapter(customAdapterCampanha);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void floatButtonListener(View v){
        Intent intent = new Intent(this,FormCampanha.class);
        startActivity(intent);
    }

}
