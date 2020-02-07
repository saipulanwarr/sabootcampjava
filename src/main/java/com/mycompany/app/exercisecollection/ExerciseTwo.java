package com.mycompany.app.exercisecollection;

import java.util.*;

public class ExerciseTwo {

    public ExerciseTwo(){
        Map<String, Integer> price = new HashMap<>();
        price.put("Node JS", 20000);
        price.put("Java Fundamental", 25000);
        price.put("Database", 15000);
        price.put("Exit", 0);

        System.out.println("Input : ");

        for(String key : price.keySet()){
            if(!key.contains("Exit")){
                System.out.printf("%s : %s \n", key, price.get(key));
            }
        }

        System.out.println("\nOutput: ");

        if(price.containsKey("Exit")){
            int maxValueInMap = (Collections.max(price.values()));
            for(Map.Entry<String, Integer> entry : price.entrySet()){
                if(entry.getKey() != "Exit"){
                    System.out.printf("%s - %s \n", entry.getKey(), entry.getValue());

                    if(entry.getValue() == maxValueInMap){
                        System.out.println("Most Expensive = " + entry.getKey()+ " " + entry.getValue());
                    }
                }
            }

            price.remove("Exit", 0);
            Integer averagePrice = calculateAverage(price.values());

            System.out.println("Average Price = " + averagePrice);
        }
    }

    private Integer calculateAverage(Collection<Integer> values){
        Integer sum = 0;
        if(!values.isEmpty()){
            for(Integer price : values){
                sum += price;
            }

            return sum / values.size();
        }

        return sum;
    }

    public static void main(String[] args){
        new ExerciseTwo();
    }
}
