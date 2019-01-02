package com.hhli.springbootstduy.jvm;

import com.hhli.springbootstduy.model.other.Car;

import java.lang.ref.WeakReference;

/**
 * @author 李辉辉
 * @date 2019/1/2 10:35
 * @description
 */
public class WeakReferenceTest {


    public static void main(String[] args) {

        Car car = new Car(22000,"silver");
        WeakReference<Car> weakCar = new WeakReference<Car>(car);

        int i=0;

        while(true){
            System.out.println("here is the strong reference 'car' " + car);//use the strong reference in the while loop
            if(weakCar.get()!=null){
                i++;
                System.out.println("Object is alive for "+i+" loops - "+weakCar);
            }else{
                System.out.println("Object has been collected.");
                break;
            }
        }
    }

}
