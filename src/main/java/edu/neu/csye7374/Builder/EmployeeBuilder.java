package edu.neu.csye7374.Builder;

import edu.neu.csye7374.Employee;
import edu.neu.csye7374.Factory.EmployeeFactory;

public class EmployeeBuilder implements BuilderAPI<Employee> {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private double wage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public EmployeeBuilder(int id, int age, String firstName, String lastName, double wage) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.wage = wage;
    }

    public EmployeeBuilder(String s) {
        String[] tokens = s.split(",");
        this.id = Integer.parseInt(tokens[0]);
        this.firstName = tokens[1];
        this.lastName = tokens[2];
        this.age = Integer.parseInt(tokens[3]);
        this.wage = Double.parseDouble(tokens[4]);
    }

    @Override
    public Employee build() {
        // TODO Auto-generated method stub
        return EmployeeFactory.getInstance().getObject(this);
    }
}
