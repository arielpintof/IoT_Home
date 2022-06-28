package com.example.iot_home.ValueElement;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iot_home.R;
import com.github.angads25.toggle.widget.LabeledSwitch;

public class ValueElementViewHolder extends RecyclerView.ViewHolder{
    TextView titulo;
    TextView value;
    ImageView imagen;

    public ValueElementViewHolder(@NonNull View itemView) {
        super(itemView);
        titulo = itemView.findViewById(R.id.titulo_value);
        imagen = itemView.findViewById(R.id.imageViewValue);
        value = itemView.findViewById(R.id.value);
    }
}

