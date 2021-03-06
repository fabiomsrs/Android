package com.example.fabiano.hemocentro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fabiano.hemocentro.meuAdapter.CustomAdapterRankDoador;
import com.example.fabiano.hemocentro.model.Bolsa;
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
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        mapa = colapsar();
        nomesDoadores = organizar(mapa);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerRank);
        CustomAdapterRankDoador customAdapterRankDoador = new CustomAdapterRankDoador(this,mapa,nomesDoadores);
        recyclerView.setAdapter(customAdapterRankDoador);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public Map<String,Integer> colapsar(){
        Set<String> doadores = getNomeDoadores();
        List<Bolsa> bolsa = Bolsa.listAll(Bolsa.class);
        Map<String,Integer> nomeQtd = new HashMap<String, Integer>();

        for(String d: doadores){
            int qtd = 0;
            for(Bolsa b: bolsa){
                if(b.getDoacao().getDoador().getNome().equals(d))
                        qtd++;
            }
            nomeQtd.put(d,qtd);
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

    public List organizar(Map<String,Integer> map){
        Set<String> nome = getNomeDoadores();
        List<String> organizada = new ArrayList<>();
        int maior;
        String aux;

        for(int i = 0; i < map.size() ;i++){
            maior = 0;
            aux = "";
            for(String s : nome){
                if(map.get(s) >= maior){
                    aux = s;
                    maior = map.get(s);
                }
            }

            nome.remove(aux);
            organizada.add(aux);
        }

        return organizada;
    }

}
