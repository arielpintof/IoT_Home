package com.example.iot_home.ValueElement;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iot_home.CardElement.CardElementViewHolder;
import com.example.iot_home.R;
import com.example.iot_home.model.Value;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class ValueElementAdaptador extends RecyclerView.Adapter<ValueElementViewHolder> {
    Context context;
    List<Value> values;

    public ValueElementAdaptador(Context context, List<Value> values) {
        this.context = context;
        this.values = values;
    }

    @NonNull
    @Override
    public ValueElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        var view = LayoutInflater.from(context).inflate(R.layout.temp_humedad, parent, false);
        return new ValueElementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ValueElementViewHolder holder, @SuppressLint("RecyclerView") int position) {
        var database = FirebaseDatabase.getInstance();
        var humedadRef = database.getReference();
        var tempRef = database.getReference();

        holder.titulo.setText(values.get(position).getType());
        holder.imagen.setImageResource(values.get(position).getIcon());

        tempRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                var val = snapshot.child("temperatura").getValue();
                var value = String.valueOf(val);
                if (position == 0){
                    holder.value.setText(value);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        humedadRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                var val = snapshot.child("humedad").getValue();
                var value = String.valueOf(val);
                if (position == 1){
                    holder.value.setText(value);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}
