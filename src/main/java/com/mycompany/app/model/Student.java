package com.mycompany.app.model;

public class Student extends Person{
    private String nis;
    private String title;
    private String newTitle = "";
    private int level;

    public Student(String firstName, String lastName, String title) {
        super(firstName, lastName);
        this.title = title;
    }

    public void learn(String courseName){
        level++;
        System.out.println("Learn : " + courseName);
    }

    @Override
    public String getFullName(){

        if(level > 500){
            setNewTitle("Prof");
        }

        return newTitle + " " + super.getFullName() + " " + title;
    }

    public void learn(String courseName, int sks){
        if(courseName == null){
            return;
        }

        level += sks;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    private void setNewTitle(String newTitle){
        this.newTitle = newTitle;
    }

    public int getLevel() {
        return level;
    }
}
