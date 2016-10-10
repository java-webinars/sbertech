package edu.javacourse.serial;

import java.io.*;

public class Starter
{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        {
            TestObject to = new TestObject();
            to.setName("12345");
            to.setField(99);
            InnerObject io = new InnerObject();
            io.setName("67890");
            to.setInner(io);
            saveObject(to);
        }
        {
            TestObject to = loadObject();
            System.out.println(to.getName());
            System.out.println(to.getField());
            System.out.println(to.getInner().getName());
        }
    }

    public static void saveObject(TestObject test) throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("object.bin"));
        os.writeObject(test);
        os.close();
    }

    public static TestObject loadObject() throws IOException, ClassNotFoundException {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("object.bin"));
        TestObject to = (TestObject)is.readObject();
        is.close();
        return to;
    }
}
