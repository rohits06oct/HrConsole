
package Company;

import org.testng.annotations.DataProvider;

import java.util.Date;

public class DataProviderClass {
    static Date hireDate = new Date();

    /**
     * Data providers for Hourly Employee Give all values to without rate constructor
     */
    @DataProvider(name = "hourlyEmployeeClassWithoutRateWithWrongEmpId")
    public static Object[][] dataHourlyEmployeeClassWithoutRateWithWrongEmpId() {
        return new Object[][] { { 0, "Brajesh", "Kumar", hireDate, EmployeeType.Hourly, 11000 } };
    }

    @DataProvider(name = "hourlyEmployeeClassWithoutRateWithWrongFirstName")
    public static Object[][] dataHourlyEmployeeClassWithoutRateWithWrongFirstName() {
        return new Object[][] { { 423, "", "Raj", hireDate, EmployeeType.Hourly, 11000 } };
    }

    /**
     * Data providers for Hourly Employee Give all values to with rate constructor
     */
    @DataProvider(name = "hourlyEmployeeClassWithRate")
    public static Object[][] dataHourlyEmployeeClassWithRate() {
        return new Object[][] { { 232, "Brajesh", "Kumar", hireDate, 0, EmployeeType.Hourly, 25300 } };
    }

    @DataProvider(name = "hourlyEmployeeClassWithRateWrongLastName")
    public static Object[][] dataHourlyEmployeeClassWithRate_WrongLastName() {
        return new Object[][] { { 893, "Kanta", "", hireDate, 600, EmployeeType.Hourly, 66000 } };
    }

    /**
     * Data providers for Salaried Employee Give all values to without experience constructor
     */
    @DataProvider(name = "salariedEmployeeClassWithoutExperienceWrongEmpId")
    public static Object[][] dataSalariedEmployeeClassWithoutExperience_WrongEmpId() {
        return new Object[][] { { 0, "Suraj", "Tomar", hireDate, EmployeeType.Salaried, 25000 } };
    }

    @DataProvider(name = "salariedEmployeeClassWithoutExperienceWrongFirstName")
    public static Object[][] dataSalariedEmployeeClassWithoutExperience_WrongFirstName() {
        return new Object[][] { { 423, "", "Ojha", hireDate, EmployeeType.Salaried, 25000 } };
    }

    /**
     * Data providers for Salaried Employee Give all values to with experience constructor
     */
    @DataProvider(name = "salariedEmployeeClassWithExperience")
    public static Object[][] dataSalariedEmployeeClassWithExperience() {
        return new Object[][] { { 36, "Suraj", "Tomar", hireDate, 50, EmployeeType.Salaried, 37500 } };
    }

    @DataProvider(name = "salariedEmployeeClassWithExperienceWrongLastName")
    public static Object[][] dataSalariedEmployeeClassWithExperience_WrongLastName() {
        return new Object[][] { { 100, "Rahul", "", hireDate, 4, EmployeeType.Salaried, 35000 } };
    }

    /**
     * Data providers for addEmployee Give all values to Hourly Employee constructor with rate
     */
    @DataProvider(name = "addHourlyEmployeeWith_Rate")
    public static Object[][] data_AddHourlyEmployee_WithRate() {
        return new Object[][] { { 10, "Rajat", "Bindal", hireDate, 300, EmployeeType.Hourly, 33000 } };
    }

    /**
     * Data providers for addEmployee Give all values to Hourly Employee constructor withOut rate
     */
    @DataProvider(name = "addHourlyEmployeeWithOut_Rate")
    public static Object[][] data_AddHourlyEmployee_WithoutRate() {
        return new Object[][] { { 41, "Ram", "Kumar", hireDate, EmployeeType.Hourly } };
    }

    /**
     * Data providers for addEmployee Give all values to Salaried Employee constructor with
     * experience
     */
    @DataProvider(name = "addSalariedEmployeeWith_Experience")
    public static Object[][] data_AddSalariedEmployee_WithExperience() {
        return new Object[][] { { 14, "Jeevan", "Gangwar", hireDate, 5, EmployeeType.Salaried, 37500 } };
    }

    /**
     * Data providers for addEmployee Give all values to Salaried Employee constructor withOut
     * experience
     */
    @DataProvider(name = "addSalariedEmployeeWithOut_Experience")
    public static Object[][] data_AddSalariedEmployee_WithOutExperience() {
        return new Object[][] { { 32, "Tekken", "4", hireDate, EmployeeType.Salaried } };
    }

    /**
     * Data providers for employeeDetailsDisplay
     */
    @DataProvider(name = "employeeDetailsDisplay")
    public static Object[][] data_EmployeeDetailsDisplay() {
        return new Object[][] { { 100, "Rajat" }, { 32, "Tekken" } };
    }

    /**
     * Data providers for employeePayOfDisplay
     */
    @DataProvider(name = "employeePayOfDisplay")
    public static Object[][] data_EmployeePayOfDisplay() {
        return new Object[][] { { 41, 11000 }, { 148, 37500 } };
    }

    /**
     * Data providers for removeEmployee
     */
    @DataProvider(name = "removeEmployee")
    public static Object[][] data_RemoveEmployee() {
        return new Object[][] { { 41, 3 }, { 14, 2 } };
    }
}
