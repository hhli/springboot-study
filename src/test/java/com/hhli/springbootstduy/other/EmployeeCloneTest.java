package com.hhli.springbootstduy.other;

import com.hhli.springbootstduy.jdk.Employee;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author 李辉辉
 * @date 2019/5/23 9:08
 * @description clone测试
 */
public class EmployeeCloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Employee original = new Employee("hhli", 50000);
        original.setHireDay(LocalDate.of(2000, 1, 1));

        Employee copy = original.clone();
        copy.raiseSalary(10);
        copy.setHireDay(LocalDate.of(2002,10, 10));

        System.out.println("original=" + original);

        System.out.println("copy=" + copy);
    }
}
