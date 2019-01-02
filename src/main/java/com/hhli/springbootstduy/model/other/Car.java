package com.hhli.springbootstduy.model.other;

/**
 * @author 李辉辉
 * @date 2019/1/2 10:32
 * @description
 */
public class Car {
    private double price;
    private String colour;

    public Car(double price, String colour){
        this.price = price;
        this.colour = colour;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getColour() {
        return colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }

    public String toString(){
        return colour +"car costs $"+price;
    }

}
