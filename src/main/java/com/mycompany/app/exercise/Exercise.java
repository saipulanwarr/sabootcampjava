package com.mycompany.app.exercise;

import java.util.Arrays;
import java.util.Comparator;

public class Exercise {

    public void resultOne(int[] numbers){
        System.out.println("Min = "+getMinValue(numbers));
        System.out.println("Max = "+getMaxValue(numbers));
        System.out.println("AVG = "+getAverageValue(numbers));
        System.out.println("Sort = "+getSortValue(numbers));
    }

    private int getMaxValue(int[] array){
//        int maxValue = array[0];
//        for(int i = 1; i < array.length; i++){
//            if(array[i] > maxValue){
//                maxValue = array[i];
//            }
//        }
//        return maxValue;

        return Arrays.stream((Arrays.stream(array)
                .boxed().toArray(Integer[]::new)))
                .mapToInt(Integer::intValue).max().getAsInt();
    }

    private int getMinValue(int[] array){
//        int minValue = array[0];
//        for(int i = 1; i < array.length; i++){
//            if(array[i] < minValue){
//                minValue = array[i];
//            }
//        }
//
//        return minValue;

        return Arrays.stream((Arrays.stream(array)
                .boxed().toArray(Integer[]::new)))
                .mapToInt(Integer::intValue).min().getAsInt();
    }

    private int getAverageValue(int[] array){
//        int sum=0;
//
//        for(int i=0;i<array.length;i++){
//            sum=sum+array[i];
//        }
//        double avg=(1.0*sum)/array.length;

        double avg = Arrays.stream(array).average().getAsDouble();

        return (int) avg;
    }

    private String getSortValue(int[] array){
        int[] descArr = Arrays.stream(array)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        String result = "";

        for(int i = 0; i < descArr.length; i++){
            result = result + descArr[i] + ",";
        }

        return result;
    }
}
