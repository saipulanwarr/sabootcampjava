package com.mycompany.app.arrayList.mahasiswa;

public class MainMahasiswa {
    public static void main(String[] args){
        InputDataMahasiswa input = new InputDataMahasiswa();
        input.insertData("080901", "Saipul Anwar", "Bogor");
        input.insertData("080902", "Rizky", "Bogor");
        input.insertData("080903", "Fakhri", "Bogor");

        System.out.println("Data Mahasiswa dalam ArrayList:");
        System.out.println("------------------");
        for(Mahasiswa mhs : input.getAll()){
            System.out.println("NIM: " + mhs.getNIM());
            System.out.println("Nama: " + mhs.getNama());
            System.out.println("Alamat: " + mhs.getAlamat());
            System.out.println("-----------------------------");
        }
    }
}
