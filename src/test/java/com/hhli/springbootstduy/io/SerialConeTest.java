package com.hhli.springbootstduy.io;

import com.hhli.springbootstduy.jdk.Employee;

/**
 * @author 李辉辉
 * @date 2019/7/22 9:13
 * @description 序列化克隆测试
 */
public class SerialConeTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Employee harry = new Employee("Harry Hacker", 35000, 1989, 10, 1);

        Employee harry2 =  harry.clone();

        harry.raiseSalary(10);

        System.out.println(harry);
        System.out.println(harry2);
    }
}
