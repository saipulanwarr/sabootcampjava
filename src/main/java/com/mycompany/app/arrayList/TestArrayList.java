package com.mycompany.app.arrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestArrayList {

    public static void main(String[] args){

        List<String> list = new ArrayList<>();

        list.add("RabbitMQ");
        list.add("Kafka");
        list.add(0, "ActiveMQ"); // insert to index 0

        List<String> newList = new ArrayList<>();
        newList.add("Java");
        newList.add("Golang");
        list.addAll(newList);
        list.add(0, "Java");

//        for(String s : list){
//            System.out.printf("%s \n", s);
//        }

        //using iterator
        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.printf("%s \n", it.next());
        }
    }
}
