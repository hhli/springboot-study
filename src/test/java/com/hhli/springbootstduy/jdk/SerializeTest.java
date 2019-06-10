package com.hhli.springbootstduy.jdk;

import java.io.*;
import java.util.Date;

/**
 * @author 李辉辉
 * @date 2019-06-06 15:49
 * @description 序列化测试
 */
public class SerializeTest {

    public static void main(String[] args) {
        //Initializes The Object
        User user = new User();
        user.setName("hollis");
        user.setGender("male");
        user.setAge(23);
        user.setBirthday(new Date());
        System.out.println(user);


        //Write Obj to file
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"))){
            oos.writeObject(user);
        }catch (IOException e){
            e.printStackTrace();
        }

        File file = new File("tempFile");
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            User user2 = (User)ois.readObject();
            System.out.println(user2);
        }catch(IOException e){

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
