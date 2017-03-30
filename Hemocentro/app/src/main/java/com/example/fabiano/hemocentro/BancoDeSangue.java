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
    int bolsaAPositivo;
    int bolsaANegativo;
    int bolsaBPositivo;
    int bolsaBNegativo;
    int bolsaABPositivo;
    int bolsaABNegativo;
    int bolsaOPositivo;
    int bolsaONegativo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banco_de_sangue);

        bolsaAPositivo = bolsa("A+");
        bolsaANegativo = bolsa("A-");
        bolsaBPositivo = bolsa("B+");
        bolsaBNegativo = bolsa("B-");
        bolsaABPositivo = bolsa("AB+");
        bolsaABNegativo = bolsa("AB-");
        bolsaOPositivo = bolsa("O+");
        bolsaONegativo = bolsa("O-");

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
                qtd++;
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
