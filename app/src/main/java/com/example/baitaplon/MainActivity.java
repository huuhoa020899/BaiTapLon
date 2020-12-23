package com.example.baitaplon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;

public class MainActivity extends AppCompatActivity {
    Button btnSendMessage,btnCall,btnSendEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SendEmailIntent = new Intent(MainActivity.this,SendEmailActivity.class);
                startActivity(SendEmailIntent);
            }
        });
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendCallIntent = new Intent(MainActivity.this,SendCallActivity.class);
                startActivity(sendCallIntent);
            }
        });
        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SendMessageIntent = new Intent(MainActivity.this,SendMessageActivity.class);
                startActivity(SendMessageIntent);
            }
        });
    }

    private void AnhXa() {
        btnSendMessage = findViewById(R.id.buttonSend);
        btnCall = findViewById(R.id.buttoncall);
        btnSendEmail = findViewById(R.id.buttonSendEmail);
    }
}