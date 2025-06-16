package com.example.abclearning;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;

public class AngkaAdapter extends RecyclerView.Adapter<AngkaAdapter.ViewHolder> {

    private final String[] angkaArray;
    private final int[] colors = {
            Color.RED, Color.BLUE, Color.GREEN,
            Color.MAGENTA, Color.YELLOW, Color.CYAN,
            Color.parseColor("#FF5722"), Color.parseColor("#9C27B0")
    };
    private final Context context;

    public AngkaAdapter(Context context, String[] angkaArray) {
        this.context = context;
        this.angkaArray = angkaArray;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_angka, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String angka = angkaArray[position];
        holder.textView.setText(angka);

        // Ganti warna background layar penuh, bukan hanya TextView
        int randomColor = colors[new Random().nextInt(colors.length)];
        holder.itemView.setBackgroundColor(randomColor); // 👈 ini penting
    }

    @Override
    public int getItemCount() {
        return angkaArray.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textItemAngka);
        }
    }
}
