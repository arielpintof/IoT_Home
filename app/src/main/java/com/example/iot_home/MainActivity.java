package com.example.iot_home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.iot_home.CardElement.CardElementAdaptador;
import com.example.iot_home.ValueElement.ValueElementAdaptador;
import com.example.iot_home.model.Sala;
import com.example.iot_home.model.Value;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        
        List<Sala> salas = new ArrayList<>();
        salas.add(new Sala("Dormitorio", R.drawable.ic_baseline_bedroom_parent_24));
        salas.add(new Sala("Living", R.drawable.ic_baseline_living_24));
        salas.add(new Sala("Cocina", R.drawable.ic_baseline_kitchen_24));
        salas.add(new Sala("Baño", R.drawable.ic_baseline_bathtub_24));

        RecyclerView luces = findViewById(R.id.luces);
        luces.setLayoutManager(new GridLayoutManager(this, 2,GridLayoutManager.VERTICAL,false));
        luces.setAdapter(new CardElementAdaptador(this, salas));


        var database = FirebaseDatabase.getInstance();
        var humedadRef = database.getReference("humedad");
        var tempRef = database.getReference("temperatura");

        List<Value> values = new ArrayList<>();
        values.add(new Value("Temperatura", R.drawable.ic_baseline_home_24));
        values.add(new Value("Humedad", R.drawable.ic_baseline_home_24));
        RecyclerView sensores = findViewById(R.id.sensores);
        sensores.setLayoutManager(new GridLayoutManager(this, 2,GridLayoutManager.VERTICAL,false));
        sensores.setAdapter(new ValueElementAdaptador(this, values));


    }
}