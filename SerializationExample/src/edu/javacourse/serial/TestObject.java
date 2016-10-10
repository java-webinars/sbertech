package edu.javacourse.serial;

import java.io.Serializable;

/**
 * Created by anton on 10/10/16.
 */
public class TestObject implements Serializable
{
    private InnerObject inner;
    private String name;
    private transient int field;

    public InnerObject getInner() {
        return inner;
    }

    public void setInner(InnerObject inner) {
        this.inner = inner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }
}
