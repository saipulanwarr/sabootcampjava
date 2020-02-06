package com.mycompany.app.arrayList;

import com.mycompany.app.model.Person;

import java.util.*;

public class Sorter implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int cf = o1.getFirstName().compareTo(o2.getFirstName());
        if(cf == 0){
            return o2.getLastName().compareTo(o1.getLastName());
        }

        return cf;
    }

    public static void main(String[] args){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Mattew", "Bush"));
        personList.add(new Person("Justin", "Graham"));
        personList.add(new Person("Glenn", "Tyler"));
        personList.add(new Person("Jarrod", "Mc"));
        personList.add(new Person("Mattew", "Cachil"));

        Collections.sort(personList, new Sorter());

        Set<String> set = new HashSet<>();
        set.add("Java");
        set.add("Java");
        set.add(null);
        set.add("Golang");

        for(String s : set){
            System.out.println(s);
        }

        Set<String> setNew = new HashSet<>();
        setNew.add("Javascript");
        setNew.add("VBScript");
        set.addAll(setNew);

        System.out.printf("\n");

        for(String s : setNew){
            System.out.println(setNew);
        }

        System.out.println(set.contains(null)); //return true or false
        System.out.printf("\n");

        Set<String> contains = new HashSet<>();
        contains.add("Java");
        contains.add(null);
        System.out.println(set.containsAll(contains));
        System.out.printf("\n");

        Map<String, Integer> grades = new HashMap<>();
        grades.put("Jaja", 100);
        grades.put("Lukas", 90);
        grades.put("Sinta", 75);
        grades.put("Dede", 95);

        Integer val = grades.get("Jaja");
        System.out.println(val);

        for(String key : grades.keySet()){
            System.out.printf("%s : %s \n", key, grades.get(key));
        }

        System.out.printf("\n");

        grades.remove("Jaja");
        grades.remove("Jaja", 100);
//        grades.clear(); remove all

        grades.containsKey("Dede");
        grades.containsValue(50);

        for(Map.Entry<String, Integer> entry : grades.entrySet()){
            System.out.printf("%s : %s \n", entry.getKey(), entry.getValue());
        }

    }
}
