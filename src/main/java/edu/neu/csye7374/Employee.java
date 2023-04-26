package edu.neu.csye7374;

import edu.neu.csye7374.Builder.EmployeeBuilder;

public class Employee extends Person {

    private double wage;

    public Employee(EmployeeBuilder builder) {
        super(builder.getId(), builder.getAge(), builder.getFirstName(), builder.getLastName());
        this.wage = builder.getWage();
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "\nEmployee [" + super.toString() + ", wage= " + wage + "]";
    }
}
