package com.lappungdev.telepondaruratlampung.model;

public class Telepon {

    private String nama;
    private String telepon;

    public Telepon(){

    }

    public Telepon(String nama, String telepon) {
        this.setNama(nama);
        this.setTelepon(telepon);
    }


    public String getNama() {
        return nama;
    }

    private void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelepon() {
        return telepon;
    }

    private void setTelepon(String telepon) {
        this.telepon = telepon;
    }
}
