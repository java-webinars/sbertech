package edu.javacourse.serial;

import java.io.Serializable;

public class InnerObject implements Serializable
{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
