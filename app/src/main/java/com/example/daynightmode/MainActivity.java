package com.example.daynightmode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button daybutton, nightbutton;
    ImageView imageView;
    LinearLayout linearLayout;
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        daybutton = (Button) findViewById(R.id.day);
        nightbutton = (Button) findViewById(R.id.night);
        imageView = (ImageView) findViewById(R.id.imageview);
        linearLayout = (LinearLayout) findViewById(R.id.view);

        daybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DayThemeMode();
            }
        });
        nightbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NightThemeMode();
            }
        });
    }

    private void NightThemeMode() {
        handler = new Handler();
        imageView.setImageResource(R.drawable.moon1);
        imageView.setVisibility(View.VISIBLE);
        linearLayout.setBackgroundColor(getResources().getColor(R.color.nightBackground));
        runnable = new Runnable() {
            @Override
            public void run() {
                imageView.setVisibility(View.INVISIBLE);
            }
        };
        //handler.postDelayed(runnable, 4000);
    }

    private void DayThemeMode() {
        handler = new Handler();
        imageView.setImageResource(R.drawable.sun);
        imageView.setVisibility(View.VISIBLE);
        linearLayout.setBackgroundColor(getResources().getColor(R.color.dayBackground));
        runnable = new Runnable() {
            @Override
            public void run() {
                imageView.setVisibility(View.INVISIBLE);
            }
        };
        //handler.postDelayed(runnable, 4000);
    }
}