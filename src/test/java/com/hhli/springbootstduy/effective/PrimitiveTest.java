package com.hhli.springbootstduy.effective;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

/**
 * @author 李辉辉
 * @date 2019-09-06 14:44
 * @description 基本类型测试
 */
public class PrimitiveTest {

    public static void main(String[] args) {
        //Integer temp = null;
        //if(temp == 0){
        //    System.out.println("hha");
        //}

        //translate the class name into a Class Object
        Class<? extends Set<String>> c1 = null;
        try {
            c1 = (Class<? extends Set<String>>)Class.forName("java.util.HashSet");
        } catch (ClassNotFoundException e) {
            fatalaError("Class not found");
        }

        Constructor<? extends Set<String>> cons = null;
        try {
            cons = c1.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            fatalaError("No parameterless constructor");
        }

        // Instantiate the set
        Set<String> s = null;
        try {
            s = cons.newInstance();
        } catch (InstantiationException e) {
            fatalaError("Constructor not instantiable");
        } catch (IllegalAccessException e) {
            fatalaError("Constructor not accessible");
        } catch (InvocationTargetException e) {
            fatalaError("Constructor does not  implement Set");
        }

        s.addAll(Arrays.asList("1", "5", "8", "4"));
        System.out.println(s);
    }

    public static  void fatalaError(String msg){
        System.out.println(msg);
        System.exit(1);
    }
}
