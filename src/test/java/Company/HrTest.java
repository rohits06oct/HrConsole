package Company;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;

public class HrTest {
    private Employee employee;
    private Hr hr = new Hr();

    /**
     * Take all the data from dataProvider
     * and give it to the hourlyEmployee constructor with rate
     * and send the employee object to hire method
     * and store it inside json file
     * and assert the both the type's
     */
    @Test(priority = 1, dataProvider = "addHourlyEmployeeWith_Rate", dataProviderClass = DataProviderClass.class, expectedExceptions = {})
    public void addHourlyEmployee_WithRate_Correct(int empId, String firstName, String lastName, Date hireDate, int rate, EmployeeType type, int pay) throws IOException {
        employee = new HourlyEmployee(empId, firstName, lastName, hireDate, rate, type);
        hr.hire(employee);
        Assert.assertEquals(employee.getMonthlySalary(), pay);
    }

    /**
     * Take all the data from dataProvider
     * and give it to the hourlyEmployee constructor withOut rate
     * and send the employee object to hire method
     * and store it inside json file
     * and assert the both the type's
     */
    @Test(priority = 1, dataProvider = "addHourlyEmployeeWithOut_Rate", dataProviderClass = DataProviderClass.class, expectedExceptions = {})
    public void addHourlyEmployee_WithoutRate_Correct(int empId, String firstName, String lastName, Date hireDate, EmployeeType type) throws IOException {
        employee = new HourlyEmployee(empId, firstName, lastName, hireDate, type);
        hr.hire(employee);
        Assert.assertEquals(employee.getType(), EmployeeType.Hourly);
    }

    /**
     * Take all the data from dataProvider
     * and give it to the salariedEmployee constructor with experience
     * and send the employee object to hire method
     * and store it inside json file
     * and assert the both the type's
     */
    @Test(priority = 1, dataProvider = "addSalariedEmployeeWith_Experience", dataProviderClass = DataProviderClass.class, expectedExceptions = {})
    public void addSalariedEmployee_WithExperience_Correct(int empId, String firstName, String lastName, Date hireDate, int experience, EmployeeType type, int pay) throws IOException {
        employee = new SalariedEmployee(empId, firstName, lastName, hireDate, experience, type);
        hr.hire(employee);
        Assert.assertEquals(employee.getMonthlySalary(), pay);
    }

    /**
     * Take all the data from dataProvider
     * and give it to the salariedEmployee constructor withOut experience
     * and send the employee object to hire method
     * and store it inside json file
     * and assert the both the type's
     */
    @Test(priority = 1, dataProvider = "addSalariedEmployeeWithOut_Experience", dataProviderClass = DataProviderClass.class, expectedExceptions = {})
    public void addSalariedEmployee_WithOutExperience_Correct(int empId, String firstName, String lastName, Date hireDate, EmployeeType type) throws IOException {
        employee = new SalariedEmployee(empId, firstName, lastName, hireDate, type);
        hr.hire(employee);
        Assert.assertEquals(employee.getType(), EmployeeType.Salaried);
    }

    /**
     * Take the values from dataProvider
     * and assign to employee remove to remove that employee object
     * and assert both the json file object's size same
     */
    @Test(priority = 7, dataProvider = "removeEmployee", dataProviderClass = DataProviderClass.class, expectedExceptions = {})
    public void removeEmployee_Correct(long removeEmpId, int expectedSize) throws IOException, ParseException {
        int actualSize = hr.employee_Remove(removeEmpId);
        Assert.assertEquals(actualSize, expectedSize);
    }

    /**
     * Take the values from dataProvider
     * and assign to employeeDetails_Display to display all the required employee details
     * and assert both the name's same
     */
    @Test(priority = 2, dataProvider = "employeeDetailsDisplay", dataProviderClass = DataProviderClass.class, expectedExceptions = {NullPointerException.class})
    public void employeeDetails_Display_Correct(int displayEmpId, String expectedFirstName) throws IOException, ParseException {
        String actualFirstName = hr.employeeDetails_Display(displayEmpId);
        Assert.assertEquals(actualFirstName, expectedFirstName);
    }

    /**
     * Take the values from dataProvider
     * and assign to employeePayOf_Display to display all the required employee details
     * and assert both the employee pay's same
     */
    @Test(priority = 3, dataProvider = "employeePayOfDisplay", dataProviderClass = DataProviderClass.class, expectedExceptions = {NullPointerException.class})
    public void employeePayOf_Display_Correct(int displayEmpId, long expectedPay) throws IOException, ParseException {
        long actualPay = hr.employeePayOf_Display(displayEmpId);
        Assert.assertEquals(expectedPay, actualPay);
    }

    /**
     * Display all the hourly Employee's
     * and assert total number of hourly employee's
     */
    @Test(priority = 4, expectedExceptions = {})
    public void hourlyEmployee_Display_Correct() throws IOException, ParseException {
        int ActualSize = hr.hourlyEmployee_Display();
        Assert.assertEquals(ActualSize, 2);
    }

    /**
     * Display all the salaried Employee's
     * and assert total number of salaried employee's
     */
    @Test(priority = 5, expectedExceptions = {})
    public void salariedEmployee_Display_Correct() throws IOException, ParseException {
        int ActualSize = hr.salariedEmployee_Display();
        Assert.assertEquals(ActualSize, 2);
    }

    /**
     * Display all Employee's
     * and assert total number of employee's
     */
    @Test(priority = 6, expectedExceptions = {ParseException.class})
    public void allEmployees_Display_Correct() throws IOException, ParseException {
        int ActualSize = hr.allEmployees_Display();
        Assert.assertEquals(ActualSize, 4);
    }
}