package com.example.abclearning;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.HashMap;

public class AngkaActivity extends AppCompatActivity {

    private final String[] angkaArray = {
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
    };

    private SoundPool soundPool;
    private HashMap<String, Integer> soundMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angka);

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

        // Load suara angka ke soundMap (pastikan file ada di res/raw)
        soundMap = new HashMap<>();
        soundMap.put("1", soundPool.load(this, R.raw.angka_1, 1));
        soundMap.put("2", soundPool.load(this, R.raw.angka_2, 1));
        soundMap.put("3", soundPool.load(this, R.raw.angka_3, 1));
        soundMap.put("4", soundPool.load(this, R.raw.angka_4, 1));
        soundMap.put("5", soundPool.load(this, R.raw.angka_5, 1));
        soundMap.put("6", soundPool.load(this, R.raw.angka_6, 1));
        soundMap.put("7", soundPool.load(this, R.raw.angka_7, 1));
        soundMap.put("8", soundPool.load(this, R.raw.angka_8, 1));
        soundMap.put("9", soundPool.load(this, R.raw.angka_9, 1));
        soundMap.put("10", soundPool.load(this, R.raw.angka_10, 1));

        // ViewPager & Adapter
        ViewPager2 viewPager = findViewById(R.id.viewPagerAngka);
        viewPager.setAdapter(new AngkaAdapter(this, angkaArray));

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                String angka = angkaArray[position];
                Integer soundId = soundMap.get(angka);
                if (soundId != null) {
                    soundPool.play(soundId, 1, 1, 0, 0, 1);
                }
            }
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Belajar Angka");
        }
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
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
