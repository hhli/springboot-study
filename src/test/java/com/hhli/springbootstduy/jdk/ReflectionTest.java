package com.hhli.springbootstduy.jdk;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * @author 李辉辉
 * @date 2019/5/21 9:07
 * @description 反射测试
 */
public class ReflectionTest {

    public static void main(String[] args) throws ClassNotFoundException {
        // read class name from command line args or user input
        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name (eg: java.util.Date): ");
            name = in.next();
        }

        Class c1 = Class.forName(name);
        Class superC1 = c1.getSuperclass();
        String modifiers = Modifier.toString(c1.getModifiers());

        if (modifiers.length() > 0) System.out.print(modifiers + " ");
        System.out.print("class " + name);
        if (superC1 != null && superC1 != Object.class) {
            System.out.print(" extends " + superC1.getName());
        }
        System.out.print("\n{\n");

        printConstructors(c1);
        System.out.println();

        printMethods(c1);
        System.out.println();

        printFields(c1);
        System.out.println("}");

        System.exit(0);
    }

    public static void printConstructors(Class c1) {
        Constructor[] constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            String name = constructor.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(constructor.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");

            System.out.print(name + " (");

            Class[] paramTypes = constructor.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    public static void printMethods(Class c1) {
        Method[] methods = c1.getDeclaredMethods();
        for (Method method : methods) {
            Class returnType = method.getReturnType();
            String name = method.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(method.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");

            System.out.print(returnType.getName() + " " + name + " (");

            Class[] paramTypes = method.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    public static void printFields(Class c1){
        Field[] fields = c1.getFields();
        for (Field field : fields) {
            Class type = field.getType();
            String name  = field.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(field.getModifiers());
            if(modifiers.length()>0) System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";" );
        }
    }
}