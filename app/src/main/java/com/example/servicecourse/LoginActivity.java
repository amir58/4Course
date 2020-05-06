package com.example.servicecourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText editTextUsername, editTextPassword;
    Button button;

    MySharedPreferences mySharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.login_activity_username_et);
        editTextPassword = findViewById(R.id.login_activity_password_et);
        button = findViewById(R.id.login_activity_btn);

        mySharedPreferences = new MySharedPreferences(LoginActivity.this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please fill all data", Toast.LENGTH_SHORT).show();

                }
                else if (username.equals("admin") && password.equals("admin")) {
                    mySharedPreferences.setUserLogin(true);
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }

            }
        });

    }
}
