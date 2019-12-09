
package Company;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.InputMismatchException;

abstract public class Employee {
    int monthlySalary;
    private int empId;
    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date hireDate;
    private EmployeeType type;

    public Employee(int empId, String firstName, String lastName, Date hireDate, EmployeeType type)
            throws NullPointerException, InputMismatchException, IllegalArgumentException {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
        this.type = type;
        checkEmpId();
    }

    /**
     * Abstract method
     */
    public abstract void setPay() throws IllegalArgumentException;

    public void checkEmpId() throws IllegalArgumentException {
        if (empId == 0) {
            throw new IllegalArgumentException("EmpId is invalid");
        }
    }

    public int getEmpId() {
        return empId;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Object getHireDate() {
        return hireDate;
    }

    public EmployeeType getType() {
        return type;
    }
}
