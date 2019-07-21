package com.hhli.springbootstduy.io;

import lombok.Data;

import java.io.*;

/**
 * @author 李辉辉
 * @date 2019/7/21 19:32
 * @description
 */
@Data
public class TestSerializeSon extends TestSerializeFather implements Serializable{
    private double weight;

    public TestSerializeSon(int age, double weight) throws IOException {
        super(age);
        this.weight = weight;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.data"));
        out.writeObject(new TestSerializeSon(10, 70.0));

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.data"));
        TestSerializeSon son = (TestSerializeSon)in.readObject();
        System.out.println(son);
    }
}
