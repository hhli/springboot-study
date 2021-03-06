package com.hhli.springbootstduy.jdk;

import lombok.ToString;

/**
 * @author 李辉辉
 * @date 2019/5/14 8:40
 * @description
 */
@ToString
public class Manager extends Employee{

    /**
     * 秘书
     */
    private Employee secretary;

    /**
     * 奖金
     */
    private double bonus;

    public Manager(double bonus){
        super();
        this.bonus = bonus;
    }

    public Manager(String n, double s, int year, int moth, int day){
        super(n, s, year, moth, day);
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

    public Employee getSecretary() {
        return secretary;
    }

    public void setSecretary(Employee secretary) {
        this.secretary = secretary;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        //Employee e1 = new Manager(5000);
        //e1.setSalary(80000);
        //
        //Employee e2 = new Employee();
        //e2.setSalary(5000);
        //System.out.println(e1.getSalary() + ":" + e2.getSalary());

        //Manager[] managers = new Manager[10];
        //Employee[] employees = managers;
        //employees[0] = new Employee();
        //managers[0].setBonus(11);
        Manager m = new Manager(11);
        Manager m1 = (Manager)m.clone();
        System.out.println(m1);

    }
}
