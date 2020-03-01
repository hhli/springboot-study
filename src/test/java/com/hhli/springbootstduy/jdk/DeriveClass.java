package com.hhli.springbootstduy.jdk;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.*;

/**
 * @author 李辉辉
 * @date 2020-02-29 16:19
 * @description
 */
@Setter
@Getter
@ToString(callSuper = true)
public class DeriveClass extends SuperClass implements Serializable {
    private static final long serialVersionUID = 6252798614467639194L;

    private String addr;

    public DeriveClass(String name, int age, String email, String addr) {
        super(name, age, email);
        this.addr = addr;
    }


    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();
        outputStream.writeObject(getName());
        outputStream.writeInt(getAge());
        outputStream.writeObject(getEmail());
    }

    private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
        input.defaultReadObject();
        setName((String)input.readObject());
        setAge(input.readInt());
        setEmail((String)input.readObject());
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("序列化对象开始～～");

        File file =new File("4.txt");
        if(!file.exists()){
            file.createNewFile();
        }

        FileOutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        DeriveClass superClass=new DeriveClass("gong",27, "1301334028@qq.com", "BJ");

        objectOutputStream.writeObject(superClass);
        objectOutputStream.flush();
        objectOutputStream.close();
        outputStream.close();
        System.out.println("序列化对象结束～～");


        System.out.println("反序列化对象开始!");
        FileInputStream inputStream = new FileInputStream(new File("4.txt"));
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        DeriveClass temp = (DeriveClass)objectInputStream.readObject();
        System.out.println(temp.toString());
        System.out.println("反序列化对象结束!");
    }
}
