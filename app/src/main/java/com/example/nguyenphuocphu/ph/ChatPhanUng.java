package com.example.nguyenphuocphu.ph;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChatPhanUng extends AppCompatActivity {
    String urlGetdata = "http://192.168.1.12/WebService01/getChat2.php";
    String urlGetPhanUng = "http://192.168.1.12/WebService01/getPhanUng.php";
    GridView gvChatHuuco;
    Button btnClose;
    ArrayList<ImageViewChat> arrayList;
    ImageChatAdapter adapter;
    String chat1;
    String chat2;
    PhanUngModel phanUngModel = new PhanUngModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chathuuco_grid_view);
        Intent intent = getIntent();
        // tên chất vừa chọn, được gửi từ màn hình trước
        chat1 = intent.getStringExtra("chat1");
        btnClose = (Button) findViewById(R.id.btnClose);
        gvChatHuuco = (GridView) findViewById(R.id.gvChatHuuco);
        arrayList = new ArrayList<>();
        adapter = new ImageChatAdapter(this, R.layout.image_chat, arrayList);
        PostString(urlGetdata);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChatPhanUng.this, ChonPhanUng.class));
            }
        });
        gvChatHuuco.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                chat2 = arrayList.get(position).getTenChat();
                GetPhanUng(urlGetPhanUng);
                Intent intent = new Intent(ChatPhanUng.this, ChonPhanUng.class);
                System.out.println(phanUngModel.getChatSanPham1());
                intent.putExtra("chat2", phanUngModel.getChatSanPham1());
                intent.putExtra("chat1", phanUngModel.getChatSanPham2());
                ChatPhanUng.this.startActivity(intent);

            }
        });
    }
    // hàm lấy dữ liệu các chất phản ứng được với chất vừa chọn
    private void PostString(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONArray jsonArr = null;
                        try {
                            jsonArr = new JSONArray(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        for (int i = 0; i < jsonArr.length(); i++)
                        {
                            JSONObject jsonObj = null;
                            try {
                                jsonObj = jsonArr.getJSONObject(i);
                                arrayList.add(new ImageViewChat(
                                        jsonObj.getString("Id"),
                                        jsonObj.getString("TenChat"),
                                        jsonObj.getString("HinhChat")
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

                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("chat1", chat1);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
    // hàm lấy tất cả dữ liệu của phản ứng được chọn
    private void GetPhanUng(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            phanUngModel.setChatSanPham1(jsonObject.getString("ChatSanPham1"));
                            phanUngModel.setChatSanPham2(jsonObject.getString("ChatSanPham2"));
                        }catch (JSONException err){
                            Log.d("Error", err.toString());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("chat1", chat1);
                params.put("chat2", chat2);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
