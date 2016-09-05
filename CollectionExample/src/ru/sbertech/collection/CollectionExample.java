package ru.sbertech.collection;

import java.util.*;

/**
 * Created by anton on 9/5/16.
 */
public class CollectionExample
{
    public static void main(String[] args) {

//        List list = new ArrayList();
        List list = new Vector();

        list.add("Name 1");
        list.add("Name 2");
        list.add("Name 3");
        list.add("Name 4");
        list.add(1L);
        list.add(new Date());

        System.out.println("Size before:" + list.size());
        list.remove("Name 1");
        System.out.println("size after:" + list.size());

        String obj1 = new String("12345");
        // При изменении строки хеш-коды стану разными
        String obj2 = new String("12345");

        if(obj1.equals(obj2)) {
            System.out.println("OK");
        }

        System.out.println("HashCode:" + obj1.hashCode() + ":" + obj2.hashCode());

        // Способы "пройти" по списку
        // Через итератор
        Iterator it = list.iterator();
        while(it.hasNext()) {
            Object o = it.next();
            System.out.println(o + " Class:" + o.getClass().getSimpleName());
        }
        // И еще через итератор
        for(Iterator it1 = list.iterator(); it1.hasNext(); ) {
            Object o = it1.next();
            System.out.println(o);
        }
        // forEach
        for(Object o : list) {
            System.out.println(o);
        }

        // У списка можно спросить элемент по номеру/индексу
        list.get(1);
        // В список можно вставить элемент на конкретную позицию
        list.add(0, "Name 0");
        // В список можно вставить дубли
        list.add(0, "Name 0");


        Set set = new HashSet();
        set.add("Name 1");
        set.add("Name 1");
        set.add("Name 1");
        set.add("Name 2");
        System.out.println("Set size:" + set.size());


        Map map = new HashMap();
        map.put("1", "Name 1");
        map.put("2", "Name 2");
        map.put("3", "Name 3");
        map.put("1", "Name 4");

        for(Object key : map.keySet()) {
            Object value = map.get(key);
            System.out.println("Key:" + key + ", Value:" + value);
        }

        for(Object value : map.values()) {
            System.out.println("Value:" + value);
        }

    }
}
