package com.example.fabiano.hemocentro.meuAdapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fabiano.hemocentro.CampanhaListaDoador;
import com.example.fabiano.hemocentro.R;
import com.example.fabiano.hemocentro.model.Campanha;

import java.util.List;

/**
 * Created by fabiano on 30/03/17.
 */

public class CustomAdapterCampanha extends RecyclerView.Adapter<CustomAdapterCampanha.ViewHolder> {
    private Campanha campanha;
    private List<Campanha> lista;
    private Activity activity;
    public CustomAdapterCampanha(Activity activity, List lista){
        this.lista = lista;
        this.activity = activity;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView tipoSaguineoCampanha;
        protected TextView nomeCampanha;
        public ViewHolder(View itemView) {
            super(itemView);
            tipoSaguineoCampanha = (TextView) itemView.findViewById(R.id.tipoSaguineoCampanha);
            nomeCampanha = (TextView) itemView.findViewById(R.id.nomeCampanha);

        }

    }

    @Override
    public CustomAdapterCampanha.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_adapter_campanha,parent,false);
        CustomAdapterCampanha.ViewHolder viewHolder = new CustomAdapterCampanha.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CustomAdapterCampanha.ViewHolder holder, final int position) {
        campanha = lista.get(position);
        holder.nomeCampanha.setText(campanha.getNome());
        holder.tipoSaguineoCampanha.setText("Tipo Sanguineo: "+campanha.getTipoSanguineo());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity.getApplicationContext(), CampanhaListaDoador.class);
                intent.putExtra("tipo sanguineo",campanha.getTipoSanguineo());
                activity.startActivity(intent);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                PopupMenu popupMenu = new PopupMenu(activity,v);
                popupMenu.getMenuInflater().inflate(R.menu.menu_item,popupMenu.getMenu());

                popupMenu.getMenu().getItem(0).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Campanha.delete(campanha);
                        lista.remove(lista.get(position));
                        notifyItemRangeChanged(position,lista.size());
                        notifyItemRemoved(position);
                        return false;
                    }
                });

                popupMenu.show();
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

}


