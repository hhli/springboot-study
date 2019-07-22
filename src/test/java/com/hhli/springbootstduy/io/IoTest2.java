package com.hhli.springbootstduy.io;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

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
}
