package com.sebastian_daschner.workshops;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

public class StringExposer {

    @Produces
    @Dependent
    public String exposeConfig() {
        System.out.println("StringExposer.exposeConfig");
        return "Hello world in dev";
    }

}