
package Company;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class SalariedEmployeeTest {
    private SalariedEmployee salariedEmployee;

    /**
     * take all the values from salaried employee with experience and pass to the constructor and
     * Assert both the pay's
     */
    @Test(dataProvider = "salariedEmployeeClassWithExperience", dataProviderClass = DataProviderClass.class, priority = 2, expectedExceptions = {
            IllegalArgumentException.class }, expectedExceptionsMessageRegExp = "Experience is Invalid")
    public void testSalariedEmployeeWithExperience(int empId, String firstName, String lastName, Date hireDate, int experience,
                                                   EmployeeType type, int pay) {
        salariedEmployee = new SalariedEmployee(empId, firstName, lastName, hireDate, experience, type);
        Assert.assertEquals(salariedEmployee.getMonthlySalary(), pay);
    }

    @Test(dataProvider = "salariedEmployeeClassWithExperienceWrongLastName", dataProviderClass = DataProviderClass.class, priority = 2, expectedExceptions = {
            IllegalArgumentException.class }, expectedExceptionsMessageRegExp = "Last name is invalid")
    public void testSalariedEmployeeWithExperience_WrongLastName(int empId, String firstName, String lastName, Date hireDate,
                                                                 int experience, EmployeeType type, int pay) {
        salariedEmployee = new SalariedEmployee(empId, firstName, lastName, hireDate, experience, type);
        Assert.assertEquals(salariedEmployee.getMonthlySalary(), pay);
    }

    /**
     * take all the values from salaried employee without experience and pass to the constructor and
     * Assert both the pay's
     */
    @Test(dataProvider = "salariedEmployeeClassWithoutExperienceWrongEmpId", dataProviderClass = DataProviderClass.class, priority = 4, expectedExceptions = {
            IllegalArgumentException.class }, expectedExceptionsMessageRegExp = "EmpId is invalid")
    public void testSalariedEmployeeWithOutExperience_WrongEmpId(int empId, String firstName, String lastName, Date hireDate,
                                                                 EmployeeType type, int pay) {
        salariedEmployee = new SalariedEmployee(empId, firstName, lastName, hireDate, type);
        Assert.assertEquals(salariedEmployee.getMonthlySalary(), pay);
    }

    @Test(dataProvider = "salariedEmployeeClassWithoutExperienceWrongFirstName", dataProviderClass = DataProviderClass.class, priority = 3, expectedExceptions = {
            IllegalArgumentException.class }, expectedExceptionsMessageRegExp = "First name is invalid")
    public void testSalariedEmployeeWithOutExperience_WrongFirstName(int empId, String firstName, String lastName, Date hireDate,
                                                                     EmployeeType type, int pay) {
        salariedEmployee = new SalariedEmployee(empId, firstName, lastName, hireDate, type);
        Assert.assertEquals(salariedEmployee.getMonthlySalary(), pay);
    }
}
