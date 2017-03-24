package com.example.fabiano.tarefas;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import model.Tarefa;

public class FazerTarefas extends AppCompatActivity {
    private List arrayReceiveTarefas;
    private EditText nome;
    private EditText prioridade;
    private EditText descricao;
    private Button enviar;
    private Button cancelar;
    private Intent intent;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fazer_tarefas);

        intent = new Intent();
        nome = (EditText) findViewById(R.id.nome);
        prioridade = (EditText) findViewById(R.id.prioridade);
        descricao = (EditText) findViewById(R.id.descricao);



        enviar = (Button) findViewById(R.id.enviar);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("nome",nome.getText().toString());
                intent.putExtra("prioridade",prioridade.getText().toString());
                intent.putExtra("descricao",descricao.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        cancelar = (Button) findViewById(R.id.cancelar);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });


    }
}
