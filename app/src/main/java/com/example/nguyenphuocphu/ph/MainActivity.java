package com.example.nguyenphuocphu.ph;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button chonPhanUng, chonLoaiPhanUng, timChat;
    TextView textView;
    ImageButton btnReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chonPhanUng = (Button) findViewById(R.id.chonPhanUng);
        chonLoaiPhanUng = (Button) findViewById(R.id.chonLoaiPhanUng);
        timChat = (Button) findViewById(R.id.timChat);
        textView = (TextView) findViewById(R.id.textView);
        btnReset = (ImageButton) findViewById(R.id.btnReset) ;
        chonPhanUng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ChonPhanUng.class));
            }
        });
        timChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TimChat.class));
            }
        });
    }
}
