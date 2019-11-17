package com.hhli.springbootstduy.serialize;

import lombok.Data;
import lombok.ToString;

import java.io.*;

/**
 * @author 李辉辉
 * @date 2019/11/2 16:49
 * @description
 */
@Data
@ToString(callSuper = true)
public class Temp extends TempFather implements Serializable{
    private static  final long serialVersionUID = 42L;

    /**
     * 年龄
     */
    private int age;

    /**
     * 体重（单位：kg）
     */
    private int weight;

    //private transient  TempNoSerialize serialize;

    /**
     *  如果readObject writeObject不使用默认方法，即使字段为non-serialize-class的引用也没有关系
     */
    private  transient TempNoSerialize serialize;


    public Temp(double money){
        super(money);
    }


    public Temp(double money, int age, int weight){
        super(money);
        if(age<0 || age>200){
            throw new IllegalArgumentException("年龄非法");
        }
        this.age = age;

        if(weight<0 || weight>1000){
            throw new IllegalArgumentException("体重非法");
        }
        this.weight = weight;
        this.serialize = new TempNoSerialize();
    }

    //private static  class TempProxy implements Serializable{
    //    /**
    //     * 年龄
    //     */
    //    private int age;
    //
    //    /**
    //     * 体重（单位：kg）
    //     */
    //    private int weight;
    //
    //    public TempProxy(Temp temp){
    //        System.out.println("TempProxy(Temp temp)");
    //        this.age = temp.age;
    //        this.weight = temp.weight;
    //    }
    //
    //    private Object readResolve(){
    //        System.out.println("TempProxy readSolve");
    //        //throw  new RuntimeException("test");
    //        Temp temp = new Temp(age, weight);
    //        System.out.println("resolveObject：" + temp);
    //        return temp;
    //    }
    //
    //}

    //public Object writeReplace(){
    //    System.out.println("Temp.writeReplace()");
    //    return new TempProxy(this);
    //}
    //
    //private void writeObject(ObjectOutputStream out) {
    //    System.out.println("Temp.writeObject()");
    //}
    //
    //private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
    //    System.out.println("Temp.readObject()");
    //    throw new InvalidObjectException("Proxy required");
    //}

    private void writeObject(java.io.ObjectOutputStream out) throws IOException{
        //https://stackoverflow.com/questions/16239239/why-does-the-defaultwriteobject-function-have-to-be-called-first-when-writing-in
        //第一行应该是default
        out.defaultWriteObject();
        out.writeInt(age);
        out.writeInt(weight);
        out.writeDouble(money);
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException{
        //第一行应该是default
        in.defaultReadObject();
        age = in.readInt();
        weight = in.readInt();
        money = in.readDouble();
    }


    public static void main(String[] args) {
        /**
         * 学习参考：
         * 1、https://juejin.im/post/5b56f7b75188256256697281
         * 2、
         */
        byte[] bytes = Util.serialize(new Temp(1.1, 18, 50));
        Temp t = (Temp)Util.deserialize(bytes);

        System.out.println(t);
    }
}
