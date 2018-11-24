package com.hhli.springbootstduy.jdk;

/**
 * @author 李辉辉
 * @date 2018/11/21 8:17
 * @description 员工测试
 */
public class EmployeeTest {

    public static void main(String[] args) {
        // fill the staff array with three employee objects
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        for(Employee e : staff){
            e.raiseSalary(5.0);
        }

        //printf out information about all Employee objects
        for(Employee e : staff){
            System.out.println("name=" + e.getName() + ", salary=" + e.getSalary() + ",hireDay=" +e.getHireDay());
        }

        Employee cloneEmployee = staff[0].clone();
        System.out.println(cloneEmployee == staff[0]);
        //测试克隆之后 引用字段是否更改
        //默认浅拷贝或者浅clone（如果访问器对于引用字段返回的是直接引用）
        //如果返回的不是直接引用，那么类似重新克隆生成的对象，那么则是深度clone
        System.out.println(cloneEmployee.getHireDay() == staff[0].getHireDay());
    }
}

