package com.example.baitaplon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SendEmailActivity extends AppCompatActivity {
    Button SendEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);
        SendEmail = findViewById(R.id.sendEmail);
        SendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    @SuppressLint("LongLogTag")
    protected void sendEmail() {
        Log.i("Send email","");
        String [] TO={""};
        String [] CC={""};
        Intent emailIntent= new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL,TO);
        emailIntent.putExtra(Intent.EXTRA_CC,CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT,"Email message goes here");
        try {
            startActivity(Intent.createChooser(emailIntent,"Send mail..."));
            finish();
            Log.i("Finished sending email...", "");
        }catch (android.content.ActivityNotFoundException e)
        {
            Toast.makeText(this, "There is no email client installed", Toast.LENGTH_SHORT).show();
        }
    }

    }