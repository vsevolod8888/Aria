package com.example.arria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button play;
    TextView tvScore;
    Context context;
    private static final String SHARED_PREFS = "sharedPrefs";
    private static final int KEY = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

    }

    @SuppressLint({"RestrictedApi", "WrongConstant"})
    private void initialize() {
        play = (Button)findViewById(R.id.button_start_to_play);
        tvScore = findViewById(R.id.tvScore);
        Animation animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
        play.startAnimation(animZoomIn);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent startGame1 = new Intent(getBaseContext(), PlayActivity.class);
                startActivity(startGame1);
            }
        });


        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        // Long countBring = sharedPreferences.getLong(String.va);
        Long countBring = sharedPreferences.getLong(String.valueOf(KEY), 0);
        updateOurCountDownText(countBring);


    }
    private void updateOurCountDownText(long m) {
        int minutes = (int) (m / 1000) / 60;// из миллисекунд, кот.остались до конца получаем минуты
        int seconds = (int) (m / 1000) % 60;//получаем секунды, напр.2%60 =2,
        String timeLeftFormatted = String.format(Locale.getDefault(), "%2d:%02d", minutes, seconds);
        tvScore.setText("Рекорд : "+timeLeftFormatted);
    }
}