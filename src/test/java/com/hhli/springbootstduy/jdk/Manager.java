package com.hhli.springbootstduy.jdk;

/**
 * @author 李辉辉
 * @date 2019/5/14 8:40
 * @description
 */
public class Manager extends Employee{
    private double bonus;

    public Manager(double bonus){
        super();
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

    public static void main(String[] args) {
        //Employee e1 = new Manager(5000);
        //e1.setSalary(80000);
        //
        //Employee e2 = new Employee();
        //e2.setSalary(5000);
        //System.out.println(e1.getSalary() + ":" + e2.getSalary());

        Manager[] managers = new Manager[10];
        Employee[] employees = managers;
        employees[0] = new Employee();
        managers[0].setBonus(11);
    }
}
