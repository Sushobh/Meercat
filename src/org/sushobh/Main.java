package org.sushobh;

import org.sushobh.Annotation.AddRandomStuff;
import org.sushobh.Models.Person;

import java.util.List;

public class Main {

    @AddRandomStuff
    Person person;


    public static void main(String[] args) {
       Example example = new Example();
    }



    public static class Example{
        @AddRandomStuff
        Person person;

        public Example() {
            Meercat.load(this);
        }
    }

    static void print(String message){
        System.out.print(message);
    }
}
