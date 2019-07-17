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
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * hàm xổ dữ liệu vào gridview với dữ liệu là tất cả các chất trong bảng chathoahoc
 */
public class GridViewChatVoco extends AppCompatActivity {
    String urlGetdata = "http://192.168.1.12/WebService01/getChatVoco.php";
    GridView gvChatHuuco;
    Button btnClose;
    ArrayList<ImageViewChat> arrayList;
    ImageChatAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chathuuco_grid_view);
        btnClose = (Button) findViewById(R.id.btnClose);
        gvChatHuuco = (GridView) findViewById(R.id.gvChatHuuco);
        arrayList = new ArrayList<>();
        adapter = new ImageChatAdapter(this, R.layout.image_chat, arrayList);
        GetData(urlGetdata);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GridViewChatVoco.this, ChonPhanUng.class));
            }
        });
        gvChatHuuco.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(GridViewChatHuuco.this, arrayList.get(position).getTenChat(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(GridViewChatVoco.this, GridViewChatVoco2.class);
                intent.putExtra("chat1", arrayList.get(position).getTenChat());
                GridViewChatVoco.this.startActivity(intent);
            }
        });
    }
    private void GetData(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject object = response.getJSONObject(i);
                                arrayList.add(new ImageViewChat(
                                        object.getString("Id"),
                                        object.getString("TenChat"),
                                        object.getString("HinhChat")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        gvChatHuuco.setAdapter(adapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(GridViewChatVoco.this, "Lỗi!" + error, Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }
}
