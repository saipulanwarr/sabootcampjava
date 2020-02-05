package com.mycompany.app.arrayList.mahasiswa;

import java.util.ArrayList;

public class InputDataMahasiswa {

    //variable listMahasiswa bertipe ArrayList
    ArrayList<Mahasiswa> listMahasiswa;

    //Constructor
    public InputDataMahasiswa(){
        listMahasiswa = new ArrayList<>();
    }

    public void insertData(String NIM, String Nama, String Alamat){
        Mahasiswa mhs = new Mahasiswa(NIM, Nama, Alamat);
        listMahasiswa.add(mhs);
    }

    public ArrayList<Mahasiswa> getAll(){
        return listMahasiswa;
    }

    public void deleteData(int index){
        listMahasiswa.remove(index);
    }
}
