package com.example.nguyenphuocphu.ph;

public class ImageViewChat {
    private String idChat;
    private String tenChat;
    private String hinhChat;

    public ImageViewChat(String idChat, String tenChat, String hinhChat) {
        this.idChat = idChat;
        this.tenChat = tenChat;
        this.hinhChat = hinhChat;
    }

    public String getIdChat() {
        return idChat;
    }

    public void setIdChat(String idChat) {
        this.idChat = idChat;
    }

    public String getTenChat() {
        return tenChat;
    }

    public void setTenChat(String tenChat) {
        this.tenChat = tenChat;
    }

    public String getHinhChat() {
        return hinhChat;
    }

    public void setHinhChat(String hinhChat) {
        this.hinhChat = hinhChat;
    }
}
