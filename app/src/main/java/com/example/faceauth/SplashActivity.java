package com.example.faceauth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    String Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ConstraintLayout constraintLayout = findViewById(R.id.SplashLayout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        SharedPreferences settings = getSharedPreferences("PREFS", 0);
        Password = settings.getString("password", "");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(Password.equals("")){
                    Intent SetPasswordActivity = new Intent(SplashActivity.this , SetPassword.class);
                    startActivity(SetPasswordActivity);
                    finish();
                } else {
                    Intent EnterPasswordActivity = new Intent(SplashActivity.this , ImportantData.class);
                    startActivity(EnterPasswordActivity);
                    finish();
                }
            }
        },2000);
    }
}
