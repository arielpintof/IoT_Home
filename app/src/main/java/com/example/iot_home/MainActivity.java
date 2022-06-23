package com.example.iot_home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.iot_home.CardElement.CardElementAdaptador;
import com.example.iot_home.model.Sala;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Sala> salas = new ArrayList<>();
        salas.add(new Sala("Dormitorio", R.drawable.ic_launcher_foreground));
        salas.add(new Sala("Living", R.drawable.ic_launcher_foreground));
        salas.add(new Sala("Cocina", R.drawable.ic_launcher_foreground));
        salas.add(new Sala("Baño", R.drawable.ic_launcher_foreground));

        RecyclerView luces = findViewById(R.id.luces);
        luces.setLayoutManager(new GridLayoutManager(this, 2,GridLayoutManager.VERTICAL,false));
        luces.setAdapter(new CardElementAdaptador(this, salas));

    }
}