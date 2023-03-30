package com.jerikthedog.unitvsintegrationtest.resources;

public class HelloController {

    public String hello(String name) {
        return String.format("Hello, %s", name);
    }

}
