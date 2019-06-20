package com.example.nguyenphuocphu.ph;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.ArrayList;

public class GridViewChatHuuco extends AppCompatActivity {
    String urlGetdata = "http://192.168.1.12/WebService01/getdata.php";
    GridView gvChatHuuco;
    Button btnClose;
    ArrayList<ImageViewChat> arrayList;
    ImageChatAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.chathuuco_grid_view);
        AnhXa();
        GetData(urlGetdata);
        adapter = new ImageChatAdapter(this, R.layout.image_chat, arrayList);
        gvChatHuuco.setAdapter(adapter);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GridViewChatHuuco.this, MainActivity.class));
            }
        });
        gvChatHuuco.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewChatHuuco.this, arrayList.get(position).getTenChat(), Toast.LENGTH_SHORT);

            }
        });

    }

    private void GetData(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Toast.makeText(GridViewChatHuuco.this, response.toString(), Toast.LENGTH_SHORT);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(GridViewChatHuuco.this, "Lỗi!", Toast.LENGTH_SHORT).show();

                    }
                }
        );
        requestQueue.add(jsonArrayRequest);

    }

    private void AnhXa() {
        btnClose = (Button) findViewById(R.id.btnClose);
        gvChatHuuco = (GridView) findViewById(R.id.gvChatHuuco);
        arrayList = new ArrayList<ImageViewChat>();
        arrayList.add(new ImageViewChat("Na", R.drawable.naicon));
        arrayList.add(new ImageViewChat("Al", R.drawable.alicon));
        arrayList.add(new ImageViewChat("Cu", R.drawable.cuicon));
        arrayList.add(new ImageViewChat("H20", R.drawable.h2oicon));
        arrayList.add(new ImageViewChat("Mo", R.drawable.moicon));
        arrayList.add(new ImageViewChat("O2", R.drawable.o2icon));

    }
}
