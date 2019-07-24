package com.hhli.springbootstduy.io;

import java.io.*;

/**
 * @author 李辉辉
 * @date 2019/7/22 8:41
 * @description
 */
public class IoTest2 implements Externalizable{


    //private void readObject(ObjectInputStream in){
    //
    //}
    //
    //private void writeObject(ObjectOutputStream out){
    //
    //}

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }

    public static void main(String[] args) {
        new File("").toPath();
    }
}
