package org.sushobh;

import org.sushobh.Models.Person;

public class Main {

    public static void main(String[] args) {

        Person person = Meercat.createObject(Person.class);
        print("Hello");
    }


    static void print(String message){
        System.out.print(message);
    }
}
