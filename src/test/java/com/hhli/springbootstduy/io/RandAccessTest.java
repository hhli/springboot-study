package com.hhli.springbootstduy.io;

import com.hhli.springbootstduy.jdk.Employee;

import java.io.*;

/**
 * @author 李辉辉
 * @date 2019/7/21 17:53
 * @description 文件随机访问测试
 */
public class RandAccessTest {
    final static int RECORD_SIZE = 100;
    final static int NAME_SIZE = 40;
    public static void main(String[] args)
            throws IOException {

        Employee[] staffs = new Employee[3];

        staffs[0]= new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staffs[1]= new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staffs[2]= new Employee("Tony Tester", 40000, 1990, 3, 15);

        try(DataOutputStream out = new DataOutputStream(new FileOutputStream("employee.dat"))){
            for (Employee staff : staffs) {
                writeData(out, staff);
            }
        }

        try(RandomAccessFile  in = new RandomAccessFile("employee.dat", "r")){
            int n = (int)(in.length()/RECORD_SIZE);
            Employee[] newStaff = new Employee[n];

            for (int i = n - 1; i >= 0; i--) {
                in.seek(i * RECORD_SIZE);
                newStaff[i] = readData(in);
            }

            for (Employee employee : newStaff) {
                System.out.println(employee);
            }
        }
    }

    public static void writeData(DataOutputStream out, Employee e) throws IOException {
        DataIO.writeFixedString(e.getName(), NAME_SIZE, out);

        out.writeDouble(e.getSalary());
        out.writeInt(e.getHireDay().getYear());
        out.writeInt(e.getHireDay().getMonthValue());
        out.writeInt(e.getHireDay().getDayOfMonth());
    }

    public static  Employee readData(DataInput in) throws IOException {
        String name = DataIO.readFixedString(NAME_SIZE, in);
        double salary = in.readDouble();
        int year = in.readInt();
        int moth = in.readInt();
        int day = in.readInt();

        return  new Employee(name, salary, year, moth, day);
    }
}
