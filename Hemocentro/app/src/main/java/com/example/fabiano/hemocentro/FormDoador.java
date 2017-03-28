package com.example.fabiano.hemocentro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.fabiano.hemocentro.meuAdapter.CustomAdapterDoador;
import com.example.fabiano.hemocentro.model.Doador;
import com.example.fabiano.hemocentro.model.Hemocentro;

public class FormDoador extends AppCompatActivity {
    private EditText nome;
    private EditText hospitalDestino;
    private EditText telefone;
    private Spinner tipoSanguineo;
    private EditText qtdBolsas;
    private String genero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_doador);

        nome = (EditText) findViewById(R.id.nome);
        hospitalDestino = (EditText) findViewById(R.id.hospitalDestino);
        telefone = (EditText) findViewById(R.id.telefone);
        tipoSanguineo = (Spinner) findViewById(R.id.spinnerTipoSanguineo);
        qtdBolsas = (EditText) findViewById(R.id.bolsa);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_form, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Doador doador;
        if(item.getItemId() == R.id.save){
            String stringNome = nome.getText().toString();
            String stringTipoSaguineo = tipoSanguineo.getSelectedItem().toString();
            String stringTelefone = telefone.getText().toString();
            String stringHospitalDestino = hospitalDestino.getText().toString();
            int intBolsa = Integer.parseInt(qtdBolsas.getText().toString());



            Hemocentro hemocentro = Hemocentro.getInstance();
            doador = hemocentro.cadastroDoador(stringNome,genero,stringTipoSaguineo,stringTelefone,intBolsa,stringHospitalDestino);
            doador.save();

            Toast.makeText(this,"Cadastrado com sucesso",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
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

}
