package edu.javacourse.thread;

/**
 * Created by anton on 10/3/16.
 */
public class CounterThread implements Runnable
{
    private Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i=0; i<10000; i++) {
            counter.increaseCounter();
        }
    }
}
