package com.mycompany.app.model;

public class Lecturer {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void teach(String... courseName){
        for(int i = 0; i < courseName.length; i++){
            if(courseName[i] == "Java"){
                setName("Dr. Java S.KOM");
            }else if(courseName[i] == "React"){
                setName("Dr. React S.KOM");
            }else if(courseName[i] == "Node JS"){
                setName("Dr. Node JS S.KOM");
            }else{
                setName("");
            }

            System.out.println("Lecturer : " + getName());
        }
    }
}
