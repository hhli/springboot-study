package com.hhli.springbootstduy.io;

import com.hhli.springbootstduy.jdk.Employee;
import com.hhli.springbootstduy.jdk.Manager;

import java.io.*;

/**
 * @author 李辉辉
 * @date 2019/7/21 18:36
 * @description
 */
public class ObjectStreamTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee harry= new Employee("Harry Hacker", 50000, 1989, 10, 1);

        Manager carl = new Manager("Carl Cracker", 75000, 1987, 12, 15);
        carl.setBonus(111);
        carl.setSecretary(harry);

        Manager tony = new Manager("Tony Tester", 40000, 1990, 3, 15);
        tony.setBonus(2222);
        tony.setSecretary(harry);

        Employee[] staff = new Employee[3];
        staff[0] = harry;
        staff[1] = carl;
        staff[2] = tony;

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee2.dat"))){
            out.writeObject(staff);
        }

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee2.dat"))){
            Employee[] newStaff = (Employee[])in.readObject();
            //提升secretary的工资
            newStaff[1].raiseSalary(10);

            for (Employee employee : newStaff) {
                System.out.println(employee);
            }
        }
    }
}
