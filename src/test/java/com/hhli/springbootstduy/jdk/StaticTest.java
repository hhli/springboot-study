package com.hhli.springbootstduy.jdk;

/**
 * @author 李辉辉
 * @date 2019/5/11 19:15
 * @description 静态关键字测试
 */
public class StaticTest {

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Tom", 40000);
        staff[1] = new Employee("Dick", 60000);
        staff[2] = new Employee("Harry", 65000);

        for (Employee employee : staff) {
            System.out.println("name=" + employee.getName() + ",id=" + employee.getId() + ",salary=" + employee.getSalary());
        }

        int n = Employee.getNextId();
        System.out.println("Next available id=" + n);
    }
}
