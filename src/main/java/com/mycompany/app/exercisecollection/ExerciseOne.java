package com.mycompany.app.exercisecollection;

import java.util.ArrayList;
import java.util.List;

public class ExerciseOne {

    private String nameDuplicate;

   public ExerciseOne(){
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

       String result = convertToString(list);

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
       String result = convertToString(newList);

       return result;
   }

   private String getNameDuplicate(List<String> list){

       String result = convertToString(list);
       setNameDuplicate(result);

       return result;
   }

   private String setNameDuplicate(String name){
       return this.nameDuplicate = name;
   }

   private String convertToString(List<String> list){
       String idList = list.toString();
       String csv = idList.substring(1, idList.length() - 1).replace(", ", ",");

       return csv;
   }

   public static void main(String[] args){
       new ExerciseOne();
    }
}
