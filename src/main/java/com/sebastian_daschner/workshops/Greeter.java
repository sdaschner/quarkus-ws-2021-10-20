package com.sebastian_daschner.workshops;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Greeter {

    public String hello() {
        return "Hello World.";
    }
}
