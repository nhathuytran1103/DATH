package com.example.nguyenphuocphu.ph;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class test extends AppCompatActivity {
    String urlGetdata = "http://192.168.1.12/WebService01/getdata.php";
    GridView gvChatHuuco;
    Button btnClose;
    ArrayList<ImageViewChat> arrayList;
    ImageChatAdapter adapter;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.chathuuco_grid_view);
        gvChatHuuco = (GridView) findViewById(R.id.gvChatHuuco);
        arrayList = new ArrayList<>();
        adapter = new ImageChatAdapter(this, R.layout.image_chat, arrayList);
        GetData(urlGetdata);
    }
    private void GetData(final String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Toast.makeText(test.this, response.toString(), Toast.LENGTH_SHORT).show();
                        for (int i=0; i < response.length(); i++) {
                            try {
                                JSONObject object = response.getJSONObject(i);
                                arrayList.add(new ImageViewChat(
                                   object.getString("tenchat"),
                                   object.getInt("hinhchat")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(test.this, error.getMessage(), Toast.LENGTH_SHORT).show();
//                        Toast.makeText(test.this, url, Toast.LENGTH_SHORT).show();
                        VolleyLog.e("Error: ", error.getMessage());


                    }
                }
        );
        requestQueue.add(jsonArrayRequest);

    }
}
