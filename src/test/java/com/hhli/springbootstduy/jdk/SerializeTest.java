package com.hhli.springbootstduy.jdk;

import java.io.*;

/**
 * @author 李辉辉
 * @date 2019-06-06 15:49
 * @description 序列化测试
 */
public class SerializeTest {

    public static void main(String[] args) {
        //Initializes The Object
        //User user = new User();
        //user.setName("hollis");
        //user.setGender("male");
        //user.setAge(23);
        //user.setBirthday(new Date());
        //System.out.println(user);

        Son son = new Son(1L, 2L);


        //Write Obj to file
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"))){
            oos.writeObject(son);
        }catch (IOException e){
            e.printStackTrace();
        }

        File file = new File("tempFile");
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            Son son1 = (Son) ois.readObject();
            System.out.println(son1);
        }catch(IOException e){

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
