package com.hhli.springbootstduy.pattern;

/**
 * @author 李辉辉
 * @date 2020-02-12 15:46
 * @description
 */
public class DecoratorPatternDemo {

    public static void main(String[] args) {
        Shape circle = new Circle();

        ShapeDecorator redCicrle = new RedShapeDecorator(new Circle());

        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("Circle of red border");
        redCicrle.draw();

        System.out.println("Rectangle of red border");
        redRectangle.draw();
    }
}
