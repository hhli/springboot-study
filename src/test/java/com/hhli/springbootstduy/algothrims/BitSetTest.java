package com.hhli.springbootstduy.algothrims;
import java.util.BitSet;

/**
 * @author 李辉辉
 * @date 2020-04-13 21:50
 * @description
 */
public class BitSetTest {

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(retainAll(new int[]{1,2, 3}, new int[]{1,2, 3})));
        BitSet tempSet = new BitSet();

        //for (int i = 0; i < Integer.MAX_VALUE; i++) {
        //    tempSet.set(i);
        //    System.out.println(i);
        //}

        tempSet.set(1);
        tempSet.set(56);
        System.out.println(1>>1 + 1>>56);
        System.out.println(tempSet.cardinality());
    }

    public static int[] retainAll(int[] array1, int[] array2){
        BitSet tempSet = new BitSet();
        for (int i : array1) {
            tempSet.set(i);
        }

        int setLen = tempSet.length()-1;
        for (int j : array2) {
            if(tempSet.get(j)){
                tempSet.clear(j);
                setLen--;
            }
        }

        int index  = 0;
        int[] result = new int[array1.length - setLen];
        if(result.length>0){
            for (int i : array1) {
                if(!tempSet.get(i)){
                    result[index++] = i;
                }
            }
        }

        return result;
    }
}
