package com.example.fabiano.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lista;
    private ArrayList listObject = new ArrayList<Whatever>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TestAdapter adapter = new TestAdapter(this,android.R.layout.simple_list_item_1,listObject);
        Whatever whatever = new Whatever();
        adapter.add(whatever);
        lista = (ListView) findViewById(R.id.lista);
        lista.setAdapter(adapter);
    }
}
