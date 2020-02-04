package com.mycompany.app.exercise;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Input length of number = ");

        int[] numbers = new int[in.nextInt()];

        for(int i = 0; i < numbers.length; i++){
            int number = i + 1;
            System.out.print("Input number - "+number+" :");
            numbers[i] = in.nextInt();
        }

        Exercise e = new Exercise();

        e.resultOne(numbers);

    }
}
