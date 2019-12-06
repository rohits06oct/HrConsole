package Company;

import java.util.Date;
import java.util.InputMismatchException;

public class HourlyEmployee extends Employee {
    private int hour;
    private int rate;
    final private int defaultHour = 110;
    final private int defaultRate = 100;

    public HourlyEmployee(int empId, String firstName, String lastName, Date hireDate, int rate, EmployeeType type) throws NullPointerException, InputMismatchException, IllegalArgumentException {
        super(empId, firstName, lastName, hireDate, type);
        this.rate = rate;
        setPay();
    }

    public HourlyEmployee(int empId, String firstName, String lastName, Date hireDate, EmployeeType type) throws IllegalArgumentException {
        super(empId, firstName, lastName, hireDate, type);
        this.hour = defaultHour;
        this.rate = defaultRate;
        setPay();
    }

    /**
     * Abstract method extends from employee
     * Get the salary of the employee per month
     * and also check rate should not zero and greater than 2000
     */
    public void setPay() throws IllegalArgumentException {
        if (rate != 0 && rate <= 2000) {
            monthlySalary = defaultHour * rate;
        } else {
            throw new IllegalArgumentException("Rate is invalid");
        }
    }

    public int getRate() {
        return rate;
    }
}
