package com.example.fabiano.hemocentro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import model.Doador;

public class FormDoador extends AppCompatActivity {
    private EditText nome;
    private EditText hospitalDestino;
    private EditText telefone;
    private Spinner tipoSanguineo;
    private String genero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_doador);
        nome = (EditText) findViewById(R.id.nome);
        hospitalDestino = (EditText) findViewById(R.id.hospitalDestino);
        telefone = (EditText) findViewById(R.id.telefone);
        tipoSanguineo = (Spinner) findViewById(R.id.spinnerTipoSanguineo);
    }
    public void setGenero(View v){
        if(v.getId() == R.id.radioFeminino){
            this.genero = "Feminino";
        }
        else{
            this.genero = "Masculino";
        }
    }

    public void onSimClick(View v){
        LinearLayout conditional = (LinearLayout) findViewById(R.id.conditionalField);
        conditional.setVisibility(View.VISIBLE);
    }
    public void onNaoClick(View v){
        LinearLayout conditional = (LinearLayout) findViewById(R.id.conditionalField);
        conditional.setVisibility(View.GONE);
    }

    public void onOkclick(View v){
        String stringNome = nome.getText().toString();
        String stringTipoSaguineo = tipoSanguineo.getSelectedItem().toString();
        String stringTelefone = telefone.getText().toString();
        String stringHospitalDestino = hospitalDestino.getText().toString();
        Doador doador = new Doador(stringNome,genero,stringTipoSaguineo,stringTelefone);

        if(!stringHospitalDestino.equals("")){
            doador.setDoacao(10,stringHospitalDestino);
        }
            
    }
}
