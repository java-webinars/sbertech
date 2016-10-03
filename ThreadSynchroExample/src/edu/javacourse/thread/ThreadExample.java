package edu.javacourse.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by anton on 10/3/16.
 */
public class ThreadExample
{
    public static final int COUNT = 100;

    public static void main(String[] args) throws Exception {
        Counter c = new Counter();

        ExecutorService es = Executors.newFixedThreadPool(COUNT);
        List<Future> tasks = new ArrayList<>();
        for(int i=0; i<COUNT; i++) {
            CounterThread ct = new CounterThread(c);
            Future<?> s = es.submit(ct);
            tasks.add(s);
        }
        for(Future f : tasks) {
            f.get();
        }

        es.shutdown();
        System.out.println(c.getCounter());
    }
}
