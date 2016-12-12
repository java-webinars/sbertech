package ru.sbertech.ignite;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteMessaging;
import org.apache.ignite.Ignition;
import org.apache.ignite.lang.IgniteCallable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * Created by anton on 12/2/16.
 */
public class FirstApp
{
    public static void main(String[] args) {
        FirstApp fa = new FirstApp();
        fa.testIgniteCompute();
//        fa.testIgniteDataGrid();
//        testIgniteEvent();
    }

    private void testIgniteCompute() {
        Ignition.setClientMode(true);
        try (Ignite ignite = Ignition
                .start("/home/anton/java/apache-ignite-fabric-1.7.0-bin" +
                        "/examples/config/example-ignite.xml")) {
            Collection<IgniteCallable<Integer>> calls = new ArrayList<>();
            for (final String word : "Count characters using callable".split(" ")) {
                calls.add(word::length);
            }
            Collection<Integer> res = ignite.compute().call(calls);
//            ignite.compute().broadcast(()-> System.out.println("Hello Node:" + ignite.cluster().localNode().id()));
            int sum = res.stream().mapToInt(Integer::intValue).sum();
            System.out.println("testIgniteCompute ====================>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("Total number of characters is '" + sum + "'.");
            System.out.println("testIgniteCompute ====================>>>>>>>>>>>>>>>>>>>>>");
        }
    }

    private void testIgniteDataGrid() {
        Ignition.setClientMode(true);
        try (Ignite ignite = Ignition
                .start("/home/anton/java/apache-ignite-fabric-1.7.0-bin" +
//                        "/config/default-config.xml")) {
                        "/examples/config/example-ignite.xml")) {
            IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCacheName");

            for (int i = 0; i < 200; i++) {
                cache.put(i, Integer.toString(i));
            }

            System.out.println("testIgniteDataGrid ====================>>>>>>>>>>>>>>>>>>>>>");
            for (int i = 0; i < 200; i++) {
                System.out.println("Got [key=" + i + ", val=" + cache.get(i) + ']');
            }
            System.out.println("testIgniteDataGrid ====================>>>>>>>>>>>>>>>>>>>>>");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void testIgniteEvent() {
        Ignition.setClientMode(true);
        try (Ignite ignite = Ignition
                .start("/home/anton/java/apache-ignite-fabric-1.7.0-bin" +
                        "/examples/config/example-ignite.xml")) {
            IgniteMessaging rmtMsg = ignite.message(ignite.cluster().forRemotes());

// Add listener for unordered messages on all remote nodes.
            UUID topic = rmtMsg.remoteListen("MyOrderedTopic", (nodeId, msg) -> {
                System.out.println("Received ordered message [msg=" + msg + ", from=" + nodeId + ']');
                return true; // Return true to continue listening.
            });

// Send ordered messages to remote nodes.
            for (int i = 0; i < 10; i++) {
                rmtMsg.sendOrdered("MyOrderedTopic", Integer.toString(i*100), i);
            }

            try {
                Thread.sleep(5000);
                rmtMsg.stopRemoteListen(topic);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
