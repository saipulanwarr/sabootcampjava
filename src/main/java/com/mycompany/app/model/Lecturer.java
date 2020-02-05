package com.mycompany.app.model;

public class Lecturer {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void teach(String courseName){
        if(courseName == "Java"){
            setName("Java");
        }else if(courseName == "React"){
            setName("React");
        }else if(courseName == "Node JS"){
            setName("Node");
        }else{
            setName("");
        }

        System.out.println("Lecturer : " + getName());
    }
}
