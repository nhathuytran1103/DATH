package com.example.nguyenphuocphu.ph;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

import pl.droidsonroids.gif.GifImageView;

public class ChonPhanUng extends AppCompatActivity {
    Button btnVoco, btnHuuco;
    TextView textView;
    ImageButton btnReset;
    String chat1;
    String chat2;
    GifImageView gifView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chon_phanung);
        btnVoco = (Button) findViewById(R.id.btnVoco);
        btnHuuco = (Button) findViewById(R.id.btnHuuco);
        textView = (TextView) findViewById(R.id.textView);
        btnReset = (ImageButton) findViewById(R.id.btnReset);
        gifView = (GifImageView) findViewById(R.id.gifView);
        Intent intent = getIntent();
        //  khởi tạo model phản ứng lấy dữ liệu từ intent từ trang khác
        PhanUngModel phanUngModel = (PhanUngModel) intent.getSerializableExtra("phanUngModel");
        // nếu có dữ liệu intent từ trang khác -> gán dữ liệu cho textView
        if (phanUngModel != null) {
            textView.setText(phanUngModel.getChatThamGia1() // chất tham gia 1
                    +" + "+
                    phanUngModel.getChatThamGia2() // chất tham gia 2
                    +" = "+
                    phanUngModel.getChatSanPham1() // chất sản phẩm 1
                    +" + "+
                    phanUngModel.getChatSanPham2()); // chất sản phẩm 2
            gifView.setImageResource(getImageId(this, phanUngModel.getHinhAnh()));
        }
        btnVoco.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                startActivity(new Intent(ChonPhanUng.this, GridViewChatVoco.class));
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                gifView.setImageDrawable(null);
            }
        });
        btnHuuco.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                startActivity(new Intent(ChonPhanUng.this, GridViewChatHuuco.class));
            }
        });
    }
    public static int getImageId(Context context, String imageName) {
        if (imageName.indexOf(".") > 0)
            imageName = imageName.substring(0, imageName.lastIndexOf("."));
        return context.getResources().getIdentifier("drawable/" + imageName, "png", context.getPackageName());
    }
}
