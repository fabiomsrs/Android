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

import com.example.fabiano.hemocentro.model.Bolsa;
import com.example.fabiano.hemocentro.model.Doacao;
import com.example.fabiano.hemocentro.model.Doador;
import com.example.fabiano.hemocentro.model.Hemocentro;

import java.util.List;

public class FormDoador extends AppCompatActivity {
    private EditText nome;
    private EditText telefone;
    private Spinner tipoSanguineo;
    private String genero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_doador);

        nome = (EditText) findViewById(R.id.nome);
        telefone = (EditText) findViewById(R.id.telefone);
        tipoSanguineo = (Spinner) findViewById(R.id.spinnerTipoSanguineo);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_form, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        List<Doador> doadores = Doador.listAll(Doador.class);
        boolean aux = true;
        if(item.getItemId() == R.id.save){
            String stringNome = nome.getText().toString();
            String stringTipoSaguineo = tipoSanguineo.getSelectedItem().toString();
            String stringTelefone = telefone.getText().toString();
            if(stringNome.isEmpty()){
                Toast.makeText(this,"Preencha os campos Vazio",Toast.LENGTH_LONG).show();
            }
            else {


                Doador doador = new Doador(stringNome, genero, stringTipoSaguineo, stringTelefone);
                for (Doador d : doadores) {
                    if (d.getNome().equals(doador.getNome()) && d.getTipoSanguineo().equals(doador.getTipoSanguineo())) {
                        aux = false;
                    }
                }

                if (aux) {
                    doador.save();
                    Toast.makeText(this, "Cadastrado com sucesso", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(this, "Doador ja cadastrado", Toast.LENGTH_LONG).show();

            }

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

}
