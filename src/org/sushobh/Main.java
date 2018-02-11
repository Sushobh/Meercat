package org.sushobh;

import org.sushobh.Annotation.AddRandomStuff;
import org.sushobh.Models.Person;

import java.util.List;

public class Main {


    public static void main(String[] args) {
       Example example = new Example();
       print("Hello world!");
    }

    public static class Example{
        @AddRandomStuff
        Person person;
        @AddRandomStuff(size = 40)
        List<Person> people;

        public Example() {
            Meercat.load(this);
        }
    }

    static void print(String message){
        System.out.print(message);
    }
}
