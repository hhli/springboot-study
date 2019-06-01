package com.hhli.springbootstduy.jdk;

import java.util.Objects;

/**
 * @author 李辉辉
 * @date 2019/6/1 18:35
 * @description 部件
 */
public class Item implements Comparable<Item>{
    private String description;
    private int partNumber;

    public Item(String aDescription, int partNumber){
        this.description = aDescription;
        this.partNumber = partNumber;
    }

    public String getDescription(){
        return this.description;
    }

    @Override
    public String toString(){
        return  "[description=" + this.description +", partNumber=" + this.partNumber + "]";
    }

    @Override
    public boolean equals(Object otherObject){
        if(this == otherObject) return true;
        if(Objects.isNull(otherObject)) return  false;
        if(getClass() != otherObject.getClass()) return false;

        Item other = (Item)otherObject;
        return Objects.equals(description, other.description) && partNumber == other.partNumber;
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.description, this.partNumber);
    }
    @Override
    public int compareTo(Item o) {
        return Integer.compare(partNumber, o.partNumber);
    }
}
