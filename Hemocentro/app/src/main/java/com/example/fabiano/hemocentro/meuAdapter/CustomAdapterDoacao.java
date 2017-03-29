package com.example.fabiano.hemocentro.meuAdapter;

import android.app.Activity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fabiano.hemocentro.R;

import java.util.List;

import com.example.fabiano.hemocentro.model.Bolsa;
import com.example.fabiano.hemocentro.model.Doacao;
import com.example.fabiano.hemocentro.model.Doador;

/**
 * Created by fabiano on 24/03/17.
 */

public class CustomAdapterDoacao extends RecyclerView.Adapter<CustomAdapterDoacao.ViewHolder> {
    private Doador doador;
    private List<Doador> lista;
    private Activity activity;
    public CustomAdapterDoacao(Activity activity, List lista){
        this.lista = lista;
        this.activity = activity;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView texto1;
        protected TextView texto2;

        public ViewHolder(View itemView) {
            super(itemView);
            texto1 = (TextView) itemView.findViewById(R.id.textAdapter1);
            texto2 = (TextView) itemView.findViewById(R.id.textAdapter2);
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_adapter_doacao,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        doador = lista.get(position);
        holder.texto1.setText("Doador: " + doador.getNome());
        holder.texto2.setText("Tipo Sanguineo: "+doador.getTipoSanguineo());
        deletar(holder,position);
        //verInformacoes(holder,position);

    }
    /*|
    public void verInformacoes(ViewHolder holder, int position){
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }*/

    public void deletar(ViewHolder holder, final int position){
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                PopupMenu popupMenu = new PopupMenu(activity,v);
                popupMenu.getMenuInflater().inflate(R.menu.menu_item,popupMenu.getMenu());

                popupMenu.getMenu().getItem(0).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Bolsa.delete(lista.get(position).getDoacao().getBolsa());
                        Doacao.delete(lista.get(position).getDoacao());
                        Doador.delete(lista.get(position));
                        lista.remove(lista.get(position));
                        notifyItemRangeChanged(position,lista.size());
                        notifyItemRemoved(position);

                        return false;
                    }
                });

                popupMenu.show();
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

}
