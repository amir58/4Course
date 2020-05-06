package com.example.servicecourse;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

        // Update Code

//        SharedPreferences mySharedPreferences = getSharedPreferences("userData", MODE_PRIVATE);
//
//        mySharedPreferences.edit().putString("userName", "Amir Mohammed").apply();
//
//        String username = mySharedPreferences.getString("userName", "Not Found");
//
//        mySharedPreferences.edit().putBoolean("isUserLogin", true).apply();
//
//        boolean isUserLogin = mySharedPreferences.getBoolean("isUserLogin", false);
//
//        Toast.makeText(this, username + isUserLogin, Toast.LENGTH_SHORT).show();
//
//        MySharedPreferences preferences = new MySharedPreferences(MainActivity.this);

//        // code by class
//
//        String userId = null;
//
//        userId = preferences.getUserId();
//
//        Toast.makeText(this, userId, Toast.LENGTH_LONG).show();
//
//        preferences.setUserId("1410");
//
//        userId = preferences.getUserId();
//
//        Toast.makeText(this, userId, Toast.LENGTH_LONG).show();
//    }
    }


    public void startService(View view) {
        Intent intent = new Intent(MainActivity.this, MyService.class);
        startService(intent);
    }

    public void stopService(View view) {
        Intent intent = new Intent(MainActivity.this, MyService.class);
        stopService(intent);
    }
}
