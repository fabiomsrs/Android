package com.example.fabiano.recycletest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by fabiano on 23/03/17.
 */

public class MeuAdapter extends RecyclerView.Adapter<MeuAdapter.ViewHolder> {
    private List<Test> list;
    private Context context;

    public MeuAdapter(Context context, List<Test> list){
        this.context = context;
        this.list = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        protected TextView text1;
        protected TextView text2;
        public ViewHolder(View itemView) {
            super(itemView);
            text1 = (TextView) itemView.findViewById(R.id.text1);
            text2 = (TextView) itemView.findViewById(R.id.text2);
        }

    }

    @Override
    public MeuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.presentation_layout,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MeuAdapter.ViewHolder holder, int position) {
        Test test = list.get(position);
        holder.text1.setText(test.nome);
        holder.text2.setText(test.texto);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
