package org.sushobh;

import org.sushobh.Annotation.AddRandomStuff;
import org.sushobh.Models.Person;

import java.io.UTFDataFormatException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Meercat {


    private static <T> T createObject(Class<T> t){
        try {
            T object =  t.newInstance();
            return writeRandomData(object);
        } catch (InstantiationException | IllegalAccessException e) {
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


    private static <T> List<T> createList(Class<T> classToBeCreated, int size) {
        List<T> listToReturn = new ArrayList<>(size);
        for(int i = 0;i<size;i++){
            listToReturn.add(createObject(classToBeCreated));
        }
        return listToReturn;
    }


    public static void load(Object objectToBeLoaded){
        Class classToBeLoaded = objectToBeLoaded.getClass();
        Field[] fields = classToBeLoaded.getDeclaredFields();
        for(Field field : fields){

            if(field.getDeclaredAnnotation(AddRandomStuff.class)!=null){
                try {
                    fillField(field,objectToBeLoaded);
                } catch (IllegalAccessException e ) {
                    e.printStackTrace();
                }
                catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
            }

        }
        Main.print("Hello");
    }


    private static void fillField(Field field,Object objectToBeLoaded) throws IllegalAccessException, ClassNotFoundException {
        field.setAccessible(true);
        if(List.class.isAssignableFrom(field.getType())){
            AddRandomStuff addRandomStuff = field.getAnnotation(AddRandomStuff.class);
            ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
            Type[] types = parameterizedType.getActualTypeArguments();
            field.set(objectToBeLoaded,createList(Class.forName(types[0].getTypeName()),addRandomStuff.size()));
        }
        else {
            field.set(objectToBeLoaded,createObject(field.getType()));
        }
    }

}
