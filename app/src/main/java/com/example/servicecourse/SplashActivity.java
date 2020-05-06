package com.example.servicecourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    MySharedPreferences mySharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mySharedPreferences = new MySharedPreferences(SplashActivity.this);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(3000);

                    if (mySharedPreferences.isUserLogin()) {
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));

                    } else {
                        startActivity(new Intent(SplashActivity.this, LoginActivity.class));

                    }
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        thread.start();

    }
}
