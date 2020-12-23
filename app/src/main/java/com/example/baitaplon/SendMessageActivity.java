package com.example.baitaplon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendMessageActivity extends AppCompatActivity {
    Context context;
    EditText edtsdt,edtnoidung;
    Button btngui,btnhuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        edtsdt =findViewById(R.id.edittextnhapsodienthoai);
        edtnoidung =findViewById(R.id.editnoidung);
        btngui = findViewById(R.id.buttongui);
        btnhuy = findViewById(R.id.buttonhuy);
        btngui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(SendMessageActivity.this, new String[]{Manifest.permission.SEND_SMS}, 0);
                try {
                    SmsManager m  =  SmsManager.getDefault();
                    m.sendTextMessage(edtsdt.getText().toString(),null,edtnoidung.getText().toString(),null,null);
                    Toast.makeText(SendMessageActivity.this,"Tin nhan da duoc gui",Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Kiem tra lai tai khoan",Toast.LENGTH_LONG).show();
                    //  txtWarning.setText(e.getMessage());
                }
            }
        });
        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}