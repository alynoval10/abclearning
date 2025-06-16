package com.example.abclearning;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.HashMap;

public class HurufActivity extends AppCompatActivity {

    private final String[] hurufArray = {
            "A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z"
    };

    private SoundPool soundPool;
    private HashMap<String, Integer> soundMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huruf);

        // Inisialisasi SoundPool
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(1)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            soundPool = new SoundPool(1, android.media.AudioManager.STREAM_MUSIC, 0);
        }

        // Load suara ke soundMap
        soundMap = new HashMap<>();
        soundMap.put("A", soundPool.load(this, R.raw.a, 1));
        soundMap.put("B", soundPool.load(this, R.raw.b, 1));
        soundMap.put("C", soundPool.load(this, R.raw.c, 1));
        soundMap.put("D", soundPool.load(this, R.raw.d, 1));
        soundMap.put("E", soundPool.load(this, R.raw.e, 1));
        soundMap.put("F", soundPool.load(this, R.raw.f, 1));
        soundMap.put("G", soundPool.load(this, R.raw.g, 1));
        soundMap.put("H", soundPool.load(this, R.raw.h, 1));
        soundMap.put("I", soundPool.load(this, R.raw.i, 1));
        soundMap.put("J", soundPool.load(this, R.raw.j, 1));
        soundMap.put("K", soundPool.load(this, R.raw.k, 1));
        soundMap.put("L", soundPool.load(this, R.raw.l, 1));
        soundMap.put("M", soundPool.load(this, R.raw.m, 1));
        soundMap.put("N", soundPool.load(this, R.raw.n, 1));
        soundMap.put("O", soundPool.load(this, R.raw.o, 1));
        soundMap.put("P", soundPool.load(this, R.raw.p, 1));
        soundMap.put("Q", soundPool.load(this, R.raw.q, 1));
        soundMap.put("R", soundPool.load(this, R.raw.r, 1));
        soundMap.put("S", soundPool.load(this, R.raw.s, 1));
        soundMap.put("T", soundPool.load(this, R.raw.t, 1));
        soundMap.put("U", soundPool.load(this, R.raw.u, 1));
        soundMap.put("V", soundPool.load(this, R.raw.v, 1));
        soundMap.put("W", soundPool.load(this, R.raw.w, 1));
        soundMap.put("X", soundPool.load(this, R.raw.x, 1));
        soundMap.put("Y", soundPool.load(this, R.raw.y, 1));
        soundMap.put("Z", soundPool.load(this, R.raw.z, 1));


        // Lanjutkan hingga Z...

        ViewPager2 viewPager = findViewById(R.id.viewPagerHuruf);
        HurufAdapter adapter = new HurufAdapter(this, hurufArray);
        viewPager.setAdapter(adapter);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                String huruf = hurufArray[position];
                Integer soundId = soundMap.get(huruf);
                if (soundId != null) {
                    soundPool.play(soundId, 1, 1, 0, 0, 1);
                }
            }
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Belajar Huruf");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (soundPool != null) {
            soundPool.release();
            soundPool = null;
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
