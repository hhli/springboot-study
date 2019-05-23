package com.hhli.springbootstduy.other;

import com.hhli.springbootstduy.jdk.Employee;

import java.util.Arrays;

/**
 * @author 李辉辉
 * @date 2019/5/22 22:53
 * @description 排序测试
 */
public class EmployeeSortTest {

    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("Harry Hacker", 35000);
        employees[1] = new Employee("Carl Cracker", 75000);
        employees[2] = new Employee("Tony Tester", 38000);

        Arrays.sort(employees);
        for (Employee employee : employees) {
            System.out.println("name=" + employee.getName() + ",salary=" + employee.getSalary());
        }
    }
}
