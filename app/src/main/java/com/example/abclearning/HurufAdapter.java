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

public class HurufAdapter extends RecyclerView.Adapter<HurufAdapter.ViewHolder> {

    private final String[] hurufArray;
    private final int[] colors = {
            Color.RED, Color.BLUE, Color.GREEN,
            Color.MAGENTA, Color.YELLOW, Color.CYAN,
            Color.parseColor("#FF5722"), Color.parseColor("#9C27B0")
    };
    private final Context context;

    public HurufAdapter(Context context, String[] hurufArray) {
        this.context = context;
        this.hurufArray = hurufArray;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_huruf, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String huruf = hurufArray[position];
        holder.textView.setText(huruf);

        // Ganti warna background secara acak
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
