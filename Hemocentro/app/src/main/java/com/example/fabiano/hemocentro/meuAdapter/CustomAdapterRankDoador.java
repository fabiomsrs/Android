package com.example.fabiano.hemocentro.meuAdapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fabiano.hemocentro.R;
import com.example.fabiano.hemocentro.model.Doador;

import java.util.List;
import java.util.Map;

/**
 * Created by fabiano on 27/03/17.
 */

public class CustomAdapterRankDoador extends RecyclerView.Adapter<CustomAdapterRankDoador.ViewHolder>{

    Map<String,Integer> map;
    List<String> nomes;
    Activity activity;

    public CustomAdapterRankDoador(Activity activity,Map<String,Integer> map,List nomes){
        this.map = map;
        this.nomes = nomes;
        this.activity = activity;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView nomeDoador;
        protected TextView numeroBolsa;
        public ViewHolder(View itemView) {
            super(itemView);
            nomeDoador = (TextView) itemView.findViewById(R.id.nomeDoador);
            numeroBolsa = (TextView) itemView.findViewById(R.id.nBolsas);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_adapter_rank,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        String aux = nomes.get(position);
        holder.nomeDoador.setText("Nome: " + aux);
        holder.numeroBolsa.setText("Bolsas: " + map.get(aux));
    }

    @Override
    public int getItemCount() {
        return nomes.size();
    }


}
