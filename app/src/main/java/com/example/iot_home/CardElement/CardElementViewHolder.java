package com.example.iot_home.CardElement;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.iot_home.R;

public class CardElementViewHolder extends RecyclerView.ViewHolder {
    TextView titulo;
    ToggleButton button;
    ImageView imagen;

    public CardElementViewHolder(@NonNull View itemView) {

        super(itemView);
        titulo = itemView.findViewById(R.id.titulo);
        button = itemView.findViewById(R.id.toggleButton);
        imagen = itemView.findViewById(R.id.imageView);

    }
}
