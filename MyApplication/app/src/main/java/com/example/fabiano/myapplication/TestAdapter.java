package com.example.fabiano.myapplication;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabiano on 20/03/17.
 */

public class TestAdapter extends ArrayAdapter<Whatever> {

    public TestAdapter( Context context, ArrayList<Whatever> whatever){
        super(context,0,whatever);
    }

    public TestAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public TestAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public TestAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull Whatever[] objects) {
        super(context, resource, objects);
    }

    public TestAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull Whatever[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public TestAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Whatever> objects) {
        super(context, resource, objects);
    }

    public TestAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<Whatever> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Whatever whatever = getItem(position);
        if(convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_layout,parent,false);
            TextView text1 = (TextView) convertView.findViewById(R.id.text1);
            TextView text2 = (TextView) convertView.findViewById(R.id.text2);

            text1.setText(whatever.nome);
            text2.setText(whatever.whatever);

        }
        else {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_layout,parent,false);
            TextView text1 = (TextView) convertView.findViewById(R.id.text1);
            TextView text2 = (TextView) convertView.findViewById(R.id.text2);

            text1.setText("test");
            text2.setText("test");
        }
        return convertView;
    }
}
