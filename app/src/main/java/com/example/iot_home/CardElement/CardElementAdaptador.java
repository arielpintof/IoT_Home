package com.example.iot_home.CardElement;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iot_home.R;
import com.example.iot_home.model.Sala;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class CardElementAdaptador extends RecyclerView.Adapter<CardElementViewHolder>{
    public Context context;
    public List<Sala> listaDeSalas;

    public CardElementAdaptador(Context context, List<Sala> listaDeProductos) {
        this.context = context;
        this.listaDeSalas = listaDeProductos;
    }

    @NonNull
    @Override
    public CardElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        var view = LayoutInflater.from(context).inflate(R.layout.card_element, parent, false);
        return new CardElementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardElementViewHolder holder, int position) {
        var pos = Integer.toString(position);
        var database = FirebaseDatabase.getInstance();
        var databaseReference = database.getReference("led_"+pos);

        holder.titulo.setText(listaDeSalas.get(position).getNombre());
        holder.imagen.setImageResource(listaDeSalas.get(position).getIcono());
        holder.button.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                databaseReference.setValue(1);
            } else {
                databaseReference.setValue(0);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaDeSalas.size();
    }
}







