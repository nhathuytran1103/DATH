package com.example.nguyenphuocphu.ph;

import java.io.Serializable;

public class PhanUngModel implements Serializable {
    private int idPhanUng;
    private String chatThamGia1;
    private String chatThamGia2;
    private String chatSanPham1;
    private String chatSanPham2;
    private int loaiPhanUng;
    private String hinhAnh;

    public PhanUngModel() {

    }

    public PhanUngModel(int idPhanUng, String chatThamGia1, String chatThamGia2, String chatSanPham1, String chatSanPham2, int loaiPhanUng, String hinhAnh) {
        this.idPhanUng = idPhanUng;
        this.chatThamGia1 = chatThamGia1;
        this.chatThamGia2 = chatThamGia2;
        this.chatSanPham1 = chatSanPham1;
        this.chatSanPham2 = chatSanPham2;
        this.loaiPhanUng = loaiPhanUng;
        this.hinhAnh = hinhAnh;
    }

    public int getIdPhanUng() {
        return idPhanUng;
    }

    public void setIdPhanUng(int idPhanUng) {
        this.idPhanUng = idPhanUng;
    }

    public String getChatThamGia1() {
        return chatThamGia1;
    }

    public void setChatThamGia1(String chatThamGia1) {
        this.chatThamGia1 = chatThamGia1;
    }

    public String getChatThamGia2() {
        return chatThamGia2;
    }

    public void setChatThamGia2(String chatThamGia2) {
        this.chatThamGia2 = chatThamGia2;
    }

    public String getChatSanPham1() {
        return chatSanPham1;
    }

    public void setChatSanPham1(String chatSanPham1) {
        this.chatSanPham1 = chatSanPham1;
    }

    public String getChatSanPham2() {
        return chatSanPham2;
    }

    public void setChatSanPham2(String chatSanPham2) {
        this.chatSanPham2 = chatSanPham2;
    }

    public int getLoaiPhanUng() {
        return loaiPhanUng;
    }

    public void setLoaiPhanUng(int loaiPhanUng) {
        this.loaiPhanUng = loaiPhanUng;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
