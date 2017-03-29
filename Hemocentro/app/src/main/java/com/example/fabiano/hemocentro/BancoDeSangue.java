package com.example.fabiano.hemocentro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.fabiano.hemocentro.model.Bolsa;
import com.example.fabiano.hemocentro.model.SaidaDeBolsas;

import java.util.List;

public class BancoDeSangue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banco_de_sangue);

        int bolsaAPositivo = bolsa("A+");
        int bolsaANegativo = bolsa("A-");
        int bolsaBPositivo = bolsa("B+");
        int bolsaBNegativo = bolsa("B-");
        int bolsaABPositivo = bolsa("AB+");
        int bolsaABNegativo = bolsa("AB-");
        int bolsaOPositivo = bolsa("O+");
        int bolsaONegativo = bolsa("O-");

        TextView textAPositivo = (TextView) findViewById(R.id.aPositivo);
        textAPositivo.setText("Quantidade: " + bolsaAPositivo);

        TextView textANegativo = (TextView) findViewById(R.id.aNegativo);
        textANegativo.setText("Quantidade: " + bolsaANegativo);

        TextView textBPositivo = (TextView) findViewById(R.id.bPositivo);
        textBPositivo.setText("Quantidade: " + bolsaBPositivo);

        TextView textBNegativo = (TextView) findViewById(R.id.bNegativo);
        textBNegativo.setText("Quantidade: " + bolsaBNegativo);

        TextView textABPositivo = (TextView) findViewById(R.id.aBPositivo);
        textABPositivo.setText("Quantidade: " + bolsaABPositivo);

        TextView textABNegativo = (TextView) findViewById(R.id.aBNegativo);
        textABNegativo.setText("Quantidade: " + bolsaABNegativo);

        TextView textOPositivo = (TextView) findViewById(R.id.oPositivo);
        textOPositivo.setText("Quantidade: " + bolsaOPositivo);

        TextView textONegativo = (TextView) findViewById(R.id.oNegativo);
        textONegativo.setText("Quantidade: " + bolsaONegativo);
    }

    public int bolsa(String tipo){
        List<Bolsa> bolsa = Bolsa.listAll(Bolsa.class);
        List<SaidaDeBolsas> saidaDeBolsas = SaidaDeBolsas.listAll(SaidaDeBolsas.class);
        int qtd = 0;

        for(Bolsa b: bolsa){
            if(b.getTipoSanguineo().equals(tipo))
                qtd+=b.getQtdBolsa();
        }

        for(SaidaDeBolsas aux : saidaDeBolsas){
            if(aux.getTipoSanguineo().equals(tipo))
                qtd-=aux.getQtdSaida();
        }


        return qtd;
    }

    public void floatButtonListener(View v){
        Intent intent = new Intent(this,SaidaDeBolsa.class);
        startActivity(intent);
    }
}
