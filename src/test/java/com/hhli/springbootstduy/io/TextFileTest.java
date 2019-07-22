package com.hhli.springbootstduy.io;

import com.hhli.springbootstduy.jdk.Employee;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author 李辉辉
 * @date 2019/7/21 15:45
 * @description 文本文件读写测试
 */
public class TextFileTest {

    public static void main(String[] args)
            throws FileNotFoundException, UnsupportedEncodingException {
        Employee[] staffs = new Employee[3];

        staffs[0]= new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staffs[1]= new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staffs[2]= new Employee("Tony Tester", 40000, 1990, 3, 15);

        try(PrintWriter writer = new PrintWriter("employee.dat", StandardCharsets.UTF_8.displayName())){
            writeData(staffs, writer);
        }

        try(Scanner in = new Scanner(new FileInputStream("employee.dat"), StandardCharsets.UTF_8.displayName())){
            Employee[] newStaff = readData(in);
            for (Employee employee : newStaff) {
                System.out.println(employee);
            }
        }
    }

    public static void writeData(Employee[] staffs, PrintWriter writer){
        writer.println(staffs.length);
        for (Employee staff : staffs) {
            writeEmployee(writer, staff);
        }
    }

    public static  Employee[] readData(Scanner in){
        //读取数组长度
        int n = in.nextInt();
        in.nextLine();

        Employee[] staffs = new Employee[n];
        for (int i = 0; i < n; i++) {
            staffs[i] = readEmployee(in);
        }

        return staffs;
    }

    public  static  void writeEmployee(PrintWriter writer, Employee e){
        writer.println(e.getName() + "|" + e.getSalary() + "|" + e.getHireDay() );
    }

    public static Employee readEmployee(Scanner in){
        String line = in.nextLine();
        String[] tokens = line.split("\\|");

        String name = tokens[0];
        Double salary = Double.parseDouble(tokens[1]);

        LocalDate hireDate = LocalDate.parse(tokens[2]);
        int year = hireDate.getYear();
        int month = hireDate.getMonthValue();
        int day = hireDate.getDayOfMonth();

        return new Employee(name, salary, year, month, day);
    }
}
