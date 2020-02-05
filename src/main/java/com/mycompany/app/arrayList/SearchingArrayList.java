package com.mycompany.app.arrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchingArrayList {

    public static void main(String[] args){

        //Buat Objek ArrayList dan set datanya menjadi integer
        ArrayList<Integer> arr_data = new ArrayList<>();

        //Buat Objek Scanner
        Scanner scan = new Scanner(System.in);

        System.out.println("Input jumlah data: ");
        int jumlahData = scan.nextInt();
        System.out.println("\nInput nilai Data");

        for(int a = 0; a < jumlahData; a++){
            System.out.println("Data ke-"+(a+1)+" : ");
            int value = scan.nextInt();

            arr_data.add(value);
        }

        System.out.println("\nData yang ada di dalam arrayList");
        int posisi = 1;
        for(Integer i : arr_data){
            System.out.println("-->Data ke-"+posisi+" : "+i);
            posisi++;
        }

        System.out.print("\nInput Data yang akan di cari : ");
        int cari = scan.nextInt();

        //Proses Pencarian di dalam arrayList
        int interasi = 1;
        boolean temu = false;
        for(Integer i : arr_data){
            if(i == cari){
                System.out.println("Iterasi ke-"+interasi);
                System.out.println(i+" == "+cari);
                temu = true;
                break;
            }else{
                System.out.println("Iterasi ke-"+interasi);
                System.out.println(i+" != "+cari);
            }
            interasi++;
            System.out.println();
        }

        if(temu == true){
            System.out.println("\nData ditemukan pada iterasi ke-"+interasi);
        }else{
            System.out.println("\nData tidak Ditemukan");
        }
    }
}
