package com.mycompany.app;

import com.mycompany.app.model.Lecturer;
import com.mycompany.app.model.Person;
import com.mycompany.app.model.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public App(){
        Person danang = new Person("Danang", "Prakoso");
        Person budi = new Person("Budi", "Setiawan");

        danang.showAppVersion();
        danang.showFullName();

        budi.showAppVersion();
        budi.showFullName();

        Student student = new Student("Kuhaku", "age", "ST");
        Lecturer lecturer = new Lecturer();

        student.learn("Node JS", "Java", "");
        lecturer.teach("Node JS", "Java", "");

        System.out.println("Hello " + student.getFullName());
        System.out.println("Total Learn " + student.getLevel());
    }

    public static void main( String[] args )
    {
        new App();
    }
}
