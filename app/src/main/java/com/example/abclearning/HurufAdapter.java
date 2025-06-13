package com.example.abclearning;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.graphics.Color;
import java.util.Random;


public class HurufAdapter extends RecyclerView.Adapter<HurufAdapter.ViewHolder> {

    private final String[] hurufArray;
    private final int[] colors = {
            Color.RED, Color.BLUE, Color.GREEN,
            Color.MAGENTA, Color.YELLOW, Color.CYAN,
            Color.parseColor("#FF5722"), Color.parseColor("#9C27B0")
    };

    public HurufAdapter(String[] hurufArray) {
        this.hurufArray = hurufArray;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_huruf, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(hurufArray[position]);

        // Ganti warna latar belakang secara acak
        int randomColor = colors[new Random().nextInt(colors.length)];
        holder.textView.setBackgroundColor(randomColor);
    }

    @Override
    public int getItemCount() {
        return hurufArray.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textItemHuruf);
        }
    }
}
