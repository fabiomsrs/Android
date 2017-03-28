package com.example.fabiano.testsugar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fabiano.testsugar.model.Produto;

public class MainActivity extends AppCompatActivity {
    private Produto produto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button botao = (Button) findViewById(R.id.botao);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criandoSalvando();
                mostrando();
            }
        });

    }

    public void criandoSalvando(){
        produto = new Produto("Test",1);
        produto.save();
    }

    public void mostrando(){
        Produto produto1 = Produto.findById(Produto.class ,1);
        Toast.makeText(this,"Produto" + produto1,Toast.LENGTH_LONG).show();
    }

}
