package com.hhli.springbootstduy.effective;

import java.util.Set;

/**
 * @author 李辉辉
 * @date 2019/8/24 20:16
 * @description 植物
 */
public class Plant {
    enum LifeCycle{ANNUAL, PERENNITAL, BIENNIAL};

    private final String name;
    private final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle){
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString(){
        return name;
    }

    public static void main(String[] args) {
        Set<Plant>[] plants;
    }
}
