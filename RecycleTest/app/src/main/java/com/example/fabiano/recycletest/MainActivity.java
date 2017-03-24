package com.example.fabiano.recycletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Test> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Test test = new Test();
        list.add(test);
        list.add(test);
        list.add(test);
        list.add(test);
        list.add(test);
        list.add(test);
        list.add(test);
        list.add(test);
        list.add(test);
        list.add(test);
        list.add(test);
        list.add(test);
        list.add(test);
        list.add(test);
        list.add(test);
        RecyclerView view = (RecyclerView) findViewById(R.id.recycler);
        MeuAdapter adapter = new MeuAdapter(this,list);
        view.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(this);

        view.setLayoutManager(manager);

    }
}
