package ru.sbertech.array;

/**
 * Created by anton on 9/5/16.
 */
public class ArrayExample
{

    public static final int COUNT = 100;

    public static void main(String[] args) {
        String[] str;
        // Создать массив из 5 элементов
        str = new String[5];

//        str[0] = "12345";
//        System.out.println(str[0]);

        for(int i=0; i<str.length; i++) {
            str[i] = "Line:" + i;
        }

        System.out.println("For version 1 =====================");
        for(int i=0; i<str.length; i++) {
            System.out.println(str[i]);
        }

        System.out.println("For version 2 =====================");
        for(String s : str) {
            System.out.println(s);
        }

        // Так НЕ НАДО ДЕЛАТЬ
        String g = "0";
        for(int i = 1; i< COUNT; i++) {
            g += "," + i;
            System.out.println(g);
        }

        // Делать НАДО ТАК
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i< COUNT; i++) {
            sb.append(",").append(i);
        }

        // Делать так для МНОГОПОТОЧНОСТИ
        StringBuffer sb1 = new StringBuffer();
        for(int i = 1; i< COUNT; i++) {
            sb1.append(",").append(i);
        }

    }

}
