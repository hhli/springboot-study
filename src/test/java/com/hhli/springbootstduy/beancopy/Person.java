package com.hhli.springbootstduy.beancopy;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author 李辉辉
 * @date 2018/11/24 10:56
 * @description
 */
@Data
public class Person implements Serializable, Cloneable{

    private static final long serialVersionUID = -1314333804741402679L;

    /**
     *
     */
    private Home home;


    @Override
    public Person clone(){
        try {
            Person p = (Person) super.clone();

            if(Objects.nonNull(home)){
                p.setHome(home.clone());
            }

            return p;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
