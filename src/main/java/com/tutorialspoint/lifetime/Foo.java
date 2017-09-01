package com.tutorialspoint.lifetime;

/**
 * Created by gucailiang on 2017/8/16.
 */

public class Foo {
    public void init() {
        // initialization logic
        System.out.println("init");
    }
    public void cleanup() {
        // destruction logic
        System.out.println("die");
    }
}