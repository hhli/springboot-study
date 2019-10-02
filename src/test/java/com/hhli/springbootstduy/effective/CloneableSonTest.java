package com.hhli.springbootstduy.effective;

/**
 * @author 李辉辉
 * @date 2019-09-29 18:56
 * @description
 */
public class CloneableSonTest extends CloneableTest{

    public static void main(String[] args) {
        CloneableSonTest test = new CloneableSonTest();
        System.out.println(test);
        System.out.println(test.clone());
    }

    @Override
    public CloneableSonTest clone(){
        return  (CloneableSonTest) super.clone();
    }
}
