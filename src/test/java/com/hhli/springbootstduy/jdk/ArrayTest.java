package com.hhli.springbootstduy.jdk;

import java.lang.reflect.Array;

/**
 * @author 李辉辉
 * @date 2018/11/5 8:45
 * @description 数组测试
 */
public class ArrayTest {

    public static void main(String... args) {
        //int[] a1 = new int[]{1,2,3,4};
        //int[] a2 = {1, 2, 3, 4};
        //int[] a3 = new int[4];
        //a3 = a2;
        //a3[1] = 8888;
        //System.out.println("a2:" +Arrays.toString(a2));
        //System.out.println("a3:" +Arrays.toString(a3));
        //
        //a3 = Arrays.copyOf(a2, a2.length);
        //a3[1] = 9999;
        //System.out.println("a2:" +Arrays.toString(a2));
        //System.out.println("a3:" +Arrays.toString(a3));

        //if("-h".equals(args[0])){
        //    System.out.print("Hello,");
        //}else if("-g".equals(args[1])){
        //    System.out.print("GoodBye,");
        //}
        //
        //for(int i=1; i<args.length; i++){
        //    System.out.print(" " + args[i]);
        //}
        //
        //System.out.println("!");

        //int[][] magicSquare = {
        //        {16, 3, 2, 13},
        //        {5, 10, 11, 8},
        //        {9, 6, 120, 8},
        //        {11, 23, 56, 78}
        //};
        //
        //System.out.println(Arrays.toString(magicSquare));
        //System.out.println(Arrays.deepToString(magicSquare));

        //NumberFormat format = NumberFormat.getCurrencyInstance();
        //System.out.println(format.format(0.10));
        //format = NumberFormat.getPercentInstance();
        //System.out.println(format.format(0.10));
        //
        //sqrt(1);

        //ArrayList<Integer> tempLst = new ArrayList<>();
        //tempLst.trimToSize();
        //
        ////System.out.println(tempLst.get(0));
        //
        //ArrayList temp = new ArrayList();
        //temp.add(new Employee());
        //temp.add(new Date());
        ////System.out.println(temp.get(0));
        //
        //
        //tempLst = (ArrayList<Integer>)temp;

        //System.out.printf("%d %s", new Object[]{1, "2"});

        //System.out.println(Enum.valueOf(RetCodeEnum.class, "SUCCESS"));

        //Field[] fields = Employee.class.getDeclaredFields();
        //AccessibleObject.setAccessible(fields, Boolean.TRUE);

        //test(new Employee[100]);
        //
        //try {
        //    Method m = Employee.class.getMethod("getNextId");
        //    m.setAccessible(Boolean.TRUE);
        //} catch (NoSuchMethodException e) {
        //    e.printStackTrace();
        //}

        //try {
        //    Method m = ArrayTest.class.getMethod("test", Object[].class);
        //    m.invoke(null, (Object) new Employee[100]);
        //} catch (NoSuchMethodException e) {
        //    e.printStackTrace();
        //} catch (IllegalAccessException e) {
        //    e.printStackTrace();
        //} catch (InvocationTargetException e) {
        //    e.printStackTrace();
        //}

        //StringBuilder builder = new StringBuilder();
        //String s = null;
        //builder.append(s);
        //System.out.println(builder.toString());



    }

    public static void test(Object[] temp){
        System.arraycopy(new Employee[100],0, new Object[100], 0, 100);
        System.out.println("done");
    }

    public static Object goodCopyOf(Object a, int newLength){
        Class c1 = a.getClass();
        if(!c1.isArray()) return null;
        Class componentType = c1.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }
}
