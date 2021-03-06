package com.example.gallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.LinearInterpolator;

import com.agrawalsuneet.dotsloader.loaders.LazyLoader;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;
    LazyLoader lazyLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // PROGRESS BAR //
        lazyLoader = findViewById(R.id.progressBar);
        LazyLoader loader = new LazyLoader(this, 30, 20, ContextCompat.getColor(this, R.color.loader_selected),
                ContextCompat.getColor(this, R.color.loader_selected),
                ContextCompat.getColor(this, R.color.loader_selected));

        loader.setInterpolator(new LinearInterpolator());
        lazyLoader.addView(loader);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
             Intent homeIntent = new Intent(MainActivity.this,Login.class);
             startActivity(homeIntent);
             finish();
            }
        }, SPLASH_TIME_OUT);

    }
}