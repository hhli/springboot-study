package com.hhli.springbootstduy.io;

import java.io.*;

/**
 * @author 李辉辉
 * @date 2019/7/22 9:16
 * @description 序列化克隆
 */
public class SerialCloneable implements Cloneable, Serializable{

    public Object clone() throws CloneNotSupportedException {
        try{
            ByteArrayOutputStream bout = new ByteArrayOutputStream();

            try(ObjectOutputStream out = new ObjectOutputStream(bout)){
                out.writeObject(this);
            }

            try (InputStream bin = new ByteArrayInputStream(bout.toByteArray())){
                ObjectInputStream inputStream = new ObjectInputStream(bin);
                return inputStream.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            CloneNotSupportedException e2 = new CloneNotSupportedException();
            e2.initCause(e);
            throw  e2;
        }
    }
}
