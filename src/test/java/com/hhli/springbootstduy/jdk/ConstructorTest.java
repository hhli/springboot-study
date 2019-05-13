package com.hhli.springbootstduy.jdk;

import java.util.Random;

/**
 * @author 李辉辉
 * @date 2019/5/12 16:54
 * @description 构造器测试
 */
public class ConstructorTest {

    public static void main(String[] args) {
        ConstructorTest.Temp temp1= new ConstructorTest.Temp();
        System.out.println(temp1);

        ConstructorTest.Temp temp2 = new ConstructorTest.Temp();
        System.out.println(temp2);
    }

    static  class Temp{
        private static int nextId;
        private int id;
        private String name;

        static {
            nextId = new Random().nextInt(1000);
            System.out.println(nextId);
        }

        {
            id = nextId;
            nextId++;
        }

        public Temp(){
            this.name = "";
        }

        @Override
        public String toString(){
            return  this.id + ":" + this.name;
        }

    }
}
