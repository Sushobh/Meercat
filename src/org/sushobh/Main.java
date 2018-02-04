package org.sushobh;

import org.sushobh.Models.Person;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Person> list = Meercat.createList(Person.class,5);
        print("Hello");
    }


    static void print(String message){
        System.out.print(message);
    }
}
