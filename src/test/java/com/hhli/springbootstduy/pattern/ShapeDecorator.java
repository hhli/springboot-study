package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2020-02-12 15:45
 * @description
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        decoratedShape.draw();
    }
}
