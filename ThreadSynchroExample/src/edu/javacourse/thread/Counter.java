package edu.javacourse.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anton on 10/3/16.
 */
public class Counter
{
    private List<Integer> counter = new ArrayList<>();

    public synchronized void increaseCounter() {
        counter.add(0);
    }

    public synchronized long getCounter() {
        return counter.size();
    }
}
