package meuAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fabiano.hemocentro.R;

import java.util.List;

import model.Doador;

/**
 * Created by fabiano on 24/03/17.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private List<Doador> lista;
    public CustomAdapter(List lista){
        this.lista = lista;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_adapter,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Doador doador = lista.get(position);
        holder.texto1.setText("Nome: " + doador.getNome());
        holder.texto2.setText("Tipo Sanguineo: "+doador.getTipoSanguineo());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

}
