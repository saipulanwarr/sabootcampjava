package com.mycompany.app.exercisecollection;

import java.util.ArrayList;
import java.util.List;

public class ExerciseOne {

    private String nameDuplicate;

   public ExerciseOne(){
       String result = "";
       List<String> list = new ArrayList<>();
       list.add("Roni");
       list.add("Dana");
       list.add("Dini");
       list.add("Roni");
       list.add("Romi");
       list.add("Dana");
       list.add("Fakri");
       list.add("Fakri");
       list.add("Exit");

       for(String s : list){
           result = result + s + ",";
       }

       if(list.contains("Exit")){
           System.out.print("Input set of String : " + result + "\n");
           System.out.println("Output : ");
           System.out.println("Data = " + removeDuplicate(list));
           System.out.println("Duplicate = " + this.nameDuplicate);
       }
   }

   private String removeDuplicate(List<String> list){
       List<String> newList = new ArrayList<>();
       List<String> duplicateList = new ArrayList<>();

       for(String s : list){
           if(!newList.contains(s)){
               newList.add(s);
           }else{
                duplicateList.add(s);
           }
       }

       getNameDuplicate(duplicateList);

       String result = "";

       for(String e : newList){
            result = result + e + ",";
       }

       return result;
   }

   private String getNameDuplicate(List<String> list){

       String result = "";

       for(String s : list){
           result = result + s + ",";
       }

       setNameDuplicate(result);

       return result;
   }

   private String setNameDuplicate(String name){
       return this.nameDuplicate = name;
   }

   public static void main(String[] args){
       new ExerciseOne();
    }
}
