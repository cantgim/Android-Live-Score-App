package com.example.demolivescore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.demolivescore.model.Item;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(R.drawable.p1,"Barca star Alba bemoans 'bad point' after Alaves draw", "LaLiga"));
        items.add(new Item(R.drawable.p2,"Mourinho having 'fun' despite admitting Roma job is 'tough'\n" +
                "\n", "Ac Milan"));
        items.add(new Item(R.drawable.p3,"'Dizzy' Aguero taken to hospital for cardiac exam, Barcelona confirm", "LaLiga"));
        items.add(new Item(R.drawable.p4,"Barcelona 1-1 Deportivo Alaves: Barca held as Aguero forced off injured", "LaLiga"));

        RecyclerAdapter2 adapter = new RecyclerAdapter2(items, this);
        RecyclerView recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setAdapter(adapter);
        //chon dang hien thi
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}