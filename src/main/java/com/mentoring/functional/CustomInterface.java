package com.mentoring.functional;

/**
 * Created by Aliaksandr_Liahushau on 6/5/2017.
 */
@FunctionalInterface
public interface CustomInterface<T> {
    T make();

    default void sayDefaultHello() {
        System.out.println("Hello, it's default method");
    }

    static void sayStaticHello() {
        System.out.println("Hello, it's static method");
    }
}
