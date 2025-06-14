package com.example.abclearning;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.view.animation.Animation;


public class MainActivity extends AppCompatActivity {

    Button btnHuruf, btnAngka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        // Animasi background
        ImageView bgImage = findViewById(R.id.bgImage);

        TranslateAnimation animation = new TranslateAnimation(
                0, 0, -30, 30); // naik turun
        animation.setDuration(4000);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setRepeatCount(Animation.INFINITE);
        bgImage.startAnimation(animation);

        btnHuruf = findViewById(R.id.btnBelajarHuruf);
        btnAngka = findViewById(R.id.btnBelajarAngka);
        Button btnTentang = findViewById(R.id.btnTentang);

        btnHuruf.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, HurufActivity.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        btnAngka.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AngkaActivity.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        btnTentang.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TentangActivity.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        Button btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity(); // Menutup semua activity
            }
        });
    }
}
