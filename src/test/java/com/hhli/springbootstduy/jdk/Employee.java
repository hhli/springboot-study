package com.hhli.springbootstduy.jdk;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * @author 李辉辉
 * @date 2018/11/21 8:30
 * @description 我的理解通过访问器可以修改收敛，以及参数验证之类的动作
 */
public  class Employee implements Cloneable{

    /**
     * 姓名
     */
    private String name;

    /**
     * 工资
     */
    private double salary;

    /**
     *
     */
    private Date hireDay;

    public Employee(String n, double s, int year, int moth, int day){
        String name = n;
        this.name = n;
        this.salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, moth-1, day);
        hireDay = calendar.getTime();
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

    public Date getHireDay() {
        //
        if(Objects.isNull(this.hireDay))
            return null;
        else{
            return (Date) this.hireDay.clone();
        }
    }

    public void setHireDay(Date hireDay) {
        if(Objects.isNull(this.hireDay)){
            this.hireDay = null;
        }else{
            this.hireDay = (Date) this.hireDay.clone();
        }
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent /100;
        salary += raise;
    }

    @Override
    public  Employee clone(){
        Employee e = null;
        try {
            e = (Employee)super.clone();
        } catch (CloneNotSupportedException e1) {
            e1.printStackTrace();
        }
        return  e;
    }
}
