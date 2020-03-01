package com.hhli.springbootstduy.jdk;

import lombok.*;

/**
 * @author 李辉辉
 * @date 2020-02-29 15:52
 * @description 序列化超类 具体参考https://juejin.im/post/5b56f7b75188256256697281
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SuperClass {
    //private static final long serialVersionUID = 800172032597346129L;

    private String name;

    private transient int age;

    private transient String email;

    //private void writeObject(ObjectOutputStream outputStream) throws IOException {
    //    outputStream.defaultWriteObject();
    //    outputStream.writeInt(age);
    //    outputStream.writeObject(email);
    //}
    //
    //private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    //    input.defaultReadObject();
    //    age = input.readInt();
    //    email = (String)input.readObject();
    //}
}
