package com.example.abclearning;

import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;

public class AngkaAdapter extends RecyclerView.Adapter<AngkaAdapter.AngkaViewHolder> {

    private final String[] angkaArray;
    private final int[] colors = {
            Color.RED, Color.BLUE, Color.GREEN,
            Color.MAGENTA, Color.CYAN, Color.YELLOW,
            Color.parseColor("#FF5722"), // Orange
            Color.parseColor("#9C27B0"), // Ungu
            Color.parseColor("#4CAF50"), // Hijau terang
            Color.parseColor("#03A9F4")  // Biru terang
    };

    public AngkaAdapter(String[] angkaArray) {
        this.angkaArray = angkaArray;
    }

    @NonNull
    @Override
    public AngkaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView textView = new TextView(parent.getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(72);
        textView.setTextColor(Color.WHITE);
        textView.setTypeface(null, android.graphics.Typeface.BOLD);
        return new AngkaViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(@NonNull AngkaViewHolder holder, int position) {
        holder.textView.setText(angkaArray[position]);
        holder.textView.setBackgroundColor(getRandomColor());
    }

    @Override
    public int getItemCount() {
        return angkaArray.length;
    }

    public static class AngkaViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public AngkaViewHolder(@NonNull TextView itemView) {
            super(itemView);
            textView = itemView;
        }
    }

    private int getRandomColor() {
        Random random = new Random();
        return colors[random.nextInt(colors.length)];
    }
}
