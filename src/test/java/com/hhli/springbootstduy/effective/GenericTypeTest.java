package com.hhli.springbootstduy.effective;

import java.util.Collection;
import java.util.function.UnaryOperator;

/**
 * @author 李辉辉
 * @date 2019/8/20 9:00
 * @description 泛型测试
 */
public class GenericTypeTest {
    private static UnaryOperator<Object> IDENTITY_FN = (t)->t;

    @SuppressWarnings("unchecked")
    public static  <T> UnaryOperator<T> identityFunction(){
        return  (UnaryOperator<T>) IDENTITY_FN;
    }

    public static void main(String[] args) {
        //Collection<?> c = new ArrayList<>();
        //Object[] temp = new Long[1];
        //temp[0] = "111";
        //System.out.println(Arrays.toString(temp));

        //ArrayList<Object>[] temp = new ArrayList<>()[21];

        //Collection<?>[] temp = new Collection<?>[5];

        String[] strings = {"jute", "hemp", "nylon"};
        UnaryOperator<String> sameString = identityFunction();
        for (String string : strings) {
            System.out.println(sameString.apply(string));
        }

        Number[] numbers = {1, 2.0, 3L};
        UnaryOperator<Number> sameNumber = identityFunction();
        for (Number number : numbers) {
            System.out.println(sameNumber.apply(number));
        }
    }
}
