package org.sushobh;

import org.sushobh.Models.Person;

import java.lang.reflect.Field;
import java.util.Random;

public class Meercat {


    public static <T> T createObject(Class<T> t){
        try {
            T object =  t.newInstance();
            return writeRandomData(object);
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }

    }

    private static <T> T writeRandomData(T object) throws IllegalAccessException {
        Field[] arr = object.getClass().getDeclaredFields();
        for(int i = 0;i<arr.length;i++){
            Field field = arr[i];
            field.setAccessible(true);
            if(field.getType() == int.class || field.getType() == long.class){
                field.set(object,getRandomInt(field));
            }
            if(field.getType() == String.class){
                field.set(object,getRandomString(field));
            }
            if(field.getType() == double.class){
                field.set(object,getRandomDouble(field));
            }
            if(field.getType() == boolean.class){

                field.set(object,getRandomBoolean(field));
            }

        }
        return object;
    }

    private static boolean getRandomBoolean(Field field) {
        Random r = new Random();
        return r.nextBoolean();
    }

    private static double getRandomDouble(Field field) {
        Random r = new Random();
        return 1000 + (2000 - 1000) * r.nextDouble();
    }

    private static String getRandomString(Field field) {
        return "Sushobh Nadiger";
    }

    private static int getRandomInt(Field field) {
        Random r = new Random();
        return 1000 + (2000 - 1000) * r.nextInt();
    }


}
