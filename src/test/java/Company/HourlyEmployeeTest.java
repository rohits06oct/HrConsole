
package Company;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class HourlyEmployeeTest {
    private HourlyEmployee hourlyEmployee;

    /**
     * take all the values from hourly employee with rate and pass to the constructor and Assert
     * both the pay's
     */
    @Test(dataProvider = "hourlyEmployeeClassWithRate", dataProviderClass = DataProviderClass.class, priority = 1, expectedExceptions = {
            IllegalArgumentException.class }, expectedExceptionsMessageRegExp = "Rate is invalid")
    public void testHourlyEmployeeWithRatePay_Correct(int empId, String firstName, String lastName, Date hireDate, int rate,
                                                      EmployeeType type, int pay) {
        hourlyEmployee = new HourlyEmployee(empId, firstName, lastName, hireDate, rate, type);
        Assert.assertEquals(hourlyEmployee.getMonthlySalary(), pay);
    }

    @Test(dataProvider = "hourlyEmployeeClassWithRateWrongLastName", dataProviderClass = DataProviderClass.class, priority = 4, expectedExceptions = {
            IllegalArgumentException.class }, expectedExceptionsMessageRegExp = "Last name is invalid")
    public void testHourlyEmployeeWithRate_WrongLastName(int empId, String firstName, String lastName, Date hireDate, int rate,
                                                         EmployeeType type, int pay) {
        hourlyEmployee = new HourlyEmployee(empId, firstName, lastName, hireDate, rate, type);
        Assert.assertEquals(hourlyEmployee.getMonthlySalary(), pay);
    }

    /**
     * take all the values from hourly employee without rate and pass to the constructor and Assert
     * both the pay's
     */
    @Test(dataProvider = "hourlyEmployeeClassWithoutRateWithWrongEmpId", dataProviderClass = DataProviderClass.class, priority = 2, expectedExceptions = {
            IllegalArgumentException.class }, expectedExceptionsMessageRegExp = "EmpId is invalid")
    public void testHourlyEmployeeWithOutRate_WrongEmpId(int empId, String firstName, String lastName, Date hireDate,
                                                         EmployeeType type, int pay) {
        hourlyEmployee = new HourlyEmployee(empId, firstName, lastName, hireDate, type);
        Assert.assertEquals(hourlyEmployee.getMonthlySalary(), pay);
    }

    @Test(dataProvider = "hourlyEmployeeClassWithoutRateWithWrongFirstName", dataProviderClass = DataProviderClass.class, priority = 3, expectedExceptions = {
            IllegalArgumentException.class }, expectedExceptionsMessageRegExp = "First name is invalid")
    public void testHourlyEmployeeWithOutRate_WrongFirstName(int empId, String firstName, String lastName, Date hireDate,
                                                             EmployeeType type, int pay) {
        hourlyEmployee = new HourlyEmployee(empId, firstName, lastName, hireDate, type);
        Assert.assertEquals(hourlyEmployee.getMonthlySalary(), pay);
    }
}
