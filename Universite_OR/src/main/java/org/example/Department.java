package org.example;

public class Department {
    private String dept_name;
    private String name_d;
    private double salary;

    public Department(String dept_name, String name_d, double salary) {
        this.dept_name = dept_name;
        this.name_d = name_d;
        this.salary = salary;
    }

    public String getDeptName() { return dept_name; }
    public String getNameD()    { return name_d; }
    public double getSalary()   { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public void augmenterBudget(double montant) {
        this.salary += montant;
    }

    @Override
    public String toString() {
        return "Department[" + dept_name + ", " + name_d + ", " + salary + "]";
    }
}