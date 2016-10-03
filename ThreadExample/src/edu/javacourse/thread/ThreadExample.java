package edu.javacourse.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by anton on 10/3/16.
 */
public class ThreadExample
{
    public static final int COUNT = 10;

    public static void main(String[] args) {

// Способ, которым лучше не пользоваться
//        for(int i=0; i<COUNT; i++) {
//            MyThread mt = new MyThread();
//            mt.start();
//        }

// Способ получше, но не управляемый
//        for(int i=0; i<COUNT; i++) {
//            MyRunnable mt = new MyRunnable();
//            Thread t = new Thread(mt);
//            t.start();
//        }
//    }

        ExecutorService es = Executors.newFixedThreadPool(5);

// Хороший способ ззапускать неуправляемые потоки
//        for(int i=0; i<COUNT; i++) {
//            es.execute(new MyRunnable());
//        }

        callableExample(es);

        runnableExample(es);

        es.shutdown();
    }

    private static void callableExample(ExecutorService es) {
        List<Future<String>> tasks = new ArrayList<>();

        // Вариант запуска по одной задаче
        for(int i=0; i<COUNT; i++) {
            Future<String> submit = es.submit(new MyCallable());
            tasks.add(submit);
        }

        // Вариант запуска сразу много задач
//        List<MyCallable> calls = new ArrayList<>();
//        for(int i=0; i<COUNT; i++) {
//            calls.add(new MyCallable());
//        }
//        try {
//            tasks = es.invokeAll(calls);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        for(Future<String> f : tasks) {
            try {
                System.out.println(f.isDone());
                String s = f.get();
                System.out.println(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void runnableExample(ExecutorService es) {
        List<Future> runs = new ArrayList<>();
        for(int i=0; i<COUNT; i++) {
            Future submit = es.submit(new MyRunnable());
            runs.add(submit);
        }
        for(Future f : runs) {
            try {
                System.out.println(f.isDone());
                f.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class MyCallable implements Callable<String>
{

    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(1000 - Thread.currentThread().getId());
//            if(true) {
//                throw new RuntimeException("Hello " + Thread.currentThread().getId());
//            }
            return "Hello " + Thread.currentThread().getId();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}

class MyRunnable implements Runnable
{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
//            if(true) {
//                throw new RuntimeException();
//            }
            System.out.println("Hello " + Thread.currentThread().getId());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread
{
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Hello " + Thread.currentThread().getId());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
