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
                startActivity(new Intent(GridViewChatVoco.this, MainActivity.class));
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
        arrayList.add(new ImageViewChat("Na", R.drawable.naicon));
        arrayList.add(new ImageViewChat("Al", R.drawable.alicon));
        arrayList.add(new ImageViewChat("Cu", R.drawable.cuicon));
        arrayList.add(new ImageViewChat("H20", R.drawable.h2oicon));
        arrayList.add(new ImageViewChat("Mo", R.drawable.moicon));
        arrayList.add(new ImageViewChat("O2", R.drawable.o2icon));

    }
}
