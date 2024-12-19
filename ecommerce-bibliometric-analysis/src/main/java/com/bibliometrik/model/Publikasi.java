package com.bibliometrik.model;

public class Publikasi {
    private int id;
    private String judul;
    private String penulis;
    private String terbitTanggal;
    private double harga;
    private int stok;

    public Publikasi(int id, String judul, String penulis, String terbitTanggal, double harga, int stok) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.terbitTanggal = terbitTanggal;
        this.harga = harga;
        this.stok = stok;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getTerbitTanggal() {
        return terbitTanggal;
    }

    public void setTerbitTanggal(String terbitTanggal) {
        this.terbitTanggal = terbitTanggal;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    @Override
    public String toString() {
        return "Publikasi{" +
                "id=" + id +
                ", judul='" + judul + '\'' +
                ", penulis='" + penulis + '\'' +
                ", terbitTanggal='" + terbitTanggal + '\'' +
                ", harga=" + harga +
                ", stok=" + stok +
                '}';
    }
}