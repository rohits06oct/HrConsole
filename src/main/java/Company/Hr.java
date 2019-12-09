
package Company;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Hr {
    private int value;
    private int empId;
    private String firstName;
    private String lastName;
    private Date hireDate;
    private EmployeeType type;
    private int rate;
    private int experience;
    private String path = System.getProperty("user.dir");
    private String filePath = path + "/src/main/resources/Employee.json";
    JsonUtil jsonUtil = new JsonUtil();
    JSONObject employeeJsonObject = new JSONObject();
    JSONArray employeeJsonArray = new JSONArray();
    ObjectMapper mapper = new ObjectMapper();

    /**
     * This method is main for hire, remove, display of an employee Using to switch cases we are
     * having 7 different types of cases of an employee and two different employee type's also
     */
    public void hrSolution()
            throws IOException, NullPointerException, InputMismatchException, IllegalArgumentException, ParseException {
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Print Employee Details");
            System.out.println("4. Pay Of Employee");
            System.out.println("5. Print All Hourly Employees");
            System.out.println("6. Print All Salaried Employees");
            System.out.println("7. Print All Employees");
            System.out.println("Please enter a key to perform task");
            value = s.nextInt();
            switch (value) {
                /**
                 * Here add an employee Take the empId, firstName, lastName, hireDate, type, rate
                 * and experience from different scenarios by the HR
                 */
                case 1:
                    System.out.println("Enter Employee Id");
                    empId = s.nextInt();
                    System.out.println("Enter First Name");
                    firstName = s.next();
                    System.out.println("Enter Last Name");
                    lastName = s.next();
                    System.out.println("Hiring Date (Format is DD/MM/YYYY)");
                    hireDate = new Date();
                    System.out.println("Please enter the type of employee");
                    System.out.println("1. Hourly Employee");
                    System.out.println("2. Salaried Employee");
                    System.out.println("Please enter a key");
                    value = s.nextInt();
                    switch (value) {
                        case 1:
                            System.out.println("Press 1 if you want to give rate\nPress any key to set default");
                            value = s.nextInt();
                            if (value == 1) {
                                type = EmployeeType.Hourly;
                                System.out.println("Enter the employee working rate");
                                rate = s.nextInt();
                                hire(new HourlyEmployee(empId, firstName, lastName, hireDate, rate, type));
                                break;
                            } else {
                                type = EmployeeType.Hourly;
                                hire(new HourlyEmployee(empId, firstName, lastName, hireDate, type));
                                break;
                            }
                        case 2:
                            System.out.println("Press 1 if you want to give experience\nPress any key to set default");
                            value = s.nextInt();
                            if (value == 1) {
                                type = EmployeeType.Salaried;
                                System.out.println("Enter the employee experience");
                                experience = s.nextInt();
                                hire(new SalariedEmployee(empId, firstName, lastName, hireDate, experience, type));
                                break;
                            } else {
                                type = EmployeeType.Salaried;
                                hire(new SalariedEmployee(empId, firstName, lastName, hireDate, type));
                                break;
                            }
                        default:
                            type = EmployeeType.Salaried;
                            hire(new SalariedEmployee(empId, firstName, lastName, hireDate, type));
                            break;
                    }
                    break;
                /**
                 * Here remove an employee
                 */
                case 2:
                    System.out.println("Enter the employee id");
                    employee_Remove(s.nextLong());
                    break;
                /**
                 * Here print an employee detail by id
                 */
                case 3:
                    System.out.println("Enter the employee  id");
                    employeeDetails_Display(s.nextInt());
                    break;
                /**
                 * Here print pay of employee detail by id
                 */
                case 4:
                    System.out.println("Enter the employee id");
                    employeePayOf_Display(s.nextInt());
                    break;
                /**
                 * Here print all hourly employee's
                 */
                case 5:
                    hourlyEmployee_Display();
                    break;
                /**
                 * Here print all permanent employee's
                 */
                case 6:
                    salariedEmployee_Display();
                    break;
                /**
                 * Here print all employee's with details
                 */
                case 7:
                    allEmployees_Display();
                    break;

                default:
                    System.exit(0);
            }
        } while (value != 8);
    }

    /**
     * Get the object of employee Add to my JsonUtil file
     */
    public void hire(Employee emp) throws IOException {
        jsonUtil = new JsonUtil();
        jsonUtil.writeJson_Values(filePath, emp);
    }

    /**
     * Remove an employee by empId get all the employee object or values inside employeeJsonObject
     * search the object by giving removeEmpId get the object empId key --> value check if both
     * match then remove my employee object having that empId value again store all my remaining
     * objects or values
     */
    public int employee_Remove(long removeEmpId) throws NullPointerException, IOException, ParseException {
        employeeJsonArray = jsonUtil.readJson_Values(filePath);
        Iterator itr = employeeJsonArray.iterator();
        while (itr.hasNext()) {
            JSONObject searchEmpObject = (JSONObject) itr.next();
            long empId = (long) searchEmpObject.get("empId");
            if (empId == removeEmpId) {
                employeeJsonArray.remove(searchEmpObject);
                employeeJsonObject.put("Employee", employeeJsonArray);
                mapper.writeValue(new File(filePath), employeeJsonObject);
                System.out.println("You delete a employee successfully");
            }
        }
        return employeeJsonArray.size();
    }

    /**
     * Give an employee id get all the employee object or values inside employeeJsonObject search
     * the object by giving displayEmpId search all the different values give to keys and print it
     * values like - empId, full name, type, hiring date
     */
    public String employeeDetails_Display(int displayEmpId) throws NullPointerException, IOException, ParseException {
        String firstName = null;
        employeeJsonArray = jsonUtil.readJson_Values(filePath);
        Iterator itr = employeeJsonArray.iterator();
        while (itr.hasNext()) {
            JSONObject searchEmpObject = (JSONObject) itr.next();
            long empId = (long) searchEmpObject.get("empId");
            if (empId == displayEmpId) {
                System.out.println("\n" + empId);
                firstName = (String) searchEmpObject.get("firstName");
                String lastName = (String) searchEmpObject.get("lastName");
                System.out.println(firstName + " " + lastName);
                String type = (String) searchEmpObject.get("type");
                System.out.println(type);
                String hireDate = (String) searchEmpObject.get("hireDate");
                System.out.println(hireDate);
            }
        }
        return firstName;
    }

    /**
     * Give an employee id get all the employee object or values inside employeeObject search the
     * object by giving displayEmpId search all the different values give to keys and print it
     * values like - empId, full name, type, pay
     */
    public long employeePayOf_Display(int displayEmpId) throws NullPointerException, IOException, ParseException {
        long monthlySalary = 0;
        employeeJsonArray = jsonUtil.readJson_Values(filePath);
        Iterator itr = employeeJsonArray.iterator();
        while (itr.hasNext()) {
            JSONObject searchEmpObject = (JSONObject) itr.next();
            long empId = (long) searchEmpObject.get("empId");
            if (empId == displayEmpId) {
                System.out.println("\n" + empId);
                String firstName = (String) searchEmpObject.get("firstName");
                String lastName = (String) searchEmpObject.get("lastName");
                System.out.println(firstName + " " + lastName);
                String type = (String) searchEmpObject.get("type");
                System.out.println(type);
                monthlySalary = (long) searchEmpObject.get("monthlySalary");
                System.out.println(monthlySalary + "\n");
            }
        }
        return monthlySalary;
    }

    /**
     * get all the employee object or values inside employeeObject Convert employeeObject to map
     * iterate the hourlyObject by map.entry and get empId value all of them give this empId to
     * searchEmpObject check if type is equal to hourly employee then get all the required values to
     * give key and print it
     */
    public int hourlyEmployee_Display() throws IOException, ParseException {
        int count = 0;
        employeeJsonArray = jsonUtil.readJson_Values(filePath);
        Iterator itr = employeeJsonArray.iterator();
        while (itr.hasNext()) {
            JSONObject searchEmpObject = (JSONObject) itr.next();
            String type = (String) searchEmpObject.get("type");
            if (type.equalsIgnoreCase("Hourly")) {
                count++;
                long empId = (long) searchEmpObject.get("empId");
                System.out.println("\n" + empId);
                String firstName = (String) searchEmpObject.get("firstName");
                String lastName = (String) searchEmpObject.get("lastName");
                System.out.println(firstName + " " + lastName);
                System.out.println(type);
                String hireDate = (String) searchEmpObject.get("hireDate");
                System.out.println(hireDate);
                long monthlySalary = (long) searchEmpObject.get("monthlySalary");
                System.out.println(monthlySalary + "\n");
            }
        }
        return count;
    }

    /**
     * get all the employee object or values inside employeeObject Convert employeeObject to map
     * iterate the salariedObject by map.entry and get empId value all of them give this empId to
     * searchEmpObject check if type is equal to salaried employee then get all the required values
     * to give key and print it
     */
    public int salariedEmployee_Display() throws IOException, ParseException {
        int count = 0;
        employeeJsonArray = jsonUtil.readJson_Values(filePath);
        Iterator itr = employeeJsonArray.iterator();
        while (itr.hasNext()) {
            JSONObject searchEmpObject = (JSONObject) itr.next();
            String type = (String) searchEmpObject.get("type");
            if (type.equalsIgnoreCase("Salaried")) {
                count++;
                long empId = (long) searchEmpObject.get("empId");
                System.out.println("\n" + empId);
                String firstName = (String) searchEmpObject.get("firstName");
                String lastName = (String) searchEmpObject.get("lastName");
                System.out.println(firstName + " " + lastName);
                System.out.println(type);
                String hireDate = (String) searchEmpObject.get("hireDate");
                System.out.println(hireDate);
                long monthlySalary = (long) searchEmpObject.get("monthlySalary");
                System.out.println(monthlySalary + "\n");
            }
        }
        return count;
    }

    /**
     * Display all my employee values or json values get all the employee object or values inside
     * employeeObject Convert employeeObject to map and iterate the map get all the Id key inside
     * searchObject get all the required values and print it
     */
    public int allEmployees_Display() throws IOException, ParseException {
        employeeJsonArray = jsonUtil.readJson_Values(filePath);
        System.out.println("Total number of employee's inside company is : " + employeeJsonArray.size() + "\n");
        Iterator itr = employeeJsonArray.iterator();
        while (itr.hasNext()) {
            JSONObject searchEmpObject = (JSONObject) itr.next();
            long empId = (long) searchEmpObject.get("empId");
            System.out.println(empId);
            String firstName = (String) searchEmpObject.get("firstName");
            String lastName = (String) searchEmpObject.get("lastName");
            System.out.println(firstName + " " + lastName);
            String type = (String) searchEmpObject.get("type");
            System.out.println(type);
            String hireDate = (String) searchEmpObject.get("hireDate");
            System.out.println(hireDate);
            long monthlySalary = (long) searchEmpObject.get("monthlySalary");
            System.out.println(monthlySalary + "\n");
        }
        return employeeJsonArray.size();
    }
}
