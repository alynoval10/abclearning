package com.example.abclearning;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;

public class TentangActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);

        // Tampilkan tombol back di ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Tentang Aplikasi");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    // Aksi ketika tombol back diklik
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // kembali ke MainActivity
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out); // animasi
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
