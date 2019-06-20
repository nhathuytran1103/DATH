package com.example.nguyenphuocphu.ph;

public class ImageViewChat {
    private String tenChat;
    private int hinhChatl;

    public ImageViewChat(String tenchat, int hinhchat) {
        this.tenChat = tenchat;
        this.hinhChatl = hinhchat;
    }

    public ImageViewChat(int idchat, String tenchat, String string) {
    }


    public String getTenChat() {
        return tenChat;
    }

    public void setTenChat(String tenChat) {
        this.tenChat = tenChat;
    }

    public int getHinhChatl() {
        return hinhChatl;
    }

    public void setHinhChatl(int hinhChatl) {
        this.hinhChatl = hinhChatl;
    }
}
