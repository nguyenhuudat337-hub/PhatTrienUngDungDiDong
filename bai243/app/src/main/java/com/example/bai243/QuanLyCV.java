package com.example.bai243;

public class QuanLyCV {
    private String congViec;
    private String noiDung;
    private String ngayHT;
    private String gioHT;

    public QuanLyCV(String congViec, String noiDung, String ngayHT, String gioHT) {
        this.congViec = congViec;
        this.noiDung = noiDung;
        this.ngayHT = ngayHT;
        this.gioHT = gioHT;
    }

    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNgayHT() {
        return ngayHT;
    }

    public void setNgayHT(String ngayHT) {
        this.ngayHT = ngayHT;
    }

    public String getGioHT() {
        return gioHT;
    }

    public void setGioHT(String gioHT) {
        this.gioHT = gioHT;
    }
}
