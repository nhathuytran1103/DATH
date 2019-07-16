package com.example.nguyenphuocphu.ph;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ChonPhanUng extends AppCompatActivity {
    Button btnVoco, btnHuuco;
    TextView textView;
    ImageButton btnReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chon_phanung);
        btnVoco = (Button) findViewById(R.id.btnVoco);
        btnHuuco = (Button) findViewById(R.id.btnHuuco);
        textView = (TextView) findViewById(R.id.textView);
        btnReset = (ImageButton) findViewById(R.id.btnReset) ;
        btnVoco.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                startActivity(new Intent(ChonPhanUng.this, GridViewChatVoco.class));
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
            }
        });
        btnHuuco.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                startActivity(new Intent(ChonPhanUng.this, GridViewChatHuuco.class));
            }
        });
    }
}
