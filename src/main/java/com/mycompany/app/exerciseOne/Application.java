package com.mycompany.app.exerciseOne;

import java.util.Scanner;

public class Application {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Input the sentence: ");

        ExerciseOne exercise = new ExerciseOne();

        exercise.resultReverse(in.nextLine());
    }
}
