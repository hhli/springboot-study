package com.hhli.springbootstduy.jdk;

import com.hhli.springbootstduy.io.SerialCloneable;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * @author 李辉辉
 * @date 2018/11/21 8:30
 * @description 我的理解通过访问器可以修改收敛，以及参数验证之类的动作
 */
@ToString
public  class Employee extends SerialCloneable implements Comparable<Employee>{
    private  static int nextId = 1;

    /**
     * 姓名
     */
    private String name;

    /**
     * 工资
     */
    private double salary;

    /**
     * 员工id标识
     */
    private int id;

    /**
     * 雇佣时间
     */
    private LocalDate hireDay;

    public Employee(){

    }

    public Employee(String n, double s){
        this.name = n;
        this.salary = s;
        hireDay = LocalDate.now();
    }

    public Employee(String n, double s, int year, int moth, int day){
        this.name = n;
        this.salary = s;
        hireDay = LocalDate.of(year, moth, day);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDay() {
        //
        if(Objects.isNull(this.hireDay))
            return null;
        else{
            return  LocalDate.of(hireDay.getYear(), hireDay.getMonthValue(), hireDay.getDayOfMonth());
        }
    }

    public void setHireDay(LocalDate hireDay) {
        if(Objects.isNull(this.hireDay)){
            this.hireDay = null;
        }else{
            this.hireDay = LocalDate.of(hireDay.getYear(), hireDay.getMonthValue(), hireDay.getDayOfMonth());
        }
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent /100;
        salary += raise;
    }

    public void setId(){
        this.id = nextId;
        nextId++;
    }

    public static  int getNextId(){
        return  nextId;
    }

    public int getId(){
        return  this.id;
    }

    @Override
    final public  Employee clone() throws CloneNotSupportedException {
        return  (Employee) super.clone();
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(salary, o.salary);
    }
}
