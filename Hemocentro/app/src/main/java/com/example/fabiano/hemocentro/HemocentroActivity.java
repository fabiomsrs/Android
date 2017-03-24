package com.example.fabiano.hemocentro;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import meuAdapter.CustomAdapter;
import model.Doador;

public class HemocentroActivity extends AppCompatActivity {
    private FloatingActionButton button;
    private List<Doador> lista = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hemocentro);
        button = (FloatingActionButton) findViewById(R.id.floatbutton);

        Doador doador = new Doador("test","test","test","test");

        lista.add(doador);
        lista.add(doador);
        lista.add(doador);
        lista.add(doador);
        lista.add(doador);
        lista.add(doador);
        lista.add(doador);
        lista.add(doador);
        lista.add(doador);
        lista.add(doador);
        lista.add(doador);
        lista.add(doador);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        CustomAdapter adapter = new CustomAdapter(lista);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.tool_bar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void floatButtonListener(View view){
        Intent intent = new Intent(this,FormDoador.class);
        startActivity(intent);
    }



}
