package com.example.fabiano.hemocentro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.fabiano.hemocentro.meuAdapter.CustomAdapterRankDoador;
import com.example.fabiano.hemocentro.model.Doador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Rank extends AppCompatActivity {
    private Map<String,Integer> mapa;
    private List<String> nomesDoadores = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        for(String s : getNomeDoadores()){
            nomesDoadores.add(s);
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerRank);
        mapa = colapsar();
        
        CustomAdapterRankDoador customAdapterRankDoador = new CustomAdapterRankDoador(this,mapa,nomesDoadores);
        recyclerView.setAdapter(customAdapterRankDoador);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public Map<String,Integer> colapsar(){
        List<Doador> lista = Doador.listAll(Doador.class);
        Map<String,Integer> nomeQtd = new HashMap<String, Integer>();

        for(String s : getNomeDoadores()){
            int qtdBolsa = 0;
            for(Doador d: lista){
                if(d.getNome().equals(s)){
                    qtdBolsa += d.getDoacao().getBolsas().getQtdBolsa();
                }
            }
            nomeQtd.put(s,qtdBolsa);
        }
        return nomeQtd;
    }

    public Set<String> getNomeDoadores(){
        List<Doador> lista = Doador.listAll(Doador.class);
        Set<String> aux = new HashSet<>();

        for(Doador d: lista){
            aux.add(d.getNome());
        }

        return aux;
    }
    /*
    public List organizar(Map map){
        Set<String> aux = map.keySet();
        List<String> aux1 = new ArrayList<>();
        for (String s: aux){
            Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
        }
        for(int i = 0; i < map.size();i++){
            int maior = 0;
            String tmp = "";
            for(String s : aux){
                if((Integer)map.get(s) >= maior){
                    tmp = s;
                    maior = (Integer)map.get(s);
                }
            }
            Toast.makeText(this,tmp,Toast.LENGTH_SHORT).show();
            aux.remove(tmp);
            aux1.add(tmp);
        }

        return aux1;
    }
    */
}
