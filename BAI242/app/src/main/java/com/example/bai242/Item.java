package com.example.bai242;

public class Item {

    private String masp;
    private String tensp;

    private String gia;

    public Item(String masp, String tensp, String gia) {
        this.masp = masp;
        this.tensp = tensp;
        this.gia  = gia;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
