
package Company;

import java.util.Date;
import java.util.InputMismatchException;

public class SalariedEmployee extends Employee {
    private int salary;
    private int experience;
    final private int defaultSalary = 300000;
    final private int defaultExperience = 0;

    public SalariedEmployee(int empId, String firstName, String lastName, Date hireDate, int experience, EmployeeType type)
            throws NullPointerException, InputMismatchException, IllegalArgumentException {
        super(empId, firstName, lastName, hireDate, type);
        this.experience = experience;
        setPay();
    }

    public SalariedEmployee(int empId, String firstName, String lastName, Date hireDate, EmployeeType type)
            throws IllegalArgumentException {
        super(empId, firstName, lastName, hireDate, type);
        this.salary = defaultSalary;
        this.experience = defaultExperience;
        setPay();
    }

    /**
     * Abstract method extends from employee Get the salary of the employee per month and also check
     * experience should be less then 30
     */
    public void setPay() throws IllegalArgumentException {
        if (experience <= 30) {
            float percentage = (float) experience / 10;
            monthlySalary = (int) (percentage * defaultSalary / 12 + defaultSalary / 12);
        } else {
            throw new IllegalArgumentException("Experience is Invalid");
        }
    }

    public int getExperience() {
        return experience;
    }
}
