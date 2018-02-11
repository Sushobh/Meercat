# Meercat

This is an ongoing project where i am trying to create a runtime random object generator. After facing a lot of problems while unit testing
presenters/view models/activities in Android because of lack of access to data , i decided to create a library which will create random data
with a single line of code. Currently the project creates random objects and lists, i intend to continue to add a lot of other features which 
can make testing easier. The project uses a combination of **annotations** and java **reflection** to generate random data.         

# Progress

This is a snippet of code which demonstrates how this library can be used. 
You need to annotate fields which are to be filled with random data.

```java
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


```
