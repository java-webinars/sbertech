package ru.sbertech.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by anton on 9/12/16.
 */
public class Starter
{
    public static void main(String[] args) throws Exception {
        PasswordGenerator pg = buildGenerator();

        String generate = pg.generate();
        System.out.println(generate);

        Product p = new Product();
        p.setProductId(10L);
        testReflection(p);
    }

    private static PasswordGenerator buildGenerator() {
        try {
            Class c = Class.forName("ru.sbertech.reflection.GeneratorTwo");
            return (PasswordGenerator) c.newInstance();
        } catch(Exception ex) {
            return null;
        }
    }

    private static void testReflection(Object p) throws Exception {
        Class aClass = p.getClass();
        Field f = aClass.getDeclaredField("productId");
        f.setAccessible(true);
        Object o = f.get(p);
        System.out.println(o);
        f.set(p, 99L);
        System.out.println(f.get(p));

        Method m = aClass.getMethod("setProductId", new Class[] { Long.class });
        m.invoke(p, new Object[] { 124L });
        System.out.println(f.get(p));


    }
}
