package com.manikanta.corejava;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Manikanta Tummalapenta on 23 Jan 2020
 */
public class AnonymousClassExample {

    /*
    * Anonymous classes are generally not a good thing to create as you don't know the name of the class and can't reuse
    * Create only if you are sure that this class doesn't need to be used anywhere else
    * */

    private static void sort(Integer[] arr) {

        Comparator<Integer> comparator = new Comparator<Integer>() {
            /* Anonymous Class */
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };

        Arrays.sort(arr, comparator);
    }

    public static void main(String[] args) {
        Integer arr[] = {1, 3, 2, 5, 4};
        AnonymousClassExample.sort(arr);

        System.out.println(Arrays.toString(arr));

        Animal animal = new Animal() {
            /* Anonymous Class */
            @Override
            void sound() {
                System.out.println("Anonymous Sound!!");
            }
        };

        animal.sound();
    }
}

class Animal {
    void sound() {
        System.out.println("Animal Sound");
    }
}
