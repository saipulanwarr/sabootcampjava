package com.mycompany.app.genericClass;

public class MaxiumTest {
    // determines the largest of three Comparable objects
    public static <T extends Comparable<T>> T maximum(T x, T y, T z){
        T max = x; // assume x is initialy the largest

        if(y.compareTo(max) > 0){
            max = y;
        }

        if(z.compareTo(max) > 0){
            max = z;
        }

        return max;
    }

    public static void main(String args[]){
        System.out.printf("Max of %d, %d and %d is %d\n\n",
                3, 4, 5, maximum(3, 4, 5));

        System.out.printf("Max of %.1g,%.1g and %.1g is %.1g\n\n",
                6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ));

        System.out.printf("Max of %s, %s and %s is %s\n","pear",
                "apple", "orange", maximum("pear", "apple", "orange"));


    }
}