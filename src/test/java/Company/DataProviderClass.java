
package Company;

import org.testng.annotations.DataProvider;

import java.util.Date;

public class DataProviderClass {
    static Date hireDate = new Date();

    /**
     * Data providers for Hourly Employee Give all values to without rate constructor
     */
    @DataProvider(name = "hourlyEmployeeClassWithoutRate")
    public static Object[][] dataHourlyEmployeeClassWithoutRate() {
        return new Object[][] { { 0, "", "Kumar", hireDate, EmployeeType.Hourly, 11000 },
                { 423, "Kanta", "Raj", hireDate, EmployeeType.Hourly, 11000 } };
    }

    /**
     * Data providers for Hourly Employee Give all values to with rate constructor
     */
    @DataProvider(name = "hourlyEmployeeClassWithRate")
    public static Object[][] dataHourlyEmployeeClassWithRate() {
        return new Object[][] { { 232, "Brajesh", "Kumar", hireDate, 0, EmployeeType.Hourly, 25300 },
                { 893, "Kanta", "Raj", hireDate, 600, EmployeeType.Hourly, 66000 } };
    }

    /**
     * Data providers for Salaried Employee Give all values to without experience constructor
     */
    @DataProvider(name = "salariedEmployeeClassWithoutExperience")
    public static Object[][] dataSalariedEmployeeClassWithoutRate() {
        return new Object[][] { { 0, "Suraj", "Tomar", hireDate, EmployeeType.Salaried, 25000 },
                { 423, "Rahul", "Ojha", hireDate, EmployeeType.Salaried, 25000 } };
    }

    /**
     * Data providers for Salaried Employee Give all values to with experience constructor
     */
    @DataProvider(name = "salariedEmployeeClassWithExperience")
    public static Object[][] dataSalariedEmployeeClassWithRate() {
        return new Object[][] { { 36, "Suraj", "Tomar", hireDate, 50, EmployeeType.Salaried, 37500 },
                { 100, "Rahul", "Ojha", hireDate, 4, EmployeeType.Salaried, 35000 } };
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
