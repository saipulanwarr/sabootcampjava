package com.mycompany.app.model;

public class Person {

    public static final String _VERSION = "1.0.1";
    private String firstName;
    private String lastName;
    private double weight;
    private double height;
    private double bmi;
    private String bmiDescription;

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void showAppVersion(){
        System.out.println(_VERSION);
    }

    public void showFullName(){
        System.out.println(this.firstName + " " + this.lastName);
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }
}
