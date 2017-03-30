package com.example.fabiano.hemocentro;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import com.example.fabiano.hemocentro.meuAdapter.CustomAdapterDoador;
import com.example.fabiano.hemocentro.model.Bolsa;
import com.example.fabiano.hemocentro.model.Doador;

public class HemocentroActivity extends AppCompatActivity {
    private FloatingActionButton button;
    private List<Doador> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hemocentro);
        button = (FloatingActionButton) findViewById(R.id.floatbutton);
        lista = Doador.listAll(Doador.class);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        CustomAdapterDoador adapter = new CustomAdapterDoador(this,lista);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.tool_bar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.bancoDeSangue){
            Intent intent = new Intent(this,BancoDeSangue.class);
            startActivity(intent);
        }
        else if(item.getItemId() == R.id.rank){
            Intent intent = new Intent(this,Rank.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public void floatButtonListener(View view){
        Intent intent = new Intent(this,FormDoador.class);
        List<Bolsa> test = Bolsa.listAll(Bolsa.class);

        startActivity(intent);
    }



}
