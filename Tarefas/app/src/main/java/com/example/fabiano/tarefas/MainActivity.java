package com.example.fabiano.tarefas;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import model.Tarefa;

public class MainActivity extends AppCompatActivity {
    private List arrayTarefa = new ArrayList<Tarefa>();
    private ListView lista;
    private int REQUEST_CODE;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = (ListView) findViewById(R.id.lista);
        button = (Button) findViewById(R.id.botao);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FazerTarefas.class);
                intent.putExtra("aux",2);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });



    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent dados){
        if(resultCode == RESULT_OK && requestCode == REQUEST_CODE){

            int prioridade = Integer.parseInt(dados.getStringExtra("prioridade"));
            String nome = dados.getStringExtra("nome");
            String detalhamento = dados.getStringExtra("descricao");

            Tarefa tarefa = new Tarefa(prioridade,nome,detalhamento);
            arrayTarefa.add(tarefa);
            ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayTarefa);
            lista.setAdapter(adapter);
        }
        else{
            Toast.makeText(this,"Cancelado",Toast.LENGTH_SHORT).show();
        }

    }
}