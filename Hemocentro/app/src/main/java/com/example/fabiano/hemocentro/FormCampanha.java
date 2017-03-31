package com.example.fabiano.hemocentro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.fabiano.hemocentro.model.Campanha;

public class FormCampanha extends AppCompatActivity {
    EditText nomeCampanha;
    Spinner tipoSanguineo;
    Campanha campanha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_campanha);

        nomeCampanha = (EditText) findViewById(R.id.editCampanha);
        tipoSanguineo = (Spinner) findViewById(R.id.spinnerCampanhaTipoSanguineo);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_form,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.save){
            campanha = new Campanha();
            campanha.setNome(nomeCampanha.getText().toString());
            campanha.setTipoSanguineo(tipoSanguineo.getSelectedItem().toString());
            campanha.save();
            Toast.makeText(this,"Cadastrado com sucesso",Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

}
