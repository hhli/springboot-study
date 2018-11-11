package com.hhli.springbootstduy.jdk;

/**
 * @author 李辉辉
 * @date 2018/11/9 8:24
 * @description 深入研究字符串测试
 */
public class StringTest {

    public static void main(String[] args) {
        //String a1= "123";
        //String a2 = "123";
        //System.out.println(a1 == a2);
        //
        //String b1 = new String("123");
        //String b2 = new String("123");
        //System.out.println(b1 == b2);

        //String a = "123";
        //String b = new String("123");
        //String c = new String("123");
        //System.out.println(a == b);
        //System.out.println(a == b.intern());
        //System.out.println(c == b.intern());
        //System.out.println(c.intern() == b.intern());

        final String a1 = "ab";
        final String a2 = "cd";
        String a3 = a1 + a2;
        String a4 = "abcd";
        System.out.println(a3 == a4);
    }
}
