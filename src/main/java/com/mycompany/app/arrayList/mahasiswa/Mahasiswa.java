package com.mycompany.app.arrayList.mahasiswa;

public class Mahasiswa {

    private String NIM;
    private String Nama;
    private String Alamat;

    public Mahasiswa(String NIM, String Nama, String Alamat){
        this.NIM = NIM;
        this.Nama = Nama;
        this.Alamat = Alamat;
    }

    public String getNIM(){
        return NIM;
    }

    public String getNama(){
        return Nama;
    }

    public String getAlamat(){
        return Alamat;
    }
}
