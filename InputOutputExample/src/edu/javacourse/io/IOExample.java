package edu.javacourse.io;

import java.io.*;
import java.net.Socket;

public class IOExample
{
    public static void main(String[] args) throws IOException {
//        method1();
//        method2();
//        method3();
        method4();
    }

    private static void method1() throws IOException {
        InputStream is = new FileInputStream("test.txt");
        OutputStream os = new FileOutputStream("test_out1.txt", false);

        int b = is.read();
        while(b != -1) {
            os.write(b);
            b = is.read();
        }

        is.close();
        os.close();
    }

    private static void method2() {
       try(InputStream is = new FileInputStream("test.txt");
        OutputStream os = new FileOutputStream("test_out2.txt", false)) {

           byte[] buffer = new byte[10];

           int c = is.read(buffer);
           while(c != -1) {
               os.write(buffer, 0, c);
               c = is.read(buffer);
           }

       } catch(Exception ex) {
           ex.printStackTrace();
       }
    }

    public static void method3() throws IOException {
        Reader r = new FileReader("test.txt");
        Writer w = new FileWriter("test_out3.txt");

        char[] buffer = new char[10];
        int c = r.read(buffer);
        while(c != -1) {
            w.write(buffer, 0, c);
            c = r.read(buffer);
        }

        r.close();
        w.close();
    }

    public static void method4() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        String line = br.readLine();
        while(line != null) {
            System.out.println(line);
            line = br.readLine();
        }
        br.close();
    }
}
