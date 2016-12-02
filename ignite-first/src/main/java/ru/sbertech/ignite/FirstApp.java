package ru.sbertech.ignite;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.lang.IgniteCallable;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by anton on 12/2/16.
 */
public class FirstApp
{
    public static void main(String[] args) {
        FirstApp fa = new FirstApp();
        fa.testIgniteCompute();
        fa.testIgniteDataGrid();
    }

    private void testIgniteCompute() {
        try (Ignite ignite = Ignition
                .start("/home/anton/java/apache-ignite-fabric-1.7.0-bin" +
                        "/examples/config/example-ignite.xml")) {
            Collection<IgniteCallable<Integer>> calls = new ArrayList<>();
            for (final String word : "Count characters using callable".split(" ")) {
                calls.add(word::length);
            }
            Collection<Integer> res = ignite.compute().call(calls);
            int sum = res.stream().mapToInt(Integer::intValue).sum();
            System.out.println("testIgniteCompute ====================>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("Total number of characters is '" + sum + "'.");
            System.out.println("testIgniteCompute ====================>>>>>>>>>>>>>>>>>>>>>");
        }
    }

    private void testIgniteDataGrid() {
        try (Ignite ignite = Ignition
                .start("/home/anton/java/apache-ignite-fabric-1.7.0-bin" +
                        "/examples/config/example-ignite.xml")) {
            IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCacheName");

            for (int i = 0; i < 10; i++) {
                cache.put(i, Integer.toString(i));
            }

            System.out.println("testIgniteDataGrid ====================>>>>>>>>>>>>>>>>>>>>>");
            for (int i = 0; i < 10; i++) {
                System.out.println("Got [key=" + i + ", val=" + cache.get(i) + ']');
            }
            System.out.println("testIgniteDataGrid ====================>>>>>>>>>>>>>>>>>>>>>");
        }
    }
}
