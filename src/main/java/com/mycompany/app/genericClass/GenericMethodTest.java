package com.mycompany.app.genericClass;

public class GenericMethodTest {

    // generic method printArray
    public static < E > void printArray( E[] inputArray){
        //Display array elements
        for(E element : inputArray){
            System.out.printf("%s ", element);
        }

        System.out.println();
    }

    public static void main(String args[]){
        //Create arrays of integer, Double and Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        printArray(intArray);
        printArray(doubleArray);
        printArray(charArray);
    }

}
