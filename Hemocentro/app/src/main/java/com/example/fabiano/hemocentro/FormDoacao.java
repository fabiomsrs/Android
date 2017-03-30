package com.example.fabiano.hemocentro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.fabiano.hemocentro.R;
import com.example.fabiano.hemocentro.model.Bolsa;
import com.example.fabiano.hemocentro.model.Doacao;
import com.example.fabiano.hemocentro.model.Doador;
import com.gildaswise.horizontalcounter.HorizontalCounter;

import java.util.List;

public class FormDoacao extends AppCompatActivity {
    private Doacao doacao;
    private HorizontalCounter horizontalCounter;
    private EditText destino;
    private String doador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_doacao);
        Intent intent = getIntent();
        doador = intent.getStringExtra("doador");
        horizontalCounter = (HorizontalCounter) findViewById(R.id.qtdBolsas);
        destino = (EditText) findViewById(R.id.hospitalDestino);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_form,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        List<Doador> doadores = Doador.listAll(Doador.class);
        Doador aux = null;
        for(Doador d: doadores){
            if(d.getNome().equals(doador)){
                aux = d;
            }
        }
       if(item.getItemId() == R.id.save){
            if(!destino.getText().toString().equals("") && aux != null){
                doacao = new Doacao(destino.getText().toString());
                doacao.setDoador(aux);
            }
            else if(aux!=null){
                doacao = new Doacao();
                doacao.setDoador(aux);
            }


            doacao.save();

            for(int i = 0;i < horizontalCounter.getCurrentValue(); i++){
                Bolsa bolsa = new Bolsa();
                bolsa.setDoacao(doacao);
                bolsa.save();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void onSimClick(View v){
        LinearLayout conditional = (LinearLayout) findViewById(R.id.conditionalField);
        conditional.setVisibility(View.VISIBLE);
    }
    public void onNaoClick(View v){
        LinearLayout conditional = (LinearLayout) findViewById(R.id.conditionalField);
        conditional.setVisibility(View.GONE);
    }
}
