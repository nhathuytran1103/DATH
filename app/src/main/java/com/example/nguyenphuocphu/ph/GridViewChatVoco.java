package com.example.nguyenphuocphu.ph;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class GridViewChatVoco extends AppCompatActivity {
    GridView gvChatVoco;
    Button btnClose;
    ArrayList<ImageViewChat> arrayList;
    ImageChatAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatvoco_grid_view);
        AnhXa();
        adapter = new ImageChatAdapter(this, R.layout.image_chat, arrayList);
        gvChatVoco.setAdapter(adapter);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GridViewChatVoco.this, ChonPhanUng.class));
            }
        });
        gvChatVoco.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewChatVoco.this, arrayList.get(position).getTenChat(), Toast.LENGTH_SHORT);

            }
        });

    }

    private void AnhXa() {
        btnClose = (Button) findViewById(R.id.btnClose);
        gvChatVoco = (GridView) findViewById(R.id.gvChatVoco);
        arrayList = new ArrayList<ImageViewChat>();
        //arrayList.add(new ImageViewChat("2", "H20", R.drawable.alicon));

    }
}
