package com.example.nguyenphuocphu.ph;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ImageChatAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ImageViewChat> imageViewChatList;

    public ImageChatAdapter(Context context, int layout, List<ImageViewChat> imageViewChatList) {
        this.context = context;
        this.layout = layout;
        this.imageViewChatList = imageViewChatList;
    }


    @Override
    public int getCount() {
        return imageViewChatList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            viewHolder = new ViewHolder();
            // ánh xạ view
            viewHolder.textView = (TextView) convertView.findViewById(R.id.TextViewChat);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.ImageViewChat);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        Context c = context.getApplicationContext();
        // gán giá trị
        ImageViewChat imageViewChat = imageViewChatList.get(position);
        viewHolder.textView.setText(imageViewChat.getTenChat());
        viewHolder.imageView.setImageResource(getImageId(c, imageViewChat.getHinhChat()));

        return convertView;
    }
    public static int getImageId(Context context, String imageName) {
        if (imageName.indexOf(".") > 0)
            imageName = imageName.substring(0, imageName.lastIndexOf("."));
        return context.getResources().getIdentifier("drawable/" + imageName, "png", context.getPackageName());
    }
}
