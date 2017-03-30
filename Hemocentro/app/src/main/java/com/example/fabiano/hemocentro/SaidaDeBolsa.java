package com.example.fabiano.hemocentro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fabiano.hemocentro.model.Bolsa;
import com.example.fabiano.hemocentro.model.SaidaDeBolsas;

import java.util.List;

public class SaidaDeBolsa extends AppCompatActivity {
    private TextView numeroSeekBar;
    private SeekBar seekBar;
    private Spinner tipoSangue;
    private SaidaDeBolsas saidaDeBolsas;
    private int qtdBolsasJaLiberadas;
    private int qtdMax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saida_de_bolsa);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        tipoSangue = (Spinner) findViewById(R.id.tipoSaguineo);
        numeroSeekBar = (TextView) findViewById(R.id.numeroSeekBar);
        numeroSeekBar.setText("0");


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int aux = (qtdMax*progress)/100;
                numeroSeekBar.setText(""+aux);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                qtdMax = bolsa(tipoSangue.getSelectedItem().toString()) - getQtdBolsasJaLiberadas(tipoSangue.getSelectedItem().toString());
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int integerNumeroSeekBar = Integer.parseInt(numeroSeekBar.getText().toString());
                saidaDeBolsas = new SaidaDeBolsas();
                saidaDeBolsas.setTipoSanguinero(tipoSangue.getSelectedItem().toString());
                saidaDeBolsas.setQtdSaida(integerNumeroSeekBar);
            }
        });
    }

    public void onConfirmClick(View v){
        if(saidaDeBolsas == null)
            finish();
        else{
            saidaDeBolsas.save();
            Toast.makeText(this,"Operação feita",Toast.LENGTH_SHORT).show();
        }

    }

    public int bolsa(String tipo){
        List<Bolsa> bolsa = Bolsa.listAll(Bolsa.class);
        int qtd = 0;

        for(Bolsa b: bolsa){
            if(b.getTipoSanguineo().equals(tipo))
                qtd++;
        }


        return qtd;
    }

    public int getQtdBolsasJaLiberadas(String tipo){
        List<SaidaDeBolsas> saida = SaidaDeBolsas.listAll(SaidaDeBolsas.class);
        int qtd = 0;
        for(SaidaDeBolsas aux : saida){
            if(aux.getTipoSanguineo().equals(tipo)){
                qtd+= aux.getQtdSaida();
            }
        }
        return qtd;
    }
}
