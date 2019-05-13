package com.hhli.springbootstduy.doc;

/**
 * @author 李辉辉
 * @date 2019/5/13 22:40
 * @description test1
 */
public class Test1 {

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param  id  the initial capacity of the list
     * @param name the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity
     *         is negative
     */
    public Test1(Integer id, String name){
        this.id = id;
        this.name = name;
    }
}
